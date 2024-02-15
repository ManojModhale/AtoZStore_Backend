package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.bean.User;
import com.store.app.bean.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer >{

		public Vendor findByUsernameAndPassword(String username, String password);

}
