package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Shop;

import java.io.IOException;
import javax.servlet.ServletException;

public class CheckEmailServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		
		String email = request.getParameter("email");
		
	 boolean exist  = Shop.exist(email);
	 
	 response.getWriter().print(exist);
	}
	
}
