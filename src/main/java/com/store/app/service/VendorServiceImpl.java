package com.store.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.Customer;
import com.store.app.bean.User;
import com.store.app.bean.Vendor;
import com.store.app.dao.VendorRepository;
@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    VendorRepository vendorRepository;
	@Override
	public Vendor vendorLogin(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		System.out.println(vendorRepository.findByUsernameAndPassword(username,password));
		return vendorRepository.findByUsernameAndPassword(username,password);
	}
	@Override
	public Vendor addVendor(Vendor vendor) {
		System.out.println(vendor.toString());
		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}
	@Override
	public Vendor getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return vendorRepository.findByUsername(username);
	}
	@Override
	public int update(Vendor vendor) {
		// TODO Auto-generated method stub
		Optional<Vendor>op=vendorRepository.findById(vendor.getUsername());
		
		if(op.isPresent()) {
			Vendor u1=op.get();
			
			u1.setFirstname(vendor.getFirstname());
			u1.setLastname(vendor.getLastname());
			u1.setGender(vendor.getGender());
			u1.setAge(vendor.getAge());
			u1.setEmail(vendor.getEmail());
			u1.setContactno(vendor.getContactno());
			u1.setCompanyname(vendor.getCompanyname());
			u1.setCompanytype(vendor.getCompanytype());
			u1.setAddress(vendor.getAddress());
			vendorRepository.save(u1);
			return 1;
		}
		return 0;
	}

}
