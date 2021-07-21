<!DOCTYPE html>
<%@page import="models.ProductPic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Product"%>
<html lang="en">
<head>
      
    <link rel="stylesheet" type="text/css" href="static/css/form.css" />
     <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <%@ include file="head.jsp" %>
    <title>Annapurna   :  My Account </title>
    <link rel="stylesheet" type="text/css" href="static/css/dropzone.min.css" />
</head>
<body>
   <div class="row fixed-top white border-light border " id="row-a">
            <div class="col-3 border border-light" id="col-a">
                <img src="static/images/home.png" class="mr-4 pb-1" id="img-a1">
                <a href="seller_homePage.jsp" class="text-primary">My Account</a>
                <img src="static/images/a2.png" class="" id="img-a2">
               
                <span class="text-secondary">Add Product</span>
                <img src="static/images/a2.png" class="" id="img-a2">
            </div>
    </div>
   
    <%@ include file="seller_header.jsp" %>
    
    <div class="container-fluid" id="con-body">
           
    
	      <div class="row bg-light ">
	           <ul class="nav nav-pills nav-fill col-8 mx-auto my-4">  
	              <li class="nav-item mx-5" >
	                 <a class="nav-link shadow" id="step1"> Step 1</a>
	              </li>
	              <li class="nav-item mx-5">
	                 <a class="nav-link  shadow " id="step2">Step 2</a>
	              </li> 
	              <li class="nav-item mx-5">
	                 <a class="nav-link  shadow active" id="step3">Step 3</a>
	              </li>
	           </ul>
	       </div>
	      
	       
	       <h1 class="display-4 text-info mt-2 mx-auto text-center">Review of your Product</h1> 
	       
	        
	       <div class="row  mb-5 text-center">
             
		       <div class="col-6 mx-auto mt-5 mb-5">
		       
		       
		         <div class="card shadow-lg border border-info " style="max-width:1000px">
		            <div class="row no-gutters">
				             <div class="col-5 ">
				                <div class=" carousel slide " id="c1" data-ride="carousel">
					                  <ol class="carousel-indicators">
					                     <li data-target="#c1" data-slide-to="0" class="active"></li>
					                     <li data-target="#c1" data-slide-to="1" ></li>
					                     <li data-target="#c1" data-slide-to="2" ></li>
					                  </ol>
					                  <div class="carousel-inner">
					                     
						                      <% Product product = (Product)session.getAttribute("product"); 
											          if(product != null){
											        	  
											          ArrayList<String> allPicList = ProductPic.getAllPics(product);
											          int count = 0;
											          for(String picPath : allPicList){ 
											        	  if(count == 0){  %>
											        	        
											         	<div class="carousel-item active">
						                                     <img class="d-block w-100" alt="" src="seller_showproductpic.do?picPath=<%= picPath %>" width="200px" height="300px">      
						                                </div> 
						                               
						                               
						                             <%  count ++; 
						                                } else{ %>
						                            	  
						                            	  <div class="carousel-item">
						                                     <img class="d-block w-100" alt="" src="seller_showproductpic.do?picPath=<%= picPath %>" width="200px" height="300px">      
						                                  </div>
						                            	 
						                            <%    count++;
						                             }      
											        	         
											          }
											        } else{
											        	response.sendRedirect("seller_signin.jsp");
											        }        		  
											    %>                  
					                  </div>
					                  <a class="carousel-control-prev" href="#c1" role="button" data-slide="prev">
					                     <span class="carousel-control-prev-icon shadow-lg bg-secondary" area-hidden="true"></span>
					                     <span class="sr-only">Previous</span>
					                  </a>
					                  <a class="carousel-control-next " href="#c1" role="button" data-slide="next">
				                     <span class="carousel-control-next-icon shadow-lg bg-secondary" area-hidden="true"></span>
				                     <span class="sr-only">Next</span>
				                  </a>
				                </div>
				                
				           	 </div><!-- col-6/row/col-5 -->
				           
				           	 <div class="col-7 text-left">
				                 <div class="card-body px-5" style="height:300px">
						                 <h5 class="card-title row">${product.brand}    ${product.productName}</h5>
								         <div class="card-text row mb-1">
								           <div class="col-5"> Weight -</div> 
								           <div class="col-7"> ${product.weight}</div>
								          </div>
								           <div class="card-text row mb-1">
								           <div class="col-5"> MRP  -</div> 
								           <div class="col-7"> <s>Rs ${product.mrp}</s>/- </div>
								          </div>
								         
								          <div class="card-text row mb-1">
								           <div class="col-5"> Price -</div> 
								           <div class="col-7">Rs<big class="text-primary">${product.price}</big>/-</div>
								          </div>
								         
								          <div class="card-text row mb-1">
								           <div class="col-5"> Quantity -</div> 
								           <div class="col-7"> ${product.quantity} </div>
								          </div>
								         
								          <div class="card-text row mb-1">
								           <div class="col-5">Expiry Date -</div> 
								           <div class="col-7">${product.exdate}</div>
								          </div>
								          
								          <div class="card-text row mb-1">
								           <div class="col-5">Details -</div> 
								           <div class="col-7"> <textarea rows="3" class="border-none">${product.details}</textarea></div>
								          </div>  
				                 </div>
			           	     </div><!-- col-6/row/col-7 -->
			           	     
		           </div><!-- col-6/row -->
		          
		        </div>
		        <a class="btn btn-primary mx-auto my-4 px-4" href="seller_homePage.jsp">Save</a>
		       </div> <!-- col-6 -->
		      
		       
		       
	     </div> <!-- row 2 -->
    
    
    
     </div>  <!--con -->
    
    
    <%@ include file="footer.jsp" %>
    <script type="text/javascript" src="static/js/dropzone.min.js"></script>
    
    
    
     </body>
</html>