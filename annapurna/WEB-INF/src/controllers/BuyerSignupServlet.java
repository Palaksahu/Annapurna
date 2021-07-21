package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class BuyerSignupServlet extends HttpServlet{
           
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		
		request.getRequestDispatcher("buyer_signup.jsp").forward(request, response);
	}
}
