package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
/**
* Servlet implementation class dtcc_servlet
*/
@WebServlet("/")
public class TestServlet extends HttpServlet {
            private static final long serialVersionUID = 1L;
 
    /**
     * Default constructor.
     */
    public TestServlet() {
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
                                    String sql = "INSERT INTO TRANSACTIONS (SECURITY_ID, CUSTOMER_ID, BROKER_ID, "
                            				+ "TRANS_TYPE, TIMEDATE, AMOUNT, PASS_FAIL, PURCHASE_PRICE, TOTAL_PRICE) "
                            				+ "VALUES (?,?,?,BUY,?,?,?,?,?,?)";
                                    int rows = stmt.executeUpdate(sql);
                                    response.getWriter().print("Added Rows " + rows);
                        } catch (Exception e) {
                                    e.printStackTrace();
                        }
            }
 
}
