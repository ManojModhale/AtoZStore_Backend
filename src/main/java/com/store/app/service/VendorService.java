package com.store.app.service;

import com.store.app.bean.Customer;
import com.store.app.bean.User;
import com.store.app.bean.Vendor;

public interface VendorService {
   public Vendor vendorLogin(String username,String password);

public Vendor addVendor(Vendor vendor);

public Vendor getUserByUsername(String username);

public int update(Vendor vendor);



}
