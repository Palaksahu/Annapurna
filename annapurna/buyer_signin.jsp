<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="static/css/form.css" />
     <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <%@ include file="head.jsp" %>
    <title>Annapurna   :   Sign In as Seller </title>
</head>
<body>
   <div class="row fixed-top white border-light border " id="row-a">
            <div class="col-3 border border-light" id="col-a">
                <img src="static/images/home.png" class="mr-4 pb-1" id="img-a1">
                <a href="index.jsp" class="text-primary">Home</a>
                <img src="static/images/a2.png" class="" id="img-a2">
            </div>
        </div>
   
    <%@ include file="header.jsp" %>
    
    <div class="container-fluid" id="con-body">
       <div class="row mb-5" id="row-c1">
           <div class="col-4 border  my-5  mx-auto px-3 shadow">
               
             <div class= "row  text-center  bg-light mb-5 text-white">
               <div class="col-6 p-0"><a  href="seller_signin.do" class=" btn btn-light n btn-block">SignIn as Seller</a></div>
               <div class="col-5 bg-info p-0"><a class="btn btn-info n  btn-block">SignIn as Buyer</a></div>
               <div class="col-1 bg-info p-0"><a href="index.jsp"><h4><li class="fa fa-times text-white  text-center p-0"></li></h4></a>  </div>
               
               </div>
                     
                <form action="#" method="post" class="w-75 " id="form">
                    <div class="form-group mb-5">
                    <label for="email" class=" text-info ">Email</label>
                    <input type="email"  name="email" id="id_email" class="form-control shadow" autocomplete = "off" >
                    <small class="form-text sl d-none invalid-feedback">Invalid Email</small>
                   </div>


               <div class="form-group mb-5">
                    <label for="id_passw" class="text-info">Password</label>
                    <div class="input-group"><input type="password" id="id_passw" name="password" class="form-control shadow eye_input" autocomplete="off" >
  
                     <span class="  border border-info " id="id_eyebox" ><i class="input-group-addon fa fa-eye fa-spin text-info mt-2 mx-2" id="id_eye"  area-hidden="true"></i></span>
                    </div>
                    <small class="form-text sl d-none invalid-feedback">Invalid Password</small>
                    <small class="form-text text-muted ">Maximum 8 chracters</small>
                  </div>
                  
                    
                  <div class="g-recaptcha ml-4 mb-5 d-inline-block shadow" data-sitekey="6LfDyNwaAAAAAMr1gklZ0xZrIhPlULARiMwGpjYK"></div>
                  	
                  <div class="text-center"><input type="submit" value="Log-In" class=" shadow-lg btn px-4 mb-4 btn-primary" ></div>
                  <small><a href=""  class="mb-5">Forgot password  ?</a></small>
                  <h6 class="mt-4 mb-3"><a href="" class="dropdown"  data-toggle="dropdown">Create a new Account</a>
                  <div class="dropdown-menu bg-info">
                            <a href="buyer_signup.do" class="dropdown-item text-white nav-link">SignUp as Buyer</a>
                            <a href="seller_signup.do" class="dropdown-item text-white nav-link">SignUp as Seller</a>
                     </div> 
                     </h6>
               </form>
           </div>
       </div>

    
    </div>
    <%@ include file="footer.jsp" %>
 </body>
</html>