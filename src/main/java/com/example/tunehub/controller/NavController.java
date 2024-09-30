package com.example.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "register";
	}
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "login";
	}
	@GetMapping("/map-addsongs")
	public String addsongsMapping()
	{
		return "addsongs";
	}
	@GetMapping("/samplepayment")
	public String razorpay()
	{
		return "testpayment";
	}

	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
	
	
}
