package com.CallCenter.master.Entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class ClaimStatus {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;


	@JsonIgnore
	@OneToMany(mappedBy = "claimStatus")
	private List<Claims> claims;
		
	public ClaimStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClaimStatus(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public List<Claims> getClaims() {
		return claims;
	}

	public void setClaims(List<Claims> claims) {
		this.claims = claims;
	}

	
}
