package com.stackroute.cgiauth.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.cgiauth.model.Useradmin;
import com.stackroute.cgiauth.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin

public class UseradminController {
	@Autowired
	UserService userService;
	
	
	@PostMapping("/myboot/add")
	public ResponseEntity<Useradmin> addrec(@RequestBody Useradmin user)
	{
		userService.addUser(user);
		return new ResponseEntity<Useradmin>(user,HttpStatus.OK);
	}
	
	@PostMapping("/myboot/login")
	public ResponseEntity<?> loginchk(@RequestBody Useradmin user)
	{
	boolean ans= userService.validateuser(user.getUserName(), user.getUserPassword());
	 if(ans)
	 {
		 String tok=getToken(user.getUserName(),user.getUserPassword());
		 Map<String,String> mp=new HashMap();
		 mp.put("token", tok);
		 return new ResponseEntity<Map>(mp, HttpStatus.OK);
	 }
	 else
	return new ResponseEntity<String>("Invalid username/pwd",HttpStatus.NOT_FOUND);	 
	}
		
	private String getToken(String userId, String password)  {

		long expirationTime=10_00_0000;
		       return Jwts.builder().setSubject(userId)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+expirationTime)).
		signWith(SignatureAlgorithm.HS256,"secretKey").compact();
		 		        
		}


}
