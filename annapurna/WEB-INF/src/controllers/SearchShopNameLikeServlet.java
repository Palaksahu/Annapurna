package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import models.Shop;

public class SearchShopNameLikeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request ,HttpServletResponse response )throws IOException ,ServletException {
		  
		  HttpSession session = request.getSession();
		  session.removeAttribute("nameLikeList");
          session.removeAttribute("shopNameLikeList");
          
		  String resp = "expire";
	      String nameLike = request.getParameter("nameLike");
	      
	       
	     
           ArrayList<String> nameLikeList = Shop.shopNameLike(nameLike);
           if(nameLikeList != null) {
           if(nameLikeList.size()!=0) {
           session.setAttribute("shopNameLikeList", nameLikeList);
            resp = "true";
           }else {
        	   resp="nottrue";
           }
           }else {
        	   resp ="false";
           }
    
          
	     response.getWriter().write(resp);
	}
}
