package com.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.app.bean.User;
import com.store.app.dao.UserRepository;

public class UserImpl implements UserService 
{
	@Autowired
	private UserRepository userrepository1;

	@Override
	public User loginUser(String username, String password) 
	{
		// TODO Auto-generated method stub
		return userrepository1.findByUsernameAndPassword(username, password);
	}

}
