const prod = document.querySelector("#all_products");
const shop = document.querySelector("#all_shops");
const all = document.querySelector("#all");
const sel = document.querySelector("#sel");
const inu = document.querySelectorAll(".inu");
const menu = document.querySelector("#id_menu");
const myframe = document.querySelector("#myframe");
  
let  d = 0;

inu.forEach((li)=>{
	li.addEventListener("click",(event)=>{
	
			sel.innerHTML = li.innerHTML;
			
	
			if(!menu.classList.contains("d-none")){
			menu.classList.toggle("d-none");
			}
	
  })
  
})





sel.onclick=function(){
    
    myframe.classList.add("d-none");
	if(menu.classList.contains("d-none")){
	menu.classList.toggle("d-none");
	
	}
 }

const srhbtn = document.querySelector("#srh");
const srhint = document.querySelector("#search");


const likeProducts = async (like) =>{
	   
   response = await fetch(`searchproductslike.do?like=${like}&nm=${sel.innerHTML}`);
   return response.text();

}

const likeShops = async (like) =>{
	
	response = await fetch(`searchshopslike.do?like=${like}&nm=${sel.innerHTML}`);
    return response.text();

}


/*const body = document.querySelector("#body-b");

body.addEventListener("bue",(event)=>{
      myframe.classList.add("d-none");
});*/

srhbtn.addEventListener("click",(event)=>{

	console.log(srhint.value);
	myframe.classList.add("d-none");
	if(sel.innerHTML == "All"){
		
		console.log(sel.innerHTML);
		
	    event.preventDefault();
        likeProducts(srhint.value).then((data)=>{
               
              window.location = "indexSearch.jsp";
        }).catch((error)=>{console.log(error)});
        likeShops(srhint.value).then((data)=>{
              window.location = "indexSearch.jsp";
        }).catch((error)=>{console.log(error)}); 
       
       
	
	}else if(sel.innerHTML=="Products"){
		
		console.log(sel.innerHTML);
	    event.preventDefault();
        likeProducts(srhint.value).then((data)=>{
               window.location = "indexSearch.jsp";
        }).catch((error)=>{console.log(error)});
		
	}else if(sel.innerHTML == "Shops"){
		
		console.log(sel.innerHTML);
	    event.preventDefault();
        likeShops(srhint.value).then((data)=>{
           window.location = "indexSearch.jsp";
        }).catch((error)=>{console.log(error)});
       
	}
	
});

