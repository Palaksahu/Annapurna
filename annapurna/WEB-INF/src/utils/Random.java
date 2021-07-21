package utils;

public class Random {
   
	public static int getOTP() {
		
		int min = 1111;
		int max = 9999;
		
		int  otp = new java.util.Random().nextInt(max-min)+min;
		return otp;
	}
}
