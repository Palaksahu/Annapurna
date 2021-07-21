package utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.HttpURLConnection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
public class GoogleRecaptcha{
     
	public static boolean recaptchaTest(HttpServletRequest request)throws IOException {
		 
		 String recParameter =  request.getParameter("g-recaptcha-response");
		 
		 String secretKey = "6LfDyNwaAAAAAAGGQVlBVVit92Ty2WqFe3R-tYm_";
		 
		 String recURL =" https://www.google.com/recaptcha/api/siteverify?secret="+secretKey+"&response="+recParameter+"";
		 
		 URL url = new URL(recURL);
		 
		HttpURLConnection con =(HttpURLConnection)url.openConnection();
		 
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
		outputStream.flush();
		outputStream.close();
		
		int statusCode = con.getResponseCode();
		InputStream inputStream = null;
		
	
		if(statusCode == 200) {
			inputStream = con.getInputStream();
		}else {
			inputStream = con.getErrorStream();
		}
		
		JsonReader jsonReader = Json.createReader(inputStream);
		JsonObject jsonObject = jsonReader.readObject();
		
		 boolean recaptchTest = jsonObject.getBoolean("success");
		 
		 return recaptchTest;
	}
}
