package controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Shop;
import utils.Random;
import utils.SendSMS;
public class SendOTPServlet extends HttpServlet {
          
	public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException , ServletException{
		   
		HttpSession session = request.getSession();	
		Shop shop = (Shop)session.getAttribute("shop");
		if(shop != null) {
		String phone = request.getParameter("phone");
		int otp = Random.getOTP();
		String msg = "From Annapurna , this is one time OTP to verify your phone number is "+otp;
		//SendSMS.sendOTP(phone,msg);
		
		
		session.setAttribute("otp",otp);
		System.out.println(otp+"~~~~~~~~~~~~~~~~~~~~~~@");
		}
		response.getWriter().write("Otp sent successfully");
	}
}
