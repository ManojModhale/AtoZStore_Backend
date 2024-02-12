package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.app.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> 
{
	
	@Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
	User loginuser(@Param("username") String username, @Param("password") String password);

	@Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email")
	User forgetpassword(@Param("username") String username, @Param("email") String email);


	/*
	@Query("from User u where u.username= :username AND u.password = :password")
	public User findByUsernameAndPassword(@Param(value = "username") String username,@Param(value = "password") String password);
	*/
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsernameAndEmail(String username,String email);
	
	public User findByUsername(String username);
	
}
