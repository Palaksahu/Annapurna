const inputs = document.querySelectorAll("input");

const form = document.querySelector("#form");

const sl = document.querySelectorAll(".sl");

const allPatterns ={
	                  name : /^[a-zA-Z\d_ ]{2,50}$/,
                      phone : /^[6-9][\d]{9}$/,
                      email : /^([a-zA-Z\d-_])+@([a-zA-Z\d-_]{2,10})\.([a-zA-Z]{2,5})(\.[a-zA-Z]{2,5})?$/,
                      password : /^[a-zA-Z\d-_!@#$%^&*()~]{8,20}$/
                  }   
                  
form.addEventListener("submit",(event)=>{      
                                                  let i = 0;

	                                             inputs.forEach((input)=>{
		                                           
		                                         if(input.classList.contains("is-valid")||input.classList.contains("valid")){
                                                       
                                                        i++;
                                                        			                                      
		                                           }else if(input.classList.contains("is-invalid")){
			                                            
			                                             sl[i].classList.remove("d-none");
                                                          i++;
                                                         event.preventDefault();
                                                         
		                                           }
                                              });  
                                });


inputs.forEach((input)=>{
	                       input.addEventListener("blur",(event)=>{
		                                                               let pattern = allPatterns[event.target.name];
                                                                       let field  = event.target;
                                                                       validation(field,pattern);
	                                                                 
	                                                                });
                           
                           
                       })  ;
                           
                           
function validation(field,pattern){


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


 
 /* ------------------------------------- check existing email-------------------------------*/
 
 
 const emailfield = document.querySelector("#id_email");
const small = document.querySelector("#id_small");
 let pat = /^([a-zA-Z\d-_])+@([a-zA-Z\d-_]{2,10})\.([a-zA-Z]{2,5})(\.[a-zA-Z]{2,5})?$/;
const ajaxReq = async() =>{
                 const response = await fetch(`checkemail.do?email=${emailfield.value}`);
                 return response.text();
               }           

const checkEmail = ()=>{
                   
                      ajaxReq().then((data)=>{
                                    if(data==="true"){
                                            if(emailfield.classList.contains("is-valid")){
                                              emailfield.classList.remove("is-valid"); 
                                            }
                                          
                                           emailfield.classList.add("redborder");
                                          
                                           small.classList.replace("d-none","d-block");
                                           
                                            emailfield.addEventListener("keyup",checkEmail);
                                    }else{
                                         small.classList.replace("d-block","d-none");
                                         console.log("palak");
                                       
                                         }
                                        
                      }).catch((error)=>{});
                   
              }

emailfield.addEventListener("blur",checkEmail);



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
                
 