package com.stackroute.cgiauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.cgiauth.model.Useradmin;

@Repository
public interface UserRepo extends JpaRepository<Useradmin,String>
{
	//public Useradmin findbyUsername();
	//public Useradmin findbyUserpassword();
  public Useradmin findByUserNameAndUserPassword(String uname,String userPassword);
}
