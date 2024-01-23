package com.store.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.User;
import com.store.app.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("user")
public class UserController 
{
	@Autowired
	private UserService userService1;
	
	@PostMapping("/login")
	public User loginAuthenticate(@RequestParam String username,@RequestParam String password)
	{
		return userService1.loginUser(username, password);
	
	}

}
