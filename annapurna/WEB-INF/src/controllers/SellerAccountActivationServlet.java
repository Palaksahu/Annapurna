package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import models.*;
import utils.*;

public class SellerAccountActivationServlet extends HttpServlet {

	  public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
		  
		  String nextPage = "index.jsp";
		  
		  String  email = request.getParameter("email");
		  
		  String activationCode = request.getParameter("activation_code");
		
		  if(Shop.activation(email,activationCode)){
			  
			  nextPage = "seller_signin.do";
			  
		  }
		  request.getRequestDispatcher(nextPage).forward(request,response);
	  }
}
