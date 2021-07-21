const id_sendOTP = document.querySelector("#id_sendOTP");
const phone = document.querySelector("#id_phone");
const id_checkOTP = document.querySelector("#id_enterOTP");
const saveDetails = document.querySelector("#id_saveDetails");
const saveDetailsf = document.querySelector("#id_saveDetailsf");

const sendOTP = async () => {
       response = await fetch("send_otp.do?phone="+phone.value);
       return response.text();
 };
 
 id_saveDetails.addEventListener("click",(event)=>{
 
                   phone.disabled = false;  
                   id_checkOTP.disabled = false;
 });
 id_sendOTP.addEventListener("click",(event)=>{
 
        sendOTP().then((data)=>{
              phone.disabled = true;
              console.log(data);
        
        }).catch((error)=>{
        
           console.log(error);
       
        });

  });
  
  const checkOTP = async ()=>{
     if(id_checkOTP.value > 1110){
     
     response = await fetch("check_otp.do?otp="+id_checkOTP.value);
     return response.text();
     }
  }
  id_checkOTP.addEventListener("keyup",(event)=>{
  
     checkOTP().then((data)=>{
            if(data == "signin"){
               window.location="seller_signin.do";
              }else if(data == "true"){
                  
		          saveDetailsf.classList.add("d-none");
		          saveDetails.classList.remove("d-none");
		          id_checkOTP.disabled = true;
		          id_checkOTP.style.color = "green";
		       }
		     }).catch((error)=>{
		        console.log(error);
		     });
  });
  