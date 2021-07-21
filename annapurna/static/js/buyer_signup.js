const form = document.querySelector("#form");
const inputs = document.querySelector("input");



const allPatterns = {   
	                   name : /^[a-zA-Z_ ]{2,100}$/,
                       email : /^[a-zA-Z0-9_]+@([a-zA-Z0-9]{2,10})\.([a-zA-Z]{2,5})(\.[a-zA-Z]{2,5}?)$/,
	                   phone :/^[6-9][0-9]{9}$/,
                       password : /^[a-zA-Z0-9-_ &*%$#@!]{8,20}$/
	
                         };

inputs.forEach((input)=>{
	
	input.addEventListener("blur",(event)=>{
		
		const field = event.target
	});
	
});