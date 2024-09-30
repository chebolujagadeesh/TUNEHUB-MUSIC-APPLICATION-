package com.example.tunehub.services;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.tunehub.entities.Users;
import com.example.tunehub.repositories.UsersRepositories;

@Service
public class UsersServiceImplementation implements UsersService {
     @Autowired
	UsersRepositories repo;
	public String addUser(Users user) {
		
		repo.save(user);
		return "user is added";
		}
	
	public boolean userExist(String email) {
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true; 
		}
		
		
	}

	
	public boolean validateUser(String email , String password) {
		try {
		Users user = repo.findByEmail(email);
		String db_password=user.getPassword();
		System.out.println(user);
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
		}catch (Exception e) {
		      
		         return false;
		}
	        

	}
	public String getRole(String email) {
		
		return  repo.findByEmail(email).getRole();
	}

	@Override
	public Users getUser(String email) {
		
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}
	
	
	
	
}
