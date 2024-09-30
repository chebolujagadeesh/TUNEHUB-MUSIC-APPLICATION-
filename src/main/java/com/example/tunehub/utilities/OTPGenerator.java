package com.example.tunehub.utilities;
import java.security.SecureRandom;



public class OTPGenerator {

	  private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    private static final SecureRandom RANDOM = new SecureRandom();

	    public static String generateOTP(int length) {
	        StringBuilder otp = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            otp.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
	        }
	        
	       
	        return otp.toString();
	        
	    }
}
