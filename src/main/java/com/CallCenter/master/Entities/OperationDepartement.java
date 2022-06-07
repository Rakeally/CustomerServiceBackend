package com.CallCenter.master.Entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class OperationDepartement {

	@Id
	@GeneratedValue
	private Long id;
	
	//user info
    private String username;
    private String password;
    private String email;
    private String Tel;
    private boolean active;
    private String token;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private String taxId;
    
    // address info
    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    
    //claim info
    private String description;
    private Date date;
	private Long amount;
	public OperationDepartement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperationDepartement(Long id, String username, String password, String email, String tel, boolean active,
			String token, String firstName, String lastName, String accountNumber, String taxId, String street,
			String postalCode, String city, String state, String country, String description, Date date, Long amount) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		Tel = tel;
		this.active = active;
		this.token = token;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.taxId = taxId;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.description = description;
		this.date = date;
		this.amount = amount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
}
