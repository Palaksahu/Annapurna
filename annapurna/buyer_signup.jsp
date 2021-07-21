<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="head.jsp" %>
    <title>Annapurna   :   SignUp as Buyer </title>
    <link rel="stylesheet" type="text/css" href="static/css/form.css" />
</head>
<body>
 
       <div class="row fixed-top white border-light border " id="row-a">
            <div class="col-3 border border-light" id="col-a">
                <img src="static/images/home.png" class="mr-4 pb-1" id="img-a1">
                <span class="text-secondary">Home</span>
                <img src="static/images/a2.png" class="" id="img-a2">
                <span class="text-primary">SignUp as Buyer</span>
                <img src="static/images/a2.png" class="" id="img-a2">
            </div>
        </div>

     <%@ include file="header.jsp" %>
    <div class="container-fluid" id="con-body">
       <div class="row " id="row-c1">
           <div class="col-4 border mx-auto p-0 shadow">
               <div class="text-center mb-5 p-1 bg-info text-white"><h4>SignUp<a href="index.jsp"><i class="fa fa-times text-white float-right"></i></a></h4></div>
               <form class=" w-75 " action="buyer_signup.do" method="post" id="form">
                
                   <div class="form-group mb-4 ">
                       <label for="name" class=" ">User Name</label>
                       <input type="text" id="id_name"  name="name" class="form-control" >
                       <small class="text-muted "></small>
                   </div>

                   <div class="form-group mb-4">
                    <label for="phone" class=" ">Phone</label>
                    <input type="text" id="id_phone"  name="phone" class="form-control " >
                   </div>

                   <div class="form-group mb-4">
                    <label for="email" class=" ">Email</label>
                    <input type="email" id="id_email"  name ="email" class="form-control" >
                   </div>

                   <div class="form-group mb-5">
                    <label for="passw" class="">Password</label>
                    <input type="password" id="id_password" name ="password" class="form-control" >
                    <small class="form-text text-muted ">Confirm password</small>
                   </div>
                    

                  <div class="text-center"><input type="submit" value="Signup"  class=" btn px-4 mb-4 btn-primary" ></div>


               </form>
           </div>
       </div>

    
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>