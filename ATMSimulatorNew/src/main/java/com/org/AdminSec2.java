package com.org;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AdminSec2 extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
			
			String id=request.getParameter("input1");
			String pass=request.getParameter("input2");
			
			 if(id.equals("Admin1") && pass.equals("1234")){
			    	out.println("You Have Sucessfully Login !!");
			    	response.sendRedirect("Admin.jsp");
			    }
			 else{
			    	out.println("You Have Entered Wrong Id And Password !!!");
			    }
			
	}

}
