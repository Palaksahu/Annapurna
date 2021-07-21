package controllers;

import javax.servlet.http.HttpServlet;
import models.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;


public class SellerProfileServlet extends HttpServlet {
   
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		
		HttpSession session = request.getSession();
		
		Shop shop3 = (Shop)session.getAttribute("shop");
		  
	    String nextPage = "seller_profile.jsp";
		  
	    if(shop3 == null) {
			  nextPage = "seller_signin.jsp";
		  }
	
	    request.getRequestDispatcher(nextPage).forward(request, response);
		
	}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	   
		HttpSession session = request.getSession();
	   
		Shop shop3 = (Shop)session.getAttribute("shop");
	   
		String nextPage = "seller_signin.jsp";
		
		if(shop3 != null) {
		
			String name =	request.getParameter("name");
			String details =request.getParameter("details");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			
			int cityId = Integer.parseInt(request.getParameter("city"));
			
			City city = new City(cityId);
			
		   
		   if(shop3.updateProfile(name,details,address,phone,city)) {
		   
		     nextPage = "seller_homePage.jsp";
		   } 
	   }
         
		response.sendRedirect(nextPage);
	}
}
