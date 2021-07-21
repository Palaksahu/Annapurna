package utils;


	// Install the Java helper library from twilio.com/docs/java/install

	import com.twilio.Twilio;
	import com.twilio.rest.api.v2010.account.Message;
	import com.twilio.type.PhoneNumber;

	public class SendSMS {
	    // Find your Account SID and Auth Token at twilio.com/console
	    // and set the environment variables. See http://twil.io/secure
	    public static final String ACCOUNT_SID = "ACa167713b2f633b2dca68a7467950b1fd";
	    public static final String AUTH_TOKEN =  "b2761765d72e8c630371ddd029838f56";

	    public static void sendOTP(String phone , String msg){
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("+91"+phone),
	                new com.twilio.type.PhoneNumber("+17208971210"),
	                msg)
	            .create();

	        System.out.println(message.getSid());
	    }
}
