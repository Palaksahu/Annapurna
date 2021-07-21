package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Product;
import models.ProductPic;
import models.Shop;

public class DeleteProductServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		Shop shop = (Shop)session.getAttribute("shop");
		if(shop != null) {
		String respo = "";
		Integer productId = Integer.parseInt(request.getParameter("btn"));
	
		Product product = new Product(productId);
		
		if(ProductPic.deletePic(product)){
			
				  if(product.deleteProduct()){
					   respo = "true";
					   Shop.updateTotalProducts(false , shop.getShopId());
					   System.out.println("ja to rha ha bhai");
				  }else {
					   respo ="false";
				  }
				  
	  }else {
		   respo ="not";
	  }
       response.getWriter().write(respo);
     }
  }
}