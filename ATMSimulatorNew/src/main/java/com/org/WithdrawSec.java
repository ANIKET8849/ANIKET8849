//package com.org;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//
//public class WithdrawSec extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        PrintWriter out = response.getWriter();
//
//        int withdraw = Integer.parseInt(request.getParameter("withdraw"));
//        String card = request.getParameter("card");
//        
//        
//        HttpSession session = request.getSession();
//        session.setAttribute("card", card);
//        session.setAttribute("withdraw", withdraw);
//        request.getRequestDispatcher("Statement4.java").forward(request, response);
//        
//    }
//}





package com.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class WithdrawSec extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        int withdraw = Integer.parseInt(request.getParameter("withdraw"));
        String card = request.getParameter("card");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root");
            
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT balence FROM account WHERE card_no=" + card);
            
            int balance = 0; 
            
            if (rs.next()) {
                balance = rs.getInt("balence");
            } else {
                out.println("No matching account found.");
                return;
            }
            
            if (withdraw >= 0) {
            	int creadit=0;
                int newBalance = balance - withdraw;
                stat.executeUpdate("UPDATE account SET balence=" + newBalance + " WHERE card_no=" + card);
                stat.executeUpdate("INSERT INTO statement (card_no, creadit_amount, withdraw_amount, amount) VALUES ('" + card + "'," + creadit + ", " + withdraw + "," + newBalance + ")");
                out.println("Amount"+withdraw+" Rs Withdraw Sucessfully !!");
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
//        session.setAttribute("card", card);
//        session.setAttribute("withdraw", withdraw);
//
//        request.getRequestDispatcher("/Statement4").forward(request, response);
    }
}
