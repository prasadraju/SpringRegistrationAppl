package com.prasad.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.registration.dao.UserDao;
import com.prasad.registration.model.User;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDao dao;
	
	@Override
	public void register(User user) {
		
		dao.insertUser(user);
	}

	@Override
	public boolean checkUser(User user) {
		
		boolean result =dao.getUser(user);
		
		return result;
		
	}

}
