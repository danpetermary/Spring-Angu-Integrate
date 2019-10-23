package com.stackroute.cgiauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stackroute.cgiauth.model.Useradmin;
import com.stackroute.cgiauth.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public boolean validateuser(String uname, String password) {
		 Useradmin uobj=userRepo.findByUserNameAndUserPassword(uname, password);
		 if(uobj==null)
		return false;
		 else
			 return true;
	}

	@Override
	public void addUser(Useradmin uobj) {
		 userRepo.save(uobj);
		
	}

}
