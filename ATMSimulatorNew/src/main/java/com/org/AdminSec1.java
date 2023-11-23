package com.org;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AdminSec1 extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		out.println("Your Account Created Sucessfully  !!!");
		String name=request.getParameter("input1");
		int age=Integer.parseInt(request.getParameter("input2"));
		int mobile=Integer.parseInt(request.getParameter("input3"));
		String aadhar=request.getParameter("input4");
		String pan=request.getParameter("input5");
		String actype=request.getParameter("input6");
		int amount=Integer.parseInt(request.getParameter("input7"));
		String addres=request.getParameter("input8");
//		
//		Random random = new Random();
//		long cardNumber = (random.nextLong() % 900000000000L) + 100000000000L;
//
//		int pinNumber = random.nextInt(9000) + 1000;
		
	
//
//		class CardPinGenerator {
//		    public static void main(String[] args) {
//		        String cardNumber = generateCardNumber();
//		        String pinNumber = generatePinNumber();
//
////		        System.out.println("Generated Card Number: " + cardNumber);
////		        System.out.println("Generated PIN Number: " + pinNumber);
//		    }
//
//		    public static String generateCardNumber() {
//		    	AdminSec1 random = new AdminSec1();
//		        StringBuilder cardNumberBuilder = new StringBuilder();
//
//		        // Generate the first digit of the card number (must be between 1 and 9)
//		        int firstDigit = AdminSec1.nextInt(9) + 1;
//		        cardNumberBuilder.append(firstDigit);
//
//		        // Generate the remaining 11 digits of the card number
//		        for (int i = 0; i < 12; i++) {
//		            int digit = AdminSec1.nextInt(10);
//		            cardNumberBuilder.append(digit);
//		        }
//
//		        return cardNumberBuilder.toString();
//		    }
//
//		    public static String generatePinNumber() {
//		    	AdminSec1 random = new AdminSec1();
//		        StringBuilder pinNumberBuilder = new StringBuilder();
//
//		        // Generate a 4-digit PIN number
//		        for (int i = 0; i < 4; i++) {
//		            int digit = AdminSec1.nextInt(10);
//		            pinNumberBuilder.append(digit);
//		        }
//
//		        return pinNumberBuilder.toString();
	}

}
