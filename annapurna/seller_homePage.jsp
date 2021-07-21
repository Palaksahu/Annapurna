<!DOCTYPE html>
<%@page import="models.ProductPic"%>
<%@page import="models.Product"%>
<html lang="en">
<head>
      <%@ include file="head.jsp" %>
      <%@ page import = "java.util.ArrayList  , models.ShopPic" %>
      <%@ page import = "models.Shop" %>
      <title>Annapurna   :   My Account </title>
      <link rel="stylesheet" type="text/css" href="static/css/dropzone.min.css" />
      <link rel="stylesheet" type="text/css" href="static/css/seller_home.css" />
      <style>
  .card-sm:hover{
	     transform: scale(1.2);
	     transition: transform 0.3s ease;
	    
	     cursor : pointer;
	}
	.f{
	 font-size : 13px;
	}
	
	
</style>
</head>
<body>
      <div class="row fixed-top white border-light border " id="row-a">
            <div class="col-3 border border-light" id="col-a">
                <img src="static/images/home.png" class="mr-4 pb-1" id="img-a1">
                <span class="text-secondary"> My Account</span>
                <img src="static/images/a2.png" class="" id="img-a2">
                
            </div>
        </div>
     <%@ include file="seller_header.jsp" %>
   
    <div class="container-fluid " id="con-body">
    <div class="row text-white display-4 mx-auto py-1 red mb-3" id="id_texure" ><span class="mx-auto ">${shop.name}</span></div>
    <div class="row white ">
       <div class="col-8  mx-auto text-white text-center " id="f-col">
        <img alt="" class="shadow-lg" src ="seller_showpropic.do?propic=${shop.propic}" width="1000px" height="500px">  
       
       </div>
    </div>
    
    <div class="row mt-5">
          <div class="col-12  w-100">
              <ul class="nav nav-tabs text-center ">
                <li class="nav-item  w-50 ">
                   <a class="nav-link  btn btn-lg  shadow btn-outline-primary active border border-info mr-1" data-toggle="tab" href="#products" id="allproducts">All Products</a>
                </li>
                <li class="nav-item w-50 ">
                  <a  class="nav-link btn btn-lg shadow btn-outline-primary border border-info ml-1" data-toggle="tab"  href="#pics" id="allpics" >All Pictures </a>
                </li>
                
              </ul>
              <div class="tab-content text-center">
                 
                 <div class="tab-pane active" id="products" >
                  <div class="card-columns ">
	                  <div class="card w-50 mt-5 mb-3" >
	                   <a class="btn btn-light shadow-lg nav-link  card-body  btn-block pt-5" href="seller_addproduct.do" id="id_addProduct">Add product<br><li class="fa fa-plus-circle"></li></a>
	                  </div>
	                  <!-- start -->  
	                <%  Shop shop =  (Shop)session.getAttribute("shop"); 
	                    Product product1 = (Product)session.getAttribute("product");
	                    if(product1!=null){
	                    	session.removeAttribute("product");
	                    }
                    if(shop != null){
                       ArrayList<Product> productList = Product.getSellerProducts(shop);   
                       
                         int c = 1; 
                       for(Product product : productList){  %>
                    	                 
                       
                          <!-- start -->
                      
                    <div class="card shadow-lg border border-info mt-2" style="max-width:1000px">
		            <div class="row no-gutters">
				             <div class="col-5 ">
				                        
				                <div class="carousel slide " id="c<%=c %>" data-ride="carousel">
				                   
					                  <ol class="carousel-indicators">
					                     <li data-target="#c<%=c %>" data-slide-to="0" class="active"></li>
					                     <li data-target="#c<%=c %>" data-slide-to="1" ></li>
					                     <li data-target="#c<%=c %>" data-slide-to="2" ></li>
					                  </ol>
					                  <div class="carousel-inner">
					                     
						                       
											       <%   if(product != null){
											        	  
											          ArrayList<String> allPicList = ProductPic.getAllPics(product);
											          int count = 0;
											          for(String picPath : allPicList){ 
											        	  if(count == 0){  %>
											        	        
											         	<div class="carousel-item active">
						                                     <img class="d-block w-100" alt="" src="seller_showproductpic.do?picPath=<%= picPath %>" width="150px" height="200px">      
						                                </div> 
						                                
						                               
						                             <%  count ++; 
						                                } else{ %>
						                            	  
						                            	  <div class="carousel-item">
						                                     <img class="d-block w-100" alt="" src="seller_showproductpic.do?picPath=<%= picPath %>" width="150px" height="200px">      
						                                  </div>
						                            	 
						                            <%    count++;
						                             }      
											                
											          }
											        } else{
											        	response.sendRedirect("seller_signin.jsp");
											        }        		  
											    %>                  
					                  </div>
					                  <a class="carousel-control-prev" href="#c<%=c %>" role="button" data-slide="prev">
					                     <span class="carousel-control-prev-icon shadow-lg bg-secondary" area-hidden="true"></span>
					                     <span class="sr-only">Previous</span>
					                  </a>
					                  <a class="carousel-control-next " href="#c<%=c %>" role="button" data-slide="next">
				                     <span class="carousel-control-next-icon shadow-lg bg-secondary" area-hidden="true"></span>
				                     <span class="sr-only">Next</span>
				                  </a>
				                </div>
				                 
				           	 </div><!-- col-6/row/col-5 -->
				           
				           	 <div class="col-7 text-left f">
				                 <div class="card-body" style="height:205px ;" >
						                 <h6 class="card-title row ml-1"><%= product.getBrand() %>  <%= product.getProductName() %>  </h6>
								         
								         <div class="card-text row ">
								           <div class="col-5"> Weight -</div> 
								           <div class="col-7"><%= product.getWeight() %>&nbsp;kg</div>
								          </div>
								           <div class="card-text row">
								           <div class="col-5"> MRP  -</div> 
								           <div class="col-7"> <s>Rs&nbsp; <%= product.getMrp() %></s>/- </div>
								          </div>
								         
								          <div class="card-text row">
								           <div class="col-5"> Price -</div> 
								           <div class="col-7">Rs&nbsp;<h6 class="d-inline text-primary"><%= product.getPrice() %></h6> /-</div>
								          </div>
								         
								          <div class="card-text row">
								           <div class="col-5"> Quantity -</div> 
								           <div class="col-7"><%= product.getQuantity() %></div>
								          </div>
								         
								          <div class="card-text row">
								           <div class="col-5">Expiry Date -</div> 
								           <div class="col-7"><%= product.getExdate() %></div>
								          </div>
								          
								          <div class="card-text row">
								           <div class="col-5">Details -</div> 
								           <div class="col-7"><%= product.getDetails().substring(0,30)%><a href="" class=" ml-1 text-primary">more</a></div>
								          </div>  
								          
				                 </div>
				                   
			           	     </div><!-- col-6/row/col-7 -->
			           	    
		           </div><!-- col-6/row -->
		          <div class="row no-gutters border">
		           
		           <div class="col-6"><button type="submit" class="btn btn-outline-primary btn-sm p-0 btn-block edit" value="<%=product.getProductId()%>" ><li class="fa fa-pencil-square  fa-lg ">&nbsp;Edit</li></button></div>
		           	
		           <div class="col-6"><button type="button" class="btn btn-outline-danger btn-sm p-0 btn-block del"   value="<%=product.getProductId()%>"  ><li class="fa fa-trash-o fa-lg ">&nbsp;Delete</li></button></div>
		           </div>
		       
		        </div>
                      
                      <!-- end -->
                  
                       
                       
                       
                    	      
                    <% c++;
                        
                       } 
                       
                       
                       }else{
                    	   
                    	 request.getRequestDispatcher("seller_signin.jsp").forward(request,response);  
                       } %>
                     
                      
                     <!-- end -->
                  </div>
                 </div>
               <div class="tab-pane black mb-5 h-100 w-100" id="pics" >    <iframe src="1.jsp" class="w-100" scrolling="no"  style="height : 1500px;border:none"></iframe></div>
                          </div>
         </div>
     </div>
   </div>
  
      
  
  
     <%@ include file="footer.jsp" %>
     <script type="text/javascript" src="static/js/seller_homePage.js"></script> 
     <script type="text/javascript" src="static/js/dropzone.min.js"></script>
     
             
		    
   
    </body>
</html>