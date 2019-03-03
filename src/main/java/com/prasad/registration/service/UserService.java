package com.prasad.registration.service;

import com.prasad.registration.model.User;

public interface UserService {
	
    void register(User user) ;
    boolean checkUser(User user);
}
