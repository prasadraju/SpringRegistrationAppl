package com.prasad.registration.dao;

import com.prasad.registration.model.User;

public interface UserDao {
	
	public void insertUser(User user);
	
	public boolean getUser(User user);
	
	

}
