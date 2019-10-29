package com.dtcc.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class App_Servlet
 */
@WebServlet("/")
public class App_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public App_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Connecting to a database...");
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StockDB", "guest", "password");
			Statement stmt = conn.createStatement();
			String sql = "SELECT security_ID, name, symbol, price FROM Security";
			ResultSet rows = stmt.executeQuery(sql);
			String id, name, symbol;
			double price;
			if(rows.next()) {
				id = rows.getString("security_ID");
				name = rows.getString("name");
				symbol = rows.getString("symbol");
				price = rows.getDouble("price");
			}
			else {
				id = null;
				name = null;
				symbol = null;
				price = 0.0;
			}
			response.getWriter().print("Name " + name + " Symbol " + symbol + " Price " + price);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
