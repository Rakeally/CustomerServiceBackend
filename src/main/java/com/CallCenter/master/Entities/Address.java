package com.CallCenter.master.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.EAGER)
	private Customer customer;
    
    
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Long id, String street, String postalCode, String city, String state, String country) {
		super();
		this.id = id;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
    
    
    
}
