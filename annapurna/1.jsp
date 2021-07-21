<%@page import="models.Shop"%>
<%@page import="models.ShopPic"%>
<%@page import="java.util.ArrayList"%>
<html>
<head><link rel="stylesheet" type="text/css" href="static/css/dropzone.min.css" />
<link rel="stylesheet" type="text/css" href="static/css/seller_home.css" />
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
       <%@ include file="head.jsp" %>
       </head>
       <body>
       <div class="row  fixed-top white">
       <div class=" col">
        <button type="button" class="btn btn-outline-success py-1 mt-1 float-right mr-5" id="id_select"><li class="fa fa-check-circle fa-lg ">&nbsp;select</li></button>
        
        
        <button type="button" class="btn btn-outline-success py-0 mt-1 float-right mr-5 d-none " id="id_cancel">Cancel</button>
      
       
        <button type="button" class="btn btn-outline-danger py-1 mt-1 float-left ml-3 d-none" id="id_delete"><li class="fa fa-trash-o  ">&nbsp;Delete</li></button>            
      </div>
       </div>    
               <div class="row mt-5">
               <div class="card-columns w-100 h-100" >   
                      <div class="  mx-auto card hi mb-5 text-info pt-5 " id="majboori-card" style="border:none;" > 
                           <form class="pd border border-primary shadow-lg dropzone bg-light mx-auto text-white text-center h-75 hi" id="id_smalldrop">
                            <h3 class="text-primary mt-4 mb-4" id="h1tag"> Add More<br>+</h3>
                            <button type="button" class="btn-outline-primary btn-sm p-0 mt-4   d-none" id="id_smbtn">upload</button>
                            </form> 
                              
                         </div>
                          
                        <div class=" card hi mb-5 mx-auto hi" >
                              <img alt="" class=" shadow-lg card-img-top h-100 w-100 img-thumbnail " src ="seller_showpropic.do?propic=${shop.propic}">
                              
                              
                                 
                        </div>
                        
                        <% 
                          Shop shop = (Shop)session.getAttribute("shop");
                         if(shop != null){
                         ArrayList<String> picPathList = ShopPic.getAllPicPath(shop); %>
                         <% for(String picPath : picPathList){ %>
                          <div class=" shadow mb-5 card pb-0 mx-auto hi">
                          <img alt="" class=" card-img-top  img-thumbnail h-100 w-100" src ="seller_showAllpic.do?picPath=<%= picPath %>">
                           <div class="card-body  p-0 " > 
                           <div class="card-text text-center">
                          <input type="checkbox" name="delete" value="<%=picPath %>" class="form-check-input d-none che"  >
                            </div>
                           </div> 
                          </div>
                        <% } }else{
                        	response.sendRedirect("seller_signin.jsp");
                        } %>
                    </div>
                    </div>
                         <script type="text/javascript" src="static/js/seller_homePage.js"></script> 
                          <script type="text/javascript" src="static/js/dropzone.min.js"></script> 
                  
                 
     <script>
             
		     Dropzone.autoDiscover = false;
		
		    let dropzone = new Dropzone('#id_smalldrop',{url:'seller_otherpic.do',
		    	paramName: 'file',
     			maxFilesize: 10,
     			uploadMultiple: false,
     			createImageThumbnails: true,
     			maxFiles: 1,
     			acceptedFiles: '.jpeg,.png,.gif,.jpg',
     			addRemoveLinks: true,
     			autoProcessQueue: false
		                          });
		    
           dropzone.on("thumbnail",()=>{
        	   id_smbtn.classList.remove("d-none");	
        	   h1tag.classList.add("d-none");
        	   
	        });
		    id_smbtn.addEventListener("click",(event)=>{
		    	 dropzone.processQueue();
		    	 
		    })
	        dropzone.on("success",()=>{
	        	
	           location.reload();
	        });
     </script>
     </body>
    </html>
    