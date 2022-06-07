package com.CallCenter.master.Objects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import com.CallCenter.master.Entities.ClaimTypes;

public class ClaimObject {

	@Lob 
	@Column(length=1000000)
    private String description;
	private Long amount;
	private Date dateLostService;
	private String gasMeterReading;
	
	//Address info
    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    
    private Long claimTypesId;
    private Long customerId;
    
	public ClaimObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaimObject(String description, Date date, Long amount, Date dateLostService, String gasMeterReading,
			String uniqueId, String street, String postalCode, String city, String state, String country) {
		super();
		this.description = description;
		this.amount = amount;
		this.dateLostService = dateLostService;
		this.gasMeterReading = gasMeterReading;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getDateLostService() {
		return dateLostService;
	}

	public void setDateLostService(Date dateLostService) {
		this.dateLostService = dateLostService;
	}

	public String getGasMeterReading() {
		return gasMeterReading;
	}

	public void setGasMeterReading(String gasMeterReading) {
		this.gasMeterReading = gasMeterReading;
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

	public Long getClaimTypesId() {
		return claimTypesId;
	}

	public void setClaimTypesId(Long claimTypesId) {
		this.claimTypesId = claimTypesId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


    
}
