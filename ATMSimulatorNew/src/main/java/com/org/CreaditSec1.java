//package com.org;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//public class CreaditSec1 extends HttpServlet {
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out=response.getWriter();
//		
//		String card1=request.getParameter("card1");
//		int creadit1=Integer.parseInt(request.getParameter("creadit1"));
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("card1", card1);
//		session.setAttribute("creadit1", creadit1);
//		
////		  System.out.println(card1);
////	        System.out.println(creadit1);
//	        
//	        request.getRequestDispatcher("Statement4.java").forward(request, response);
//	}
//
//}






package com.org;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CreaditSec1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String card1 = request.getParameter("card1");
        int creadit1 = Integer.parseInt(request.getParameter("creadit1"));
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root");
            
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT balence FROM account WHERE card_no=" + card1);
            
            int balance = 0; 
            
            if (rs.next()) {
                balance = rs.getInt("balence");
            } else {
                out.println("No matching account found.");
                return;
            }
            
            if (creadit1 >= 0) {
            	int withdraw=0;
                int newBalance =  creadit1+ balance ;
                stat.executeUpdate("UPDATE account SET balence=" + newBalance + " WHERE card_no=" + card1);
                stat.executeUpdate("INSERT INTO statement (card_no, creadit_amount, withdraw_amount, amount) VALUES ('" + card1 + "'," + creadit1 + ", " + withdraw + "," + newBalance + ")");
                out.println("Amount"+creadit1+" Rs Creadited Sucessfully  In Your Account !!");
            } else {
                out.println("Invalid transaction.");
                return;
            }

            conn.close();
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred.");
        }
        
//        HttpSession session = request.getSession();
//        session.setAttribute("card1", card1);
//        session.setAttribute("creadit1", creadit1);
//        
//        request.getRequestDispatcher("/Statement4").forward(request, response);
    }
}

