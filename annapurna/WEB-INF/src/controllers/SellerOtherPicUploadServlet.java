package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Shop;
import models.ShopPic;

public class SellerOtherPicUploadServlet extends HttpServlet{
 
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException {
		 HttpSession session  = request.getSession(); 
		 Shop shop = (Shop)session.getAttribute("shop");
		 
		if(ServletFileUpload.isMultipartContent(request)) {
		 ServletFileUpload  fileupload = new ServletFileUpload(new DiskFileItemFactory());
		 try {
		      	
		     List<FileItem> items = fileupload.parseRequest(request);
			 
		     FileItem fileItem = items.get(0);
			 
		     String fileName = fileItem.getName();
			 
			 String filePath = getServletContext().getRealPath("/WEB-INF/uploads/Shops/"+shop.getEmail()+"/others/");
			 
			 File file = new File(filePath,fileName);
			     
			 
			 try {
				
				 fileItem.write(file);
				 String picPath = shop.getEmail()+"/others/"+fileName;
				
				 ShopPic shopPic = new ShopPic(shop,picPath);
				 
				 if(shopPic.saveOtherPicPath()) {                                     
				 
				                                    
				 }
				 
			 }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		
		 }catch(FileUploadException e) {
			 e.printStackTrace();
		 }
		 
		
	  }
	}
  }

