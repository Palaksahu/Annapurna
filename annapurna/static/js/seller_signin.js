const inputs = document.querySelectorAll("input");

const form = document.querySelector("#form");

const sl = document.querySelectorAll(".sl");

const allPatterns ={
                      email : /^([a-zA-Z\d-_])+@([a-zA-Z\d-_]{2,10})\.([a-zA-Z]{2,5})(\.[a-zA-Z]{2,5})?$/,
                   password : /^[a-zA-Z\d-_!@#$%^&*()~]{8,20}$/
                  }   

form.addEventListener("submit",(event)=>{         let i = 0 ;

	                                      inputs.forEach((input)=>{
		                                           
		                                         if(input.classList.contains("is-valid")||input.classList.contains("valid")){
                                                       
                                                        i++;
                                                        			                                      
		                                           }else if(input.classList.contains("is-invalid")){
			                                             console.log(input);
			                                             sl[i].classList.remove("d-none");
                                                          i++;
                                                         event.preventDefault();
                                                         
		                                           }
                                              });  
                                });


inputs.forEach((input)=>{  console.log(input);
	                       input.addEventListener("blur",(event)=>{ 
		                                                               let pattern = allPatterns[event.target.name];
                                                                       let field  = event.target;
                                                                       validation(field,pattern);
	                                                                 
	                                                                });
                           
                           
                       })  ;
                           
                           
function validation(field,pattern){

console.log(pattern.test(field.value));
	if(pattern.test(field.value)){
	
		if(field.classList.contains("is-invalid")){
		
		field.setAttribute("class","form-control is-valid");
		
		}else{
		
			field.setAttribute("class","form-control valid");
		
		}
	
	
	}else{
	
		field.setAttribute("class","form-control is-invalid");
	
		field.addEventListener("keyup",(event)=>{
			
			 if(pattern.test(field.value)){
			     
			     field.setAttribute("class","form-control is-valid");
		        
		         }else{
			    
			     field.setAttribute("class","form-control is-invalid");
		        
		        }	
      	      
      	      });
	 }
 }



 /*----------------------for view Password----------------*/

const password = document.querySelector("#id_passw");
const eyebox = document.querySelector("#id_eyebox");
const eye = document.querySelector("#id_eye");

let flag = true;

eyebox.addEventListener("click",(event)=>{

                          if(flag){
                          
                            password.setAttribute("type","text");
                            
                            eye.setAttribute("class","fa fa-eye-slash text-info mt-2 mx-2");
                            
                            flag = false;
                            
                          }else{
                            
                            password.setAttribute("type","password");
                            
                            eye.setAttribute("class","fa fa-eye text-info mt-2 mx-2");
                            
                            flag = true;
                             
                            }
        });

 password.addEventListener("focus",(event)=>{
                      
                       eye.setAttribute("class","fa fa-eye text-info mt-2 mx-2");
                                
                });