package controllers;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Shop;
import models.Status;
import utils.GoogleRecaptcha;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

public class SellerSignInServlet extends HttpServlet{
	 public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
		 
		  request.getRequestDispatcher("seller_signin.jsp").forward(request, response);
		  
	 }
	 
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
	 String nextPage = "seller_signin.jsp"; 
		
	 if(GoogleRecaptcha.recaptchaTest(request)){
		 HttpSession session = request.getSession();
		    
		    String email = request.getParameter("email"); 
			String password = request.getParameter("password");
			
		    Pattern pattern = null;
			
			Matcher matcher = null;													                              // all this is only for server side validation if javascript not work on users account
		   
		    boolean validation = true;
		    
			String errors ="<ul>";                                                                                 //later we will add all errors if found in that ul tag 
		
			 
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
			 
			 
			                                                                                   // validation will only get true if there would be no string in errors variable
			
//-------------Validation----------------------------------
		
	          if(validation){
				
						Shop shop3 = new Shop(email,password);
						
						if(shop3.signin() == 2){
							   
						         int stsId = shop3.getStatus().getStatusId();	
						       
							     if(stsId != Status.INACTIVE) {
									     
								    	 if(stsId == Status.PROFILEPAGE){
								               session.setAttribute("shop",shop3);
										       nextPage = "seller_profile.do";
										     
								    	  }else if(stsId == Status.ACTIVE){
								    		  session.setAttribute("shop",shop3);
										       nextPage = "seller_homePage.jsp";
										       
								    	  }
								   
							      }else{
							    	    
							    	      errors += "<li>Your Account is not Active</li></ul>";
										  request.setAttribute("errors",errors);
									      request.getRequestDispatcher(nextPage).forward(request, response);
							      
							      }
							     
						}else if(shop3.signin() == 1) {
							
								errors += "<li>The Password you entered is incorrect   !"
										+ " </br>      please try again.</li></ul>";
								request.setAttribute("errors",errors);
							    request.getRequestDispatcher(nextPage).forward(request, response);
						
						}else if(shop3.signin() == 0){
							
								errors += "<li>Account with the given Email doesn't Exist</li></ul>";
								request.setAttribute("errors",errors);
							    request.getRequestDispatcher(nextPage).forward(request, response);
							    
						}
	        }else{                                                                                                    //if server side  validation  gonna fail
		        
	    	     errors += "</ul>"; 
	    	     request.setAttribute("errors",errors);
		         
		         request.getRequestDispatcher(nextPage).forward(request, response);
	          }
	      
			  
	    }
	       
		response.sendRedirect(nextPage);
	  
   }
}