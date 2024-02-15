package com.store.app.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.store.app.bean.User;


import org.springframework.stereotype.Service;

import com.store.app.bean.User;

@Service
public interface UserService 
{
	public User loginUser(String username, String password);
	
	public void registerUser(User user);
	
	public int update(User u);
	
	public User getUserByUsername(String username);

	public int getByEmail(String username, String email);
	
	public boolean changePassword(String username,String password);


}
