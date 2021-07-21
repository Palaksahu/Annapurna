const productName = document.querySelector("#id_productName");
const weight = document.querySelector("#id_weight");
const mrp = document.querySelector("#id_mrp");
const price = document.querySelector("#id_price");
const details = document.querySelector("#id_details");
const exdate = document.querySelector("#id_exdate");
const quantity = document.querySelector("#id_quantity");
const add = document.querySelector("#id_add");
const update = document.querySelector("#id_update");
const step1 = document.querySelector("#step1");
const step2 = document.querySelector("#step2");
const step3 = document.querySelector("#step3");
const rowpr = document.querySelector("#row-pr");
const droppic = document.querySelector("#id_picdropdiv");
const branded = document.querySelector("#id_branded");
const branding = document.querySelector("#id_branding");
const local = document.querySelector("#id_local");
const brand = document.querySelector("#id_brand");
const category = document.querySelector("#id_category");




 console.log(branded)
 branded.addEventListener("click",(event)=>{
            branding.classList.remove("d-none");
            
 });
 local.addEventListener("click",(event)=>{
            branding.classList.add("d-none");
            brand.value = "";
 })
 

const saveProduct = async ()=> {

		
			if(brand.value == ""){
			  brand.value = "local";
			}
	        const response = await fetch("seller_addproduct.do",{
		
			method : "POST",
			
			body : JSON.stringify({
									productName : productName.value,
									categoryId : category.value,
									brand  : brand.value, 
									weight : weight.value,
									mrp : mrp.value,
									price : price.value,
									details : details.value,
									exdate : exdate.value,
									quantity : quantity.value,
			                     }),
			
			headers : {"content-type": "application/json;charset= UTF-8"}
		
	  });
	
	return response.text();
};

if(add!=null){
add.addEventListener("click",(event)=>{
	
	     saveProduct().then((data)=>{
			 if(data == "true"){
				   
			       console.log(data);
                   step1.classList.remove("active");
                   step2.classList.add("active");
                   rowpr.style.display = "none";
                   droppic.style.display = "block";
                  
			}else{
				  window.location ="seller_signin.jsp";
			}
	}).catch((error)=>{
		
		console.log(error);
	  });  
	});
	}
	
	
if(update!=null){
 update.addEventListener("click",(event)=>{
 
    saveProduct().then((data)=>{
       console.log(data);
       window.location = "seller_homePage.jsp";
    }).catch((error)=>{
      console.log(error);
    })
    
 });
}
