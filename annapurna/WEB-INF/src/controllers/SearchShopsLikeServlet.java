package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Shop;

public class SearchShopsLikeServlet extends  HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response )throws IOException,ServletException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("shopLikeList");
		session.removeAttribute("productLikeList");
		String nm1 = (String)session.getAttribute("nm");
		if(nm1!=null) {
			session.removeAttribute("nm");
		}
		
		String like1 = (String)session.getAttribute("like");
		if(like1!=null) {
			session.removeAttribute("like");
		}
	
		
		
		String like = request.getParameter("like");
		String nm = request.getParameter("nm");
		session.setAttribute("nm",nm);
		session.setAttribute("like",like);
		ArrayList<Shop> shopLikeList = Shop.getShopLike(like);
		
        session.setAttribute("shopLikeList", shopLikeList);
		
		response.getWriter().write("true");
		
	}
}
