<!DOCTYPE html>
<%@page import="models.ProductPic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Product"%>
<%@page import="models.Category"%>

<html lang="en">
<head>
    <style>
      #row-pr{
       display : block;
      }
     
      
      #id_picdropdiv{
       display : none;
       height : 600px;
      }
  
    
    </style>
    
      
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
                 <a class="nav-link shadow active" id="step1"> Step 1</a>
              </li>
              <li class="nav-item mx-5">
                 <a class="nav-link  shadow " id="step2">Step 2</a>
              </li> 
              <li class="nav-item mx-5">
                 <a class="nav-link  shadow" id="step3">Step 3</a>
              </li>
           </ul>
      </div>
      
      <!-- start -->
     
      <!-- end -->
       <div class="row mb-5" id="row-pr">
           <div class="col-4 border  my-5  bl2 mx-auto px-3 shadow-lg">
               <% Product product = (Product)session.getAttribute("product");
               
                    
               %>
             <div class= "row  text-center  bg-light mb-5 text-white">
                 
                 <div class="col blue py-2 font-weight-bold"><big>
                 <% if(product!=null){  %>
                  Edit Product
                  <%}else{ %>
                  Add New Product
                  <%} %>
                  <a href="seller_homePage.jsp" class="text-white"><li class="fa fa-times float-right "></li></a></big></div>   
               
              </div>
              
              <div class="row bl1 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_productName" class="m-0">Product Name</label></h5></div>
                  <div class="col-8 shadow p-0"><input type="text" id="id_productName" value="${product.productName}" class="form-control border text-center border-white bl1"></div>
              </div>
               
               <% ArrayList<Category> catlist = Category.getAllCategory(); 
                 
               %>
               <div class="row bl2 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_category" class="m-0">Category</label></h5></div>
                  <div class="col-8 shadow p-0">
                              <select id="id_category"  class="form-control border text-center border-white bl2 ">
                               <option disabled selected hidden >Select Category</option>
                         <%  
                            for(Category cat : catlist){ 
                           if(product!= null){
                                if(cat.getCategoryId()==product.getCategory().getCategoryId()){  %>
                                
                                 <option selected value="<%=cat.getCategoryId()%>"> <%=cat.getCategory()%></option>
                               
                               <%  }else{   %>
                               
                                <option value="<%=cat.getCategoryId()%>"> <%=cat.getCategory()%></option>
                                 
                               <%}
                                
                           }else{   %>
                        	   
                        	   <option value="<%=cat.getCategoryId()%>"> <%=cat.getCategory()%></option> 
                        	   
                         <%  }
                            	
                            
                            }
                               
                               %>
                               
                              </select>
                              </div>
              </div>
            <% if(product!=null){ 
               if(product.getBrand()=="local"){}}
            %>
              <div class="form-group row bl1 mb-1 text-center" id="id_type">
                  <h5 class="col-4 text-center "><label class="pt-2">Type:</label></h5>  
                    <div class="custom-control pt-1 text-center col-3 mx-auto custom-radio custom-control-inline">
                        <input type="radio" name="branded" id="id_branded" value="branded" class=" i custom-control-input">
                        <label for="id_branded" class="custom-control-label"  >Branded</label>
                    </div>
                    <div class="custom-control col-3 mx-auto pt-1 custom-radio custom-control-inline">
                        <input type="radio" id="id_local" name="branded"  value="local" class=" i custom-control-input">
                        <label for="id_local" class="custom-control-label ">Local</label>
                    </div>
                </div>  
             
              
              
              
              <div class="row pink mb-1 d-none" id="id_branding"> 
                 
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_brand" class="m-0">Brand</label></h5></div>
                  <div class="col-8  shadow p-0"><input type="text" value="${product.brand}" id="id_brand"  placeholder=""  class="form-control border text-center border-white bl2"></div>
              </div>
               
              
              <div class="row bl2 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_weight" class="m-0">Weight</label></h5></div>
                  <div class="col-8  shadow p-0"><input type="text"  value="${product.weight}" id="id_weight"  placeholder="in Kg"  class="form-control border text-center border-white bl2"></div>
              </div>
              
               <div class="row bl1 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_mrp" class="m-0">MRP</label></h5></div>
                  <div class="col-8   shadow p-0"><input type="text" id="id_mrp" value="${product.mrp}"  placeholder="in Rs" class="form-control border text-center border-white bl1"></div>
              </div>
              
               <div class="row bl2 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_price" class="m-0">Price</label></h5></div>
                  <div class="col-8  shadow p-0"><input type="text" placeholder="in Rs"  value="${product.price}"  id="id_price" class="form-control border text-center border-white bl2"></div>
              </div>
              
               <div class="row bl1 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_exdate" class="m-0">Expiry Date</label></h5></div>
                  <div class="col-8   shadow p-0"><input type="date" id="id_exdate"  value="${product.exdate}"  class="form-control border text-center border-white bl1"></div>
              </div>
              
               <div class="row bl2 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_quantity" class="m-0">Quantity</label></h5></div>
                  <div class="col-8   shadow p-0"><input type="text" id="id_quantity"  value="${product.quantity}"  class="form-control border text-center border-white bl2"></div>
              </div>
              
               <div class="row bl1 mb-1">
                  <div class="col-4 text-center"><h5 class="pt-2"><label for="id_details" class="m-0">Details</label></h5></div>
                  <div class="col-8  shadow p-0"><textarea type="text" id="id_details"  rows="3" class="form-control text-center border border-white bl1">${product.details}</textarea></div>
              </div>
              <div class="row  black py-4">
              <% if(product!=null){ 
               
            %>
               <div class="col text-center"><button class="btn btn-primary shadow-lg px-4 " id="id_update"  >Update</button></div>
               <%}else{ %>
               <div class="col text-center"><button class="btn btn-primary shadow-lg px-4" id="id_add">Add</button></div>
               <%} %>
               <div class="col text-center"><a class="btn btn-warning text-white shadow-lg px-3" href="seller_addproduct.do">Reset </a></div>
              </div>
              
                    
           </div>
       </div>
       <div class="row  pb-5 text-center" id="id_picdropdiv"> 
        <div class="my-5 display-4 text-info">Product Pictures </div>
        
        <div class="col-5 mx-auto text-center  mt-5">
         <form class="dropzone  text-info border border-info my-3 h-100 shadow-lg w-100" id="id_picdrop">
          
         </form>
        
         </div>
          <a class="upload btn btn-info my-5" href="seller_productReview.jsp"  id="upload">Upload</a>
       </div>
       
      
    </div>
    <%@ include file="footer.jsp" %>
    <script type="text/javascript" src="static/js/dropzone.min.js"></script>
    <script type="text/javascript" src="static/js/seller_addProduct.js"></script>
    <script>
    Dropzone.autoDiscover = false;
	
           let dropzone = new Dropzone('#id_picdrop',{url:'seller_productpic.do',
        	   
        	   paramName: 'file',
    			maxFilesize: 10,
    			uploadMultiple: false,
    			createImageThumbnails: true,
    			maxFiles: 10,
    			acceptedFiles: '.jpeg,.png,.gif,.jpg',
    			addRemoveLinks: true,
    			autoProcessQueue: true
           
           });
    	                     
   dropzone.processQueue();
   dropzone.on("success",()=>{
    	console.log("true");
    
    })
    
  
     </script>
          

    </script>
 </body>
</html>