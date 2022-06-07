package com.CallCenter.master.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Claims {

	@Id
    @GeneratedValue
    private Long id;
	
	@Lob 
	@Column(length=1000000)
    private String description;
	@Column(updatable = false)
    @CreationTimestamp
    private Date date;
	private Long amount;
	private Date dateLostService;
	private String gasMeterReading;
	private String uniqueId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private ClaimTypes claimTypes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private ClaimStatus claimStatus;
    
    @JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "claims", fetch = FetchType.EAGER)
	private ClaimResult claimResult;
	

    
	
	public Claims() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Claims(Long id, String description, Date date, Long amount) {
		super();
		this.id = id;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public ClaimTypes getClaimTypes() {
		return claimTypes;
	}
	public void setClaimTypes(ClaimTypes claimTypes) {
		this.claimTypes = claimTypes;
	}
	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(ClaimStatus claimStatus) {
		this.claimStatus = claimStatus;
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
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public ClaimResult getClaimResult() {
		return claimResult;
	}
	public void setClaimResult(ClaimResult claimResult) {
		this.claimResult = claimResult;
	}
	

	
}
