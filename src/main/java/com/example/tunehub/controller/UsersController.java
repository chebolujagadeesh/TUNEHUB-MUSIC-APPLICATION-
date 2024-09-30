package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehub.entities.Song;
import com.example.tunehub.entities.Users;
import com.example.tunehub.services.SongService;
import com.example.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UsersController {
	@Autowired
	UsersService service;
	@Autowired
	SongService songserv;
	
      @PostMapping("/register")
	  public  String addUser(@ModelAttribute Users user)
	  {	
    	 boolean userStatus = service.userExist(user.getEmail());
    	 if(userStatus == false)
    	 {
         service.addUser(user);
            return "registersuccessful";
    	 }
    	 else
    	 {
    		 return "registerfail";
    	 }
    	
    	 }
      @PostMapping("/login")
      public String validateUser(@RequestParam String email , @RequestParam String password, HttpSession session)
      {
    	    
    	    if(service.validateUser(email,password)==true )    	    	
    	    {
    	    	session.setAttribute("email", email);
    	    	if(service.getRole(email).equals("admin"))
    	    	{
    	    		
    	    		return "adminhome";
    	    	}
    	    	else
    	    	{
    	    		return "customerhome";
    	    	}
    	    	
    	    	
    	    }
    	    else
    	    {
    	    	 return "loginfail";
    	    }
    	  
    	 
      }
      @GetMapping("/exploresongs")
      public String exploreSongs(HttpSession session , Model model)
      {
    	   String email=(String)session.getAttribute("email");
    	               Users user= service.getUser(email);
    	                       
    	               if(user.isPremium()==true)
    	               {
    	            	   List<Song> songList = songserv.getAllSongs();
    	        		   model.addAttribute("songList", songList);
    	        		  
    	            	   return "displaysongs2";
    	               }
    	               else
    	               {
    	            	   return "testpayment";
    	               }
    	  
      }
      @GetMapping("/logout")
      public String logOut(HttpSession session)
      {
    	  session.invalidate();
    	  return "login";
      }
      
     @GetMapping("/home")
     public String home(HttpSession session)
     {
    	 String email=(String)session.getAttribute("email");
         Users user= service.getUser(email);
         if(service.getRole(email).equals("admin"))
	    	{
	    		return "adminhome";
	    	}
	    	else
	    	{
	    		return "customerhome";
	    	}
     }
     @GetMapping("/profile")
     public String profile(HttpSession session , Model model)
     { 
    	 String email=(String)session.getAttribute("email");
         Users user= service.getUser(email);
          model.addAttribute("profile", user);
          return "profile";
    	 
     }
     @PostMapping("/resetpassword")
     public String  resetpassword(@RequestParam String password1 ,@RequestParam String password2,HttpSession session ) {
    
    	 
         if(password1.equals(password2))
         {
        	 String email=(String)session.getAttribute("email");
             Users user= service.getUser(email);
                    user.setPassword(password1);
                	service.updateUser(user);
                	return "login";
         }
         return "password-reset-success";
     }
     
}
