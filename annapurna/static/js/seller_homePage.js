const del = document.querySelectorAll(".del");
const products = document.querySelector("#products");
const allpro = document.querySelector("#allproducts");
const edit = document.querySelectorAll(".edit");

const pics = document.querySelector("#pics");
const allpics = document.querySelector("#allpics");


const editProduct = async (b) =>{
         
         response = await fetch("seller_editproduct.do?productId="+b);
         return response.text();
}

const deleteProduct = async (btn) =>{
            
             response = await fetch("seller_deleteproduct.do?btn="+btn);
              
             
              return response.text();
             
} 

del.forEach((button)=>{
  button.addEventListener("click",(event)=>{
        
        
        deleteProduct(button.value).then((data)=>{
	              
			        if(data == "true"){
			          console.log("ho gaay");
                     location.reload();
			        }
	         }).catch((error)=>{
           console.log(error);
         });
  });









edit.forEach((button)=>{
                 
				 button.addEventListener("click",(event)=>{
				   
				    editProduct(button.value).then((data)=>{
				          
						         if(data=="true"){
						          window.location = "seller_addProduct.jsp";
						         }else{
						           console.log("no");
						         }
				          
				          }).catch((error)=>{
				                console.log(error);
				         });
				 
				  })
});
});			  





const canc = document.querySelector("#id_cancel");
const dele = document.querySelector("#id_delete");
const sele= document.querySelector("#id_select");
const che = document.querySelectorAll(".che");

canc.addEventListener("click",(event)=>{location.reload()});

sele.addEventListener("click",(event)=>{
   sele.classList.add("d-none");
   canc.classList.remove("d-none");
   dele.classList.remove("d-none");
   
   che.forEach((input)=>{ input.classList.remove("d-none")})
 
   });
   
   
const deletePics = async (val) =>{

       response = await fetch("delpic.do?url="+val);
       return response.text();

}
   
 dele.addEventListener("click",(event)=>{
 
	 che.forEach((input)=>{
			   if(input.checked==true){
			       console.log(input.value);
			       deletePics(input.value).then((data)=>{

			             if(data =="true"){
					             
					             console.log(data);
					             location.reload();
			            
			             }else if(data=="expire"){
			     
			               window.location = "seller_signin.jsp";
			   
					     }else{
					         console.log(data);
					    }
					             
			             }).catch((error)=>{console.log(error)});
			   }
	       })
 
 })  
 
  
