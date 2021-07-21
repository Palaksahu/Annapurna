<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="head.jsp" %>
    <title>Annapurna   :   SignUp as Seller </title>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
    <link rel="stylesheet" type="text/css" href="static/css/form.css" />
    </head>
<body>
    
         <div class="row fixed-top white border-light border " id="row-a">
            <div class="col-3 border border-light" id="col-a">
                <img src="static/images/home.png" class="mr-4 pb-1" id="img-a1">
                <span class="text-secondary">Home</span>
                <img src="static/images/a2.png" class="" id="img-a2">
                <span class="text-primary">SignUp as Seller</span>
                <img src="static/images/a2.png" class="" id="img-a2">
            </div>
        </div>
        
       <%@ include file="header.jsp" %>
       
       <div class="container-fluid" id="con-body">
       
       <div class="row " id="row-c1">
           <div class="col-4 border mx-auto p-0 shadow">
               <div class="text-center mb-5 p-1 bg-info text-white"><h4>SignUp<a href="index.jsp"><i class="fa fa-times text-white float-right"></i></a></h4></div>
               <form action="seller_signup.do" method="post" class="w-75 " id="form">
                
                   <div class="form-group mb-4 ">
                       <label for="id_name" class="">Shop Name</label>
                       <input type="text" id="id_name" name="name"    value="${param.name}" class="form-control" autocomplete="off" >
                      <small class="form-text sl d-none invalid-feedback">Invalid Shop Name(min 2 characters allowed)</small>
					
                   </div>

                   <div class="form-group mb-4">
                    <label for="id_phone" class=" ">Phone</label>
                    <input type="text" id="id_phone" name="phone"  value="${param.phone}" class="form-control " autocomplete="off"  >
                    <small class="form-text sl d-none invalid-feedback">Invalid Phone number</small>
					
					
                   </div>

                   <div class="form-group mb-4">
                    <label for="id_email" class=" ">Email</label>
                    <input type="email" id="id_email"  value="${param.email}" name="email" class="form-control" autocomplete="off" >
                   <small class="form-text sl d-none invalid-feedback">Invalid Email</small>
                   <small class=" text-danger d-none" id="id_small"> Email already exist</small>

                   </div>

                   <div class="form-group mb-4">
                    <label for="id_passw" class="">Password</label>
                 <div class="input-group"><input type="password" id="id_passw"  name="password" class="form-control eye_input" autocomplete="off">
                   
                 <span class=" input-group-addon border border-info " id="id_eyebox" ><i class="fa fa-eye fa-spin text-info mt-2 mx-2" id="id_eye"  area-hidden="true"></i></span>  
                    </div>   
                    <small class="form-text text-muted">minimum 8 characters allowed</small>
					
					 <small class="form-text d-none sl invalid-feedback">Invalid Password</small>
                   </div>
                   
                    
                <div class="g-recaptcha ml-4 mb-5 d-inline-block shadow" data-sitekey="6LfDyNwaAAAAAMr1gklZ0xZrIhPlULARiMwGpjYK"></div>
                   
                  <div class="text-center"><input type="submit" value="SignUp" class=" btn px-4 mb-4 btn-primary" ></div>


               </form>
           </div>
            <div class="">
            <%  String errors = (String)request.getAttribute("errors");  %>
                <% if(errors != null){  %>
        	           <div class="shadow-lg mt-5 p-2" id="error-box">
        	      <h3 class= "my-1">   Errors :</h3>
        	         <%= errors %>
        	            </div>
                <%    }   %>
             </div>
      
      
       </div>

    
    </div>
      
      <%@ include file="footer.jsp" %>
     <script type="text/javascript" src="static/js/seller_signup.js"></script>
     
</body>
</html>