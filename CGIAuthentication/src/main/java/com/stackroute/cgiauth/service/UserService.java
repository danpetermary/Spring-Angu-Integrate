package com.stackroute.cgiauth.service;

import com.stackroute.cgiauth.model.Useradmin;

public interface UserService {
 public boolean validateuser(String uname,String password);
 public void addUser(Useradmin uobj);
}
