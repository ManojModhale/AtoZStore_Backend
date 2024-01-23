package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> 
{
	public User findByUsernameAndPassword(String username, String password);
	
	/*
	@Query("from User u where u.username= :username AND u.password = :password")
	public User findByUsernameAndPassword(@Param(value = "username") String username,@Param(value = "password") String password);
	*/
}
