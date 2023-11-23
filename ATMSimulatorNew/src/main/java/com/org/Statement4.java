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

public class Statement4 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String card = request.getParameter("card");
        HttpSession session = request.getSession();
        session.setAttribute("card", card);
        request.getRequestDispatcher("Statement5.jsp").forward(request, response);
        
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root");
//            Statement stat = conn.createStatement();
//            ResultSet rs = stat.executeQuery("SELECT * FROM statement WHERE card_no='" + card + "'");
//
//            while(rs.next()) {
//            	
//           
//            if (rs.next()) {
//                String CARD = rs.getString("card_no");
//                int CREDIT = rs.getInt("creadit_amount");
//                int WITHDRAW = rs.getInt("withdraw_amount");
//                int AMOUNT = rs.getInt("amount");
//                
//                HttpSession session = request.getSession();
//                session.setAttribute("card_no", CARD);
//                session.setAttribute("creadit_amount", CREDIT);
//                session.setAttribute("withdraw_amount",WITHDRAW);
//                session.setAttribute("amount", AMOUNT);
//
//                // Forward the request to the JSP page to display the generated numbers
//                request.getRequestDispatcher("Statement5.jsp").forward(request, response);
//                
//                // Print or process the fetched data
////                out.println("CARD NO: " + CARD);
////                out.println("CREDIT AMOUNT: " + CREDIT);
////                out.println("WITHDRAW AMOUNT: " + WITHDRAW);
////                out.println("AMOUNT: " + AMOUNT);
//            } else {
//                out.println("Card number not found.");
//            }
//            }
//            
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}


