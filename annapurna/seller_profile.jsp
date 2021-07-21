<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="head.jsp" %>
    <%@ page import = "java.util.ArrayList  , models.City" %>
    <%@ page import = "models.Shop" %>
    <title>Annapurna   :   My Account </title>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
    <link rel="stylesheet" type="text/css" href="static/css/form.css" />
    <link rel="stylesheet" type="text/css" href="static/css/dropzone.min.css" />
    <style>
    #pro{
    display : none;
    }
    #id_dropzone{
    font-size : 45px;
    font-style : italic;
    }
     
    </style>
    </head>
<body class="bg-secondary">
    
         <div class="row fixed-top white border-light border " id="row-a">
            <div class="col-3 border border-light" id="col-a">
                <img src="static/images/home.png" class="mr-4 pb-1" id="img-a1">
                <a href="seller_homePage.jsp" class="text-primary">My Account</a>
                <img src="static/images/a2.png" class="" id="img-a2">
                <span class="text-secondary">Profile</span>
                <img src="static/images/a2.png" class="" id="img-a2">
            </div>
        </div>
        
       <%@ include file="seller_header.jsp" %>
       
       <div class="container-fluid " id="con-body">
       <div class="row">
         <div class="col-11 display-4 mx-auto  bg-warning text-white text-center p-2">
           Update Profile<a href="seller_homePage.jsp"><i class="fa fa-times  text-white float-right"></i></a>
         </div>
       </div>
       <div class="row pr-5 mb-5" id="row-c1">
         <% Shop shop = (Shop)session.getAttribute("shop"); %>
           <div class="col-7 mx-auto  bg-secondary text-center">
                <div class="h-50 ml-3 w-100 white border shadow-lg pt-5">
	             <img alt="" class="shadow-lg" src ="seller_showpropic.do?propic=${shop.propic}" width="750px" height="450px">
	        </div>  
	            <form class=" ml-3 w-100 h-50  border shadow-lg dropzone text-info text-center" id="id_dropzone">
	             
	          
	             </form>
            
           <input class="btn btn-info  shadow-lg mt-2 px-2 mb-5" type="button" value="Upload" id="id_uploadbtn">
           
           </div>  
            
          
           <div class="col-4  border border-primary mx-auto  bg-white shadow-lg">
              
               <form action="seller_profile.do" method="post" class="w-75 mt-5 mb-5" id="form">
                
                   <div class="form-group mb-4 ">
                       <label for="id_name" class="text-info">Shop Name</label>
                       <input type="text" id="id_name" name="name"    value="${shop.name}" class="form-control shadow" autocomplete="off" >
                      <small class="form-text sl d-none invalid-feedback">Invalid Shop Name(min 2 characters allowed)</small>
					
                   </div>

                   <div class="form-group mb-4">
                    <label for="id_details" class="text-info ">Shop Details</label>
                    <textarea type="text" id="id_details" name="details"  class="form-control shadow " autocomplete="off"  >${shop.details}</textarea>
                    <small class="form-text sl d-none invalid-feedback">Invalid Phone number</small>
					</div>
					
					
                   <div class="form-group mb-4">
                    <label for="id_address" class=" text-info">Address</label>
                    <textarea type="text" id="id_address" name="address" class="form-control shadow" autocomplete="off" >${shop.address}</textarea>
                   <small class="form-text sl d-none invalid-feedback">Invalid Email</small>
                   <small class=" text-danger d-none" id="id_small"> Email already exist</small>

                   </div>
                   
                   <div class="form-group mb-4 ">
                       <label for="id_phone" class="text-info">Phone</label>
                       <input type="text" id="id_phone" name="phone"  value="${shop.phone}" class="form-control shadow" autocomplete="off" >
                      <small class="form-text sl d-none invalid-feedback">Invalid Shop Name(min 2 characters allowed)</small>
					</div>
					
					 <div class="form-group mb-4 ">
					 <% ArrayList<City> cityArrList = City.getAllCities();
					    
					 %>
                       <label for="id_city" class="text-info">City</label>
                       <select name="city" id="id_city" class="form-control shadow">
                       <option disabled hidden selected>Select City</option>
                       <% for(City city : cityArrList){ 
                       if(city.getCityId() == shop.getCity().getCityId()){    %>
                           <option value ="<%= city.getCityId() %>" selected > <%= city.getCity()+"["+city.getState().getState()+"]" %></option>
                     <% }else {   %>
                          <option value ="<%= city.getCityId() %>" > <%= city.getCity()+"["+city.getState().getState()+"]" %></option>
                       <% } } %>
                       </select>
                      <small class="form-text sl d-none invalid-feedback">Invalid Shop Name(min 2 characters allowed)</small>
					</div>
					
				  
                  <div class="text-center row mt-5 form-group">
                  
                     <input type="button" value="Send OTP" id="id_sendOTP" class=" col-3 shadow-lg btn px-2 py-1 btn-success mx-auto">
                    
                     <input type="text" placeholder="Enter OTP" id="id_enterOTP" class="mx-auto text-center shadow-lg text-danger col-4 form-control" >
                 
                  </div>
                   
                  <div class="row">
                     
                     <input type="submit" value="Save Details"   id="id_saveDetails" class=" d-none mt-5 mx-auto shadow-lg btn px-4  btn-primary"  >
                     <input type="button" value="Save Details"   id="id_saveDetailsf" class=" mt-5 mx-auto shadow-lg btn px-4  btn-secondary" disabled>
                   </div>              
           </div>
                 
      
       </div>
       
    </div>
      
      <%@ include file="footer.jsp" %>
     <script type="text/javascript" src="static/js/dropzone.min.js"></script>
     <script>
		     Dropzone.autoDiscover = false;
		
		     Dropzone.options.id_dropzone = {
		                paramName: 'file',
		     			maxFilesize: 1,
		     			uploadMultiple: false,
		     			createImageThumbnails: true,
		     			maxFiles: 1,
		     			acceptedFiles: '.jpeg,.png,.gif,.jpg',
		     			addRemoveLinks: true,
		     			autoProcessQueue: false
		     };
		
		     let dropzone = new Dropzone('#id_dropzone',{url:'shop_propic_upload.do'});
		     let uploadbtn = document.querySelector("#id_uploadbtn");
		
		     uploadbtn.addEventListener('click',()=>{
		                       
		     	                dropzone.processQueue();
		     	                location.reload();
		     	                
		     	                
		     });
     </script>
     <script type="text/javascript" src="static/js/seller_profile.js"></script>
     
</body>
</html>