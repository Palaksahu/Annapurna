

<%@page import="java.util.ArrayList"%>
<div class="container-fluid" id="con-header">

 
        <div class="row fixed-top" id="row-b">
            <div class="col" id="col-b">
                     <div class="navbar navbar-expand-lg black" id="navi">
                        <a class="ann" href=""><img src="static/images/a7.png" id="ann"></a>
                        <ul class="navbar-nav black justify-content-center">
                            <li class="nav-item dropdown">
                                
                                <form class="form-inline ml-5"  >
                                 
                                  
                                  <% String nm = (String)session.getAttribute("nm");
                                     if(nm !=null){%>
                                    <button class="btn btn-primary dropdown-toggle btn-sm my-2" data-toggle="dropdown" id="sel">${nm}</button>
                                    <%}else{ %>
                                    <button class="btn btn-primary dropdown-toggle btn-sm my-2" data-toggle="dropdown" id="sel">All</button>
                                    <%} %>
                                     <div class="dropdown-menu" id="id_menu">
                                          <li class="dropdown-item nav-link  inu" id="all" >All</li>
                                          <li  class="dropdown-item nav-link inu"  id="all_shops">Shops</li>
                                           <li class="dropdown-item nav-link inu" id="all_products">Products</li>
                                    
                                    </div> 
                                  
                                <!-- <select class="btn btn-primary btn-sm p-0" style="width:70px" id="sel">
                                    <option class=" text-dark white d-none" id="all">All</option>
                                    <option class="white text-dark" id="all_products" style="cursor:pointer">Products</option>
                                    <option class="white text-dark" id="all_shops">Shops</option>
                                   </select> -->   
                                  <div class="navbar-search smallsearch px-0  bg-primary border border-primary"  id="body-b"> 
                                  
                                  <input type="search" placeholder="Search" value="${like}"  name = "searching" autocomplete="off" class="navbar-input btn-sm form-control" id="search">
                                  
                                  <div class="autocom-box " id="id_autocom">
                                   
                                    <iframe src="2.jsp" scrolling="no" id="myframe" class="" width="500px;" ></iframe> 
                                   
                                   
                                  </div>
                                 
                                  </div>
                                   <input type="submit" value="search" id="srh" class="ml-1 btn btn-primary  btn-sm" >
                                 </form>
                            </li>
                            <li class="nav-item dropdown mx-5"> 
                              
                                <a href="" class=" nav-link dropdown-toggle btn btn-secondary mt-2 mx-5 btn-sm" id="jbp" data-toggle="dropdown">Jabalpur</a>
                                <div class="dropdown-menu">
                                    <a href="" class="dropdown-item nav-link">Jabalpur</a>
                                    <a href="" class="dropdown-item nav-link">Vidisha</a>
                                    <a href="" class="dropdown-item nav-link">Bhopal</a>
                                    <a href="" class="dropdown-item nav-link">Indore</a>
                                    <a href="" class="dropdown-item nav-link">Gwalior</a>
                                    <a href="" class="dropdown-item nav-link">Amarkanthak</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown mr-2 " id="acc-li">
                             <a  href="" class="btn-sm btn nav-link btn-dark border-light " data-toggle="dropdown" id="account">Account</a> 
                               <ul>
                               <div class="dropdown-menu bg-dark">
                                   
                                    <a href="buyer_signin.jsp"  class="dropdown-item nav-link text-white"><li class="fa fa-sign-in text-primary"></li>&nbsp; &nbsp; SignIn</a> 
                                           
                                    <a href=" "  class="dropdown-item dropdown-toggle nav-link text-white" data-toggle="dropdown"><li class="fa fa-user-plus text-primary "></li>&nbsp;&nbsp; SignUp</a>
                                           <ul>
                                            <div class="dropdown-menu bg-info">
                                                <a href="buyer_signup.do" class="dropdown-item text-white nav-link"><li class="fa fa-shopping-bag text-danger"></li>&nbsp;&nbsp;SignUp as Buyer</a>
                                                <a href="seller_signup.do " class="dropdown-item text-white nav-link"><li class="fa fa-balance-scale text-danger"></li>&nbsp;&nbsp;SignUp as Seller</a>
                                            </div>
                                            </ul>                    
                                </div>
                                </ul>
                            </li> 
                            <!-- <li class="nav-item " id="cart-li">
                                 <img src ="static/images/cart5.png" class="" id="cart" >
                            </li>    -->
                             <a class="display-4 " href="#"><li class="fa fa-cart-plus text-primary float-right text-center py-0"></li> </a>   
                        </ul>
                     </div>
              </div>
        </div>
    </div>
       
   <script type="text/javascript" src="static/js/common_header.js"></script>