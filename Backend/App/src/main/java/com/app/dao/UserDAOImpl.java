package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtcc.app.App.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	public String authenticateUser(User user) {
		System.out.println(user);
		String userId = user.getId();
		String password = user.getPassword();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";

		String usernameDB = "";
		String passwordDB = "";

		try {

			System.out.println("Connecting.....");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StockDB", "guest", "password");
			System.out.println("Connection successful! :)");
			System.out.println("Have we captured data? " + userId + " " + password);
			stmt = conn.createStatement();
			if (userId == null) {
				return "Must enter an Id and Password";
			} else {
				if (userId.charAt(0) == 'C') {
					sql = "SELECT CUSTOMER_ID, CUSTOMER_PWD FROM CUSTOMERS";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						usernameDB = rs.getString("CUSTOMER_ID");
						passwordDB = rs.getString("CUSTOMER_PWD");

						if (userId.equals(usernameDB) && password.equals(passwordDB)) {
							return "SUCCESS";
						}
					}
				} else if (userId.charAt(0) == 'B') {
					sql = "SELECT BROKER_ID, BROKER_PWD FROM BROKERS";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						usernameDB = rs.getString("BROKER_ID");
						passwordDB = rs.getString("BROKER_PWD");

						if (userId.equals(usernameDB) && password.equals(passwordDB)) {
							rs.close();
							return "SUCCESS";
						}
					}
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid login credentials";
	}
}
