package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Shop;
import models.ShopPic;

public class DelPicsServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response )throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		Shop shop = (Shop)session.getAttribute("shop");
		String resp = "false";
		if(shop!=null) {
			
			String picPath = request.getParameter("url");
			
			if(ShopPic.delPath(picPath)) {
				resp = "true";
			}
			
			
		   }else {
			resp = "expire";
		   }
		
		
		 response.getWriter().write(resp);
	}
	
  
}
