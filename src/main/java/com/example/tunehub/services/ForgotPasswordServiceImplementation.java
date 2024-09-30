package com.example.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.Users;
import com.example.tunehub.repositories.UsersRepositories;
import com.example.tunehub.utilities.OTPGenerator;

import jakarta.servlet.http.HttpSession;
@Service
public class ForgotPasswordServiceImplementation implements ForgotPasswordService {
	@Autowired
    private UsersRepositories userRepository;

    @Autowired
    private EmailService emailService;

    public void sendOTPEmail(String email) {
        Users user = userRepository.findByEmail(email);
    
            String otp = OTPGenerator.generateOTP(6);
            user.setOtp(otp); 
            userRepository.save(user); 
            emailService.sendOTPEmail(email, "Password Reset OTP", "Your TUNE HUB OTP is: " + otp);
        

    }
}
