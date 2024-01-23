package com.store.app.service;

import org.springframework.stereotype.Service;

import com.store.app.bean.User;

@Service
public interface UserService 
{
	public User loginUser(String username, String password);

}
