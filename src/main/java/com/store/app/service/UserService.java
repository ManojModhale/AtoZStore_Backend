package com.store.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.store.app.bean.User;

@Service
public interface UserService {
	
	public User addregister(User u);
	public User userlogin(User u);
	public int update(User u);
	public List<User> getUser();
	public User loginuser(String username, String password);
	public User forgetpassword(String username,String email);
	public User getUserByUsername(String username);
}
