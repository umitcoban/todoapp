package com.in28minutes.login;

public class LoginService {

	public boolean isValidUser(String userName, String password) {
		if(userName.equals("test")&& password.equals("test")) {
			return true;
		}
		else
			return false;
	}
}
