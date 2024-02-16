package com.store.app.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class User 
{
	@Id
	private String username;
	private String password;

	private String firstname;
	private String lastname;
	private String gender;
	private int age;


	private String email;
	private long contactno;
	
	@Embedded
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="userid")
    @OrderColumn(name="no")
    private List<CartProduct> cproducts;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String firstname, String lastname,String gender,int age, String email, long contactno) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender=gender;
		this.age=age;
		this.email = email;
		this.contactno = contactno;
	}
	public User(String username, String password, String firstname, String lastname, String gender, int age,
			String email, long contactno, Address address) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.contactno = contactno;
		this.address = address;
	}
	
	public List<CartProduct> getCproducts() {
		return cproducts;
	}
	public void setCproducts(List<CartProduct> cproducts) {
		this.cproducts = cproducts;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}	
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public long getContactno() {
		return contactno;
	}

	
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", gender=" + gender + ", age=" + age + ", email=" + email + ", contactno=" + contactno
				+ ", address=" + address + "]";
	}
	
	}
	
	
	
	