package com.CallCenter.master.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

	@Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private Long Tel;
    
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appUserId")
	private AppUser appUser;

	@JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Claims> claims;
	
	@JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<ClaimResult> claimResults;
	
	
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long id, String name, String email, Long tel) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Tel = tel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTel() {
		return Tel;
	}
	public void setTel(Long tel) {
		Tel = tel;
	}
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	public List<Claims> getClaims() {
		return claims;
	}
	public void setClaims(List<Claims> claims) {
		this.claims = claims;
	}
    
	
    
}
