package com.store.app.service;

import org.springframework.stereotype.Service;

import com.store.app.bean.User;
@Service
public interface UserService 
{
	public User loginUser(String username, String password);
	
	public void registerUser(User user);
	
	public int getByEmail(String username, String email);
	
	public boolean changePassword(String username,String password);
	public User getUserByUsername(String username);

	public int update(User g);

}
