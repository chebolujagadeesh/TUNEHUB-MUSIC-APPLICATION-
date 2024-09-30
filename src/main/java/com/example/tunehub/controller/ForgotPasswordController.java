package com.example.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehub.entities.Users;
import com.example.tunehub.services.ForgotPasswordService;
import com.example.tunehub.services.UsersService;
import com.example.tunehub.utilities.OTPGenerator;

import jakarta.servlet.http.HttpSession;

@Controller
public class ForgotPasswordController {
	 @Autowired
	    private ForgotPasswordService forgotPasswordService;
@Autowired
UsersService userv;
	    @GetMapping("/forgot-password")
	    public String showForgotPasswordForm() {
	        return "forgot-password";
	    }

	    @PostMapping("/forgot-password")
	    public String sendOTP(@RequestParam String email , HttpSession session) {
	    
	     	    session.setAttribute("email", email);
	    	
	            forgotPasswordService.sendOTPEmail(email); 
	            return "verify-otp"; 

	    }

	    @PostMapping("/verify-otp")
	    public String verifyOTP(@RequestParam String otp, HttpSession session) {
	    	  String email = (String) session.getAttribute("email");
	    	
	    	    Users user = userv.getUser(email);

	    	    if (user != null && user.getOtp() != null && user.getOtp().equals(otp)) {
	    	    
	    	        user.setOtp(null);
	    	        userv.updateUser(user); 
	    	        return "password-reset-success";
	    	    } else {
	    	    
	    	        return "incorrect-otp";
	    	    }
	    }
}
