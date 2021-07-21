<!DOCTYPE html>
<%@page import="models.Shop"%>
<%@page import="models.ProductPic"%>
<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
      <%@ include file="head.jsp" %>
      <title >Annapurna   :   Home </title>
    <style>  .card:hover{
	     transform: scale(1.2);
	     transition: transform 0.3s ease;
	    
	     cursor : pointer;
	}
	
	
	</style>
</head>
<body>
      <div class="row fixed-top white border-light border " id="row-a">
            <div class="col-3 border border-light" id="col-a">
                <img src="static/images/home.png" class="mr-4 pb-1" id="img-a1">
               <a href="index.jsp"  class="text-primary" id="hom">Home</a>
                <img src="static/images/a2.png" class="" id="img-a2">
            </div>
        </div>
     <%@ include file="header.jsp" %>
   
    <div class="container-fluid" id="con-body">
     <div class="row" id="" style="padding-top:105px;">
                             <!--    <div class="carousel slide w-100 " id="c11" data-ride="carousel" >
                                    <ol class="carousel-indicators">
                                      <li data-target="#c11" data-slide-to="0" class="active"></li>
                                      <li data-target="#c11" data-slide-to="1" class=""></li>
                                      <li data-target="#c11" data-slide-to="2" class=""></li>
                                    </ol>
                                    <div class="carousel-inner">
                                    
		                                     <div class="carousel-item active">
								                       <img class="d-block w-100" alt="" src="static/images/cr10.jpg" height="500px;">      
								              </div> 
								                                
                                              <div class="carousel-item">
								                       <img class="d-block w-100" alt="" src="static/images/cr6.jpg" height="500px;">      
								              </div> 
								              <div class="carousel-item">
								                       <img class="d-block w-100" alt="" src="static/images/cr5.jpg" height="500px;">      
								              </div> 
								                                
                                              
								              <div class="carousel-item">
								                       <img class="d-block w-100" alt="" src="static/images/cr9.jpg" height="500px;">      
								              </div> 
								               <div class="carousel-item">
								                       <img class="d-block w-100" alt="" src="static/images/cr11.jpg" height="500px;">      
								              </div>
								               <div class="carousel-item">
								                       <img class="d-block w-100" alt="" src="static/images/cr12.jpg" height="500px;">      
								              </div>
								             
                                    </div>
                                    <a class="carousel-control-prev" href="#c11"  role="button" data-slide="prev">
                                      <span class="carousel-control-prev-icon shadow-lg bg-secondary" area-hidden="true"></span>
					                     <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next " href="#c11" role="button" data-slide="next">
				                     <span class="carousel-control-next-icon shadow-lg bg-secondary" area-hidden="true"></span>
				                     <span class="sr-only">Next</span>
				                  </a>
                                 </div>-->
                                  
                  
         </div>
        <% ArrayList<Product> prolist = (ArrayList)session.getAttribute("productLikeList"); 
                if(prolist!=null){
          %>
        <div class="row white my-2" id="row-c">
             
            <div  class="col-3" id="col-n"><a href="" class="btn btn-primary nav-link">All Products</a></div>
        </div>
        
        
        <div class="row white w-100 card-columns " id="row-d">
           
           <%       int c = 1;
                  for(Product product : prolist){
                	  if(c<11){
         %>          
        
        
               <div class="col-2 mx-auto" id="col-d1">
                   <div class="card text-center no-border  my-5">
                     
                     <div class="carousel slide " id="c<%=c %>" data-ride="carousel">
				                   
					                  <ol class="carousel-indicators">
					                     <li data-target="#c<%=c %>" data-slide-to="0" class="active"></li>
					                     <li data-target="#c<%=c %>" data-slide-to="1" ></li>
					                     <li data-target="#c<%=c %>" data-slide-to="2" ></li>
					                  </ol>
					                  <div class="carousel-inner">
					                     
						                       
											       <%   
											        	  
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
                     
                      <div class="card-body px-2 text-left" >
                          <h5 class="card-title"><%=product.getBrand() %></h5>
                          <h6 class="card-subtitle text-muted"><%= product.getProductName() %></h6>
                          <p class="card-text  "> 
                            Weight <%=product.getWeight()  %>Kg <br>
                            MRP - <span><s>Rs  <%=product.getMrp() %></s></span><br>
                           <big class="text-primary">Rs<%=product.getPrice() %> </big> <small> Save Rs<%=product.getMrp()-product.getPrice()%> </small></br>
                           Details - <small class="text-secondary"><%= product.getDetails().substring(0,45)%><a href="" class=" ml-1 text-primary">more</a></small>
                        </p>
                       <button class="btn btn-info">Add to Cart</button>
                      </div>
                   </div>
               </div>
               
               
               
               <% c++; 
               }else{
            	   break;
               }
                	  
                  
                  } %>
                    </div>
           <% } %>
              
        
         
         <% ArrayList<Shop> shopList =(ArrayList)session.getAttribute("shopLikeList"); 
           if(shopList!=null){   
            int e = 1;
           if(shopList.size()!=0){ %>
             
        <div class="row white" id="row-e">
            <div  class="col-3" id="col-m" ><a href="" class="btn btn-primary nav-link">All Shops</a></div>
        </div>
         
         
        <div class="row white card-columns" id="row-f">
        
       
            
       <%     for(Shop shop : shopList){
             if(e<7){
        %>
            <div class="col-3 mx-auto my-5 p-0" id="col-f1">
                <div class="card text-center border  shadow-lg">
                   <img alt="" src="seller_showpropic.do?propic=<%=shop.getPropic() %>" class="card-img-top"  height="300px">
                   <a href="" class="btn black btn-block text-primary"><%=shop.getName() %></a>
                </div>
            </div>
           
           <%
               e++;
             }else{
            	 break;
             }
            }%>
            
        </div>
      <% }else{ %>
         <div class="row">
          <div class="col text-danger" style="padding-top:200px;padding-bottom:200px;">
    	  <h1 class="text-center border ">Sorry ! no record found</h1>
    	  </div>
    	  </div>
    <%  }
           
           }%>
           </div>
    
     <%@ include file="footer.jsp" %>
       
        
      
     <script>
     
       hom.addEventListener("click",(event)=>{
    	   
    	 <% session.removeAttribute("nm"); %>
    	 <% session.removeAttribute("like"); %>
       });
     </script>
     
</body>
</html>