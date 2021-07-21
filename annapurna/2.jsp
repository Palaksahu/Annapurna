 <%@page import="java.util.ArrayList"%>
 <%@ include file="head.jsp" %>
 <style>
 	 li{
	   padding: 10px  20px;
	   width : 500px;
	}
	ul{
	 list-style-type :none;
	 padding-left : 2px;
	 cursor:pointer;
	 font-size : 12px;
	}
	a.nav-link:hover{
    background-color: #e0e0e0;
    border : none;
    color : black;
}
	
	</style>
	<ul class="" id="id_ulblur">
                                         <%  
                                     
                                      ArrayList<String> nameLikeList = (ArrayList<String>)session.getAttribute("nameLikeList"); 
                                         
                                      ArrayList<String> shopNameLikeList = (ArrayList<String>)session.getAttribute("shopNameLikeList"); 
                                       if(nameLikeList != null){
 
                                       for(String nameLike : nameLikeList){  
                                    
                                    	  %>
                                       
                                       <a class=" nav-link text-dark  p-0" ><li class="lie p-1" onclick = ""><%=nameLike %></li></a> 
                                       
                                   <% } }
                                       
                                           if(shopNameLikeList != null){
                                    	   
                                           for(String nameLike : shopNameLikeList){  
                                        
                                        	  %>
                                           
                                           <a class=" nav-link text-dark  p-0" ><li class="lie p-1" onclick = ""><%=nameLike %></li></a> 
                                           
     
                                       <%}}
                                           
                                         
                                           %>
                                       
                                       
                                       
                                     </ul>
      <script type="text/javascript" src="static/js/index.js"></script>