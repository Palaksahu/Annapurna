package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Product;
import models.Shop;

public class EditProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		
		Integer productId= Integer.parseInt(request.getParameter("productId"));
		HttpSession session = request.getSession();
		
		Shop shop = (Shop)session.getAttribute("shop");
	   
		if(shop!=null) {
          
    	 Product product =  Product.editProduct(productId);
    	 product.setProductId(productId);
    	 session.setAttribute("product",product);
    	 
    	 
    	 response.getWriter().write("true");
    	
		}else {
			 response.getWriter().write("false");
		}
		 
	 	
	}
	
}
