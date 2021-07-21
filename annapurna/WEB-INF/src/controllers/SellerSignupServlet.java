package controllers;   																                               //import pacakges

import models.*;
import utils.GoogleRecaptcha;
import utils.EmailSender;
import utils.ActivationMessage;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.util.Random;

public class SellerSignupServlet extends HttpServlet{								                                //class which is mapped with url seller_signup.do
 
	 public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{                       //will run this method if form method=get
		
		     request.getRequestDispatcher("seller_signup.jsp").forward(request, response);                                                    //sending sign_up page to user
	 }
	
	 
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{                      //will run this method if form method=post
		  
		    GoogleRecaptcha recaptch = new GoogleRecaptcha();                                                                                //GoogleRecaptcha class in defined in utils in which we have inserted Google recaptcha varification
	        
		    boolean recaptchTest = recaptch.recaptchaTest(request);                														    // if google recaptcha response will be true then only we will perform server validation of other fields
           
		    
		    if(recaptchTest){
			
		    String name = request.getParameter("name"); 
			
		    String phone = request.getParameter("phone");                                                            //here we got all the parameters of the form from request variable as ServletRequest is having method getRequest
			
		    String email = request.getParameter("email");
			
		    String password = request.getParameter("password");
			 
		    
			Pattern pattern = null;
			
			Matcher matcher = null;													                              // all this is only for server side validation if javascript not work on users account
		   
		    boolean validation = true;
		    
			String errors ="<ul>";                                                                                 //later we will add all errors if found in that ul tag 
		
			
			
		    pattern = Pattern.compile("^[a-zA-Z\\d-_ ]{2,50}$");
			 
		    matcher = pattern.matcher(name);
			 
		    if(!matcher.matches()){
			         
		    	     validation = false;                                                                            //if any error found so it will get concat in ul tage
			         
		    	     errors += "<li>Enter valid name</li>";
			 }
			 
		    
		    
			 pattern = Pattern.compile("^[6-9][\\d]{9}$");
			
			 matcher = pattern.matcher(phone);
			
			 if(!matcher.matches()){
			 
		            validation = false;
			 
			        errors += "<li>Enter valid phone number</li>";
			 }
			 
			 
			 
			 pattern = Pattern.compile("^([a-zA-Z\\d-_])+@([a-zA-Z\\d-_]{2,10})\\.([a-zA-Z]{2,5})(\\.[a-zA-Z]{2,5})?$");
			
			 matcher = pattern.matcher(email);
			
			 if(!matcher.matches()){
				 
			        validation = false;
			       
			        errors += "<li>Enter valid email </li>";
			  }
		
		
			 
			 pattern = Pattern.compile("^[a-zA-Z\\d-_!@#$%^&*()~]{8,20}$");
			 
			 matcher = pattern.matcher(password);
			 
			 if(!matcher.matches()){
			       
				   validation = false;
			  
			       errors += "<li>Enter valid password</li>";
			 }
			 
			 
			errors += "</ul>";                                                                                    // validation will only get true if there would be no string in errors variable
			
			
			if(validation){             
				                                                                                                    //if server side  validation will be true then after we will move for storing data in database
			             long  activationCode =   new Random().nextLong();
			             
			             if(activationCode < 0 ) {
			            	 
			            	 activationCode *= -1 ;                                                                      //if negative value will be Generated so we will make it positive
			            	 
			             }
			             
			             
				         Shop shop = new Shop(name,email,phone,password,Long.toString(activationCode));
			             
				         shop.signUp();                                                                             // after storing users data in database
			            
				         
				         ServletContext context  = request.getServletContext();                                     // we will make seperate  folder for the user in uploads
			             
			             String folderPath = context.getRealPath("/WEB-INF/uploads/Shops");
			             
			             String folderName = shop.getEmail();
			             
			             File file = new File(folderPath,folderName);                     
			              
			            
			             file.mkdir();                                                                              // it will create folder in folder path by folder name given above
			             new File(folderPath+"/"+shop.getEmail(),"others").mkdir();    
			             new File(folderPath+"/"+shop.getEmail(),"products").mkdir();
			             
			             String message = ActivationMessage.getActivationMessage(name,email,activationCode);
			             
			             String subject = "Annapurna  : : Account Activation Email ";
			            
			             EmailSender.sendEmail(email,subject,message);                                               //sending email for varification
			            
			             request.getRequestDispatcher("thanks.jsp").forward(request, response);
			
			
			   }else{                                                                                                    //if server side  validation  gonna fail
				         request.setAttribute("errors",errors);
				         
				         request.getRequestDispatcher("seller_signup.jsp").forward(request, response);
			       }
			
	
	      }else   {                                                                                                          //if recaptcha gonna fail
			
		               response.sendRedirect("seller_signup.jsp");
		  
	              }
	}
}
