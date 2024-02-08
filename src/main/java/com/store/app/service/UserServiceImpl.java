package com.store.app.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.User;
import com.store.app.dao.UserRepository;
@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	UserRepository repository;
	
	public User addregister(User u) {
		repository.save(u);
		System.out.println("in register");
		return repository.save(u);
	}
	
	public User userlogin(User u) {
		return repository.loginuser(u.getUsername(),u.getPassword());
	}
	
	public void delete(String username) {
		repository.deleteById(username);
		
		
		}
		
		public int update(User u) {
			Optional<User>op=repository.findById(u.getUsername());
			
			if(op.isPresent()) {
				User u1=op.get();
				u1.setUsername(u.getUsername());
				u1.setPassword(u.getPassword());
				u1.setUsername(u.getUsername());

				u1.setFirstname(u.getFirstname());
				u1.setLastname(u.getLastname());
				u1.setGender(u.getGender());
				u1.setAge(u.getAge());
				u1.setEmail(u.getEmail());
				u1.setContactno(u.getContactno());
				
				
				return 1;
			}
			return 0;
		}
		
		public List<User> getUser(){
	     return repository.findAll();
		}

		public User loginuser(String username, String password) {
			// TODO Auto-generated method stub
			return repository.loginuser(username, password);
		}
		
		public User forgetpassword(String username,String email) {
			return repository.forgetpassword(username, email);
		}

		public User getUserByUsername(String username) {
			// TODO Auto-generated method stub
			return repository.findById(username).get();
		}


		
}
