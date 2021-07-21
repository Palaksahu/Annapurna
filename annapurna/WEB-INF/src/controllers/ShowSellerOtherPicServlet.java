package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Shop;

public class ShowSellerOtherPicServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response )throws IOException , ServletException{
		   
            String picPath = request.getParameter("picPath");	  
	   
	  
			OutputStream os = response.getOutputStream();
			
			InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/Shops/"+picPath);
			
			if(is == null) {
			 is = getServletContext().getResourceAsStream("/static/images/img-7.png");
			}
			byte[]  arr = new byte[256]; 
			int count = 0;
			while((count=is.read(arr))!= -1) {
				 
				os.write(arr);
			}
			
			
			os.flush();
			os.close();
			
		    
	    
	}
}
