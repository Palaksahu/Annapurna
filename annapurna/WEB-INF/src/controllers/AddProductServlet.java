package controllers;
import utils.ProductDetail;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Product;
import models.Shop;
import utils.ProductDetail;

import com.google.gson.Gson;
public class AddProductServlet extends HttpServlet{
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	   
	  HttpSession session = request.getSession();
	  Shop shop = (Shop)session.getAttribute("shop");
	  
	  if(shop != null) {
		   request.getRequestDispatcher("seller_addProduct.jsp").forward(request, response);
		  
	  }else {
		  response.sendRedirect("seller_signin.jsp");
	  } 
   }
   
   
   public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	   
	   HttpSession session = request.getSession();
	  Shop shop = (Shop)session.getAttribute("shop");
	   Product product1 = (Product)session.getAttribute("product");
	   
	  if(shop != null) {
		  
			  Gson gson =  new Gson();
			  BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			 
			  
			  StringBuilder sb = new StringBuilder();
			  String str = "";
			  while((str = br.readLine()) != null) {
				  sb.append(str);
			  }
			  
			  Pattern ptr = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d");
			  Matcher mtc = ptr.matcher(sb);
			  
			  if( mtc.find()) {
			  sb.insert(mtc.end(),"T00:00:00+0000");
			  
			  
			 ProductDetail productDetail = gson.fromJson(sb.toString(),ProductDetail.class);
			 
			 Product product = new Product(shop,productDetail);
			 
			  
			 
			 product.setExdate(Date.valueOf(mtc.group()));
			 if(product1!=null){ 
			
				 product.setProductId(product1.getProductId());
				 session.removeAttribute("product");
				 
			}
		     Integer flag = product.addProduct();
			if(flag == 3) {
				       Shop.updateTotalProducts(true , shop.getShopId());
				       session.setAttribute("product",product);
                       response.getWriter().write("true");	
                       
                       String folderPath = getServletContext().getRealPath("/WEB-INF/uploads/Shops/"+shop.getEmail()+"/products/");
                       
                       String folderName = ""+product.getProductId()+"";
                       
                       File file = new File(folderPath,folderName); 
                       
                       file.mkdir();
             
                       
			}else if(flag==2){
				    response.getWriter().write("edited");
			}
		}
		  
	   }else {
		   
		   response.getWriter().write("false");
	   }
	 
	   
   }
}
