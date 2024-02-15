package com.store.app.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name="vendors")
@PrimaryKeyJoinColumn(name="VendorId")


public class Vendor extends User{
  private String companyname;
  private String companytype;
  @Embedded
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="vendorid")
    @OrderColumn(name="no")
    private List<Products> products;
public Vendor() {
	super();
	// TODO Auto-generated constructor stub
}
public Vendor(String username, String password, String firstname, String lastname, String gender, int age, String email,
		long contactno, Address address) {
	super(username, password, firstname, lastname, gender, age, email, contactno, address);
	// TODO Auto-generated constructor stub
}
public Vendor(String username, String password, String firstname, String lastname, String gender, int age, String email,
		long contactno) {
	super(username, password, firstname, lastname, gender, age, email, contactno);
	// TODO Auto-generated constructor stub
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getCompanytype() {
	return companytype;
}
public void setCompanytype(String companytype) {
	this.companytype = companytype;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Vendor [companyname=" + companyname + ", companytype=" + companytype + ", address=" + address + "]";
} 
  
}
