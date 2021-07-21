const searchInput = parent.document.getElementById("search");
const autobox = parent.document.getElementById("autocom");
const myframe = parent.document.getElementById("myframe");
const lies = document.querySelectorAll("li");
const sel = parent.document.querySelector("#sel");
const menu = parent.document.querySelector("#id_menu");


lies.forEach((li)=>{
   
      li.setAttribute("onclick","select(this)");
});


function select(element){
   myframe.classList.remove("d-none");
   let selecteddata = element.textContent;
   searchInput.value = selecteddata;
   myframe.classList.add("d-none");
}


const searchNameLike = async ()=>{
		
	const val = searchInput.value;
	response =  await fetch(`searchnamelike.do?nameLike=${searchInput.value}&nm=${sel.innerHTML}`);
	return response.text();
	
}

const searchShopNameLike = async ()=>{
		
	const val = searchInput.value;
	response =  await fetch(`searchshopnamelike.do?nameLike=${searchInput.value}&nm=${sel.innerHTML}`);
	return response.text();
	
}


searchInput.addEventListener("keyup",(event)=>{
      menu.classList.add("d-none");
	  if(event.target.value.length>0){
                     
		             
		             if(sel.innerHTML == "All"){
		                               
						                searchNameLike().then((data)=>{
									        if(data=="true"){
									           location.reload(); 
								            }else{
									           myframe.classList.add("d-none");  
								            }
						                }).catch((error)=>{
							               console.log(error);
						                });
						                
						                
						                searchShopNameLike().then((data)=>{
									        if(data=="true"){
										     location.reload();
								            }else{
									           myframe.classList.add("d-none");  
								            }
						                }).catch((error)=>{
							               console.log(error);
						                }); 
						                
			       }else if(sel.innerHTML=="Products"){
				
										searchNameLike().then((data)=>{
									        if(data=="true"){
										        console.log("success");
								                location.reload();
								            }else{
									           myframe.classList.add("d-none");  
								            }
						                }).catch((error)=>{
							               console.log("fail");
						                });
										
				
			      }else if(sel.innerHTML == "Shops"){
				
										 searchShopNameLike().then((data)=>{
									        if(data=="true"){
										        console.log("success");
								                location.reload();
								            }else{
									           myframe.classList.add("d-none");  
								            }
						                }).catch((error)=>{
							               console.log("fail");
						                }); 
				
		         }	  
       
    }else{
		if(!myframe.classList.contains("d-none")){
		myframe.classList.add("d-none");
	}
 }
   
});


if(lies.length==0){
	console.log("5");
	myframe.classList.add("d-none");
}

const  delay = (function(){
     let time =0;
     return function(callback,ms){
       clearTimeout(timer);
       timer = setTimeout(callback,ms);
     }
})();






if(searchInput.value.length==0){
	 myframe.classList.add("d-none");
}else{
	if(myframe.classList.contains("d-none")){
	myframe.classList.remove("d-none");
	}
}

