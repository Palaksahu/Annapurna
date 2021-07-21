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

import models.Product;
import models.ProductPic;
import models.Shop;

public class SaveProductPicServlet extends HttpServlet{
    public void doPost(HttpServletRequest request , HttpServletResponse response)throws IOException ,ServletException{
    	
    	 HttpSession session = request.getSession();
    	 Shop shop = (Shop)session.getAttribute("shop");
    	 Product product = (Product)session.getAttribute("product");
    	 
    	 if(shop != null){
    		 if(ServletFileUpload.isMultipartContent(request)){
    			 
    			 try {
    				 
    			 ServletFileUpload fileupload = new ServletFileUpload(new DiskFileItemFactory());
    			 
    			 List<FileItem> items = fileupload.parseRequest(request);
    			 
    			 FileItem fileItem = items.get(0);
    			 
    			 String fileName = fileItem.getName();
    			 
    			 String filePath = getServletContext().getRealPath("/WEB-INF/uploads/Shops/"+shop.getEmail()+"/products/"+product.getProductId()+"/");
                    			 
    			 File file = new File(filePath,fileName);
    			 
    			 try {
    				 
    				 fileItem.write(file);
    				 
    				 String picPath = shop.getEmail()+"/products/"+product.getProductId()+"/"+fileName;
    				 
    				 if(ProductPic.saveProductPics(product, picPath)) {
    					 
    					 
    					 System.out.println("product pics saved Successfully");
    				 }
    				 
    			 }catch(Exception e){
    				 e.printStackTrace();
    			 }
    			 
    			 }catch(FileUploadException e) {
    				 e.printStackTrace();
    			 }
    		 }
    		 
    	 }else {
    		 request.getRequestDispatcher("seller_signin.jsp").forward(request, response);
    	 }
    }
}
