package com.org;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class PinSec extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		int cpin=Integer.parseInt(request.getParameter("input1"));
		int npin=Integer.parseInt(request.getParameter("input2"));
		int rpin=Integer.parseInt(request.getParameter("input3"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			Statement stat =conn.createStatement();
		ResultSet rs=stat.executeQuery("select account.pin from account where pin='"+cpin+"'");
//		System.out.println(cpin);
//		System.out.println(npin);
//		System.out.println(rpin);

			if(rs.next()) {
				if(npin==rpin){
//					System.out.println(cpin);
					int rs1=stat.executeUpdate("UPDATE account SET pin='"+npin+"' where pin='"+cpin+"'");
					out.println("Your Pin Changed Sucessfully !!!");
					response.sendRedirect("Main.jsp");
				}
				else {
					out.println("Please Enter Valid New Pin !!!");
					response.sendRedirect("Pin.jsp");
				}
//				response.sendRedirect("Main.jsp");
			}
			else {
//				response.sendRedirect("Login.jsp");
				out.println("Please Enter Valid Pin !!!");
				response.sendRedirect("Pin.jsp");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
