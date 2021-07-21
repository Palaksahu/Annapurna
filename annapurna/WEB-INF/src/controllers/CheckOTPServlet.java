package controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Shop;
public class CheckOTPServlet extends HttpServlet {
        
	public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException , ServletException{
		String respo = "signin"; 
		HttpSession session = request.getSession();
		Shop shop = (Shop)session.getAttribute("shop");
		if(shop != null) {
		Integer otp2 = (Integer)session.getAttribute("otp");
		  try {
	      
		  Integer otp = Integer.parseInt(request.getParameter("otp"));
		  
		  if(otp2.equals(otp)) {
			  
			  respo ="true";

			  
		  }else {
			  respo ="false";
		  }
		   
		  }catch(NullPointerException e) {
			  e.printStackTrace();
		  } 
	}
		response.getWriter().write(respo);
 }
}
