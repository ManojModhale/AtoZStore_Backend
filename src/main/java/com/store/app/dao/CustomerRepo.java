package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.app.bean.Customer;
import com.store.app.bean.User;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>{
	@Query("SELECT u FROM Customer u WHERE u.username = :username AND u.password = :password")
	Customer loginuser(@Param("username") String username, @Param("password") String password);

	public Customer findByUsernameAndPassword(String username, String password);

	Customer findByUsername(String username);

	Customer findByUsernameAndEmail(String username, String email);
}
