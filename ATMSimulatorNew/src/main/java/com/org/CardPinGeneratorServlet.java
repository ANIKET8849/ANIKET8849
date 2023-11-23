package com.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class CardPinGeneratorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
    	// Generate a 12-digit card number
        String cardNumber = generateCardNumber();

        // Generate a 4-digit PIN number
        String pinNumber = generatePinNumber();
        int pinNum=Integer.parseInt(pinNumber);

//        out.println("Your Account Created Sucessfully  !!!");
        String name=request.getParameter("input1");
        int age=Integer.parseInt(request.getParameter("input2"));
        String mobile=request.getParameter("input3");
        String aadhar=request.getParameter("input4");
        String pan=request.getParameter("input5");
        String actype=request.getParameter("input6");
        int amount=Integer.parseInt(request.getParameter("input7"));
        String addres=request.getParameter("input8");
        
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			Statement stat =conn.createStatement();
			 stat.executeUpdate("INSERT INTO account (name, card_no, pin, mobile_no, aadhar_no, pan_no, account_type, balence, address) VALUES ('" + name + "', '" + cardNumber + "', " + pinNum + ", '" + mobile + "', '" + aadhar + "', '" + pan + "', '" + actype + "', " + amount + ", '" + addres + "')");
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        
        
        // Set the generated card number and PIN number as attributes in the session
        HttpSession session = request.getSession();
        session.setAttribute("cardNumber", cardNumber);
        session.setAttribute("pinNumber", pinNumber);

        // Forward the request to the JSP page to display the generated numbers
        request.getRequestDispatcher("Card.jsp").forward(request, response);
        
    }

    // Generate a random 12-digit card number
    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

    // Generate a random 4-digit PIN number
    private String generatePinNumber() {
        Random random = new Random();
        StringBuilder pinNumber = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            pinNumber.append(random.nextInt(10));
        }
        return pinNumber.toString();
        
     
    }
}

