package com.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.Vendor;
import com.store.app.dao.VendorRepository;
@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    VendorRepository vendorRepository;
	@Override
	public Vendor vendorLogin(String username, String password) {
		// TODO Auto-generated method stub
		return vendorRepository.findByUsernameAndPassword(username,password);
	}

}
