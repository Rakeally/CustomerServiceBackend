package com.CallCenter.master.Entities;

import java.util.Date;

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

@Entity
public class ClaimResult {

	@Id
    @GeneratedValue
    private Long id;
	@Lob 
	@Column(length=1000000)
    private String description;
	@Column(updatable = false)
    @CreationTimestamp
    private Date date;
	private String claimDecision;
	
	   @ManyToOne(fetch = FetchType.EAGER)
	    private Employee employee;
	   
		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "claimsId")
		private Claims claims;

		public ClaimResult() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ClaimResult(Long id, String description, Date date, String claimDecision, Employee employee,
				Claims claims) {
			super();
			this.id = id;
			this.description = description;
			this.date = date;
			this.claimDecision = claimDecision;
			this.employee = employee;
			this.claims = claims;
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

		public String getClaimDecision() {
			return claimDecision;
		}

		public void setClaimDecision(String claimDecision) {
			this.claimDecision = claimDecision;
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public Claims getClaims() {
			return claims;
		}

		public void setClaims(Claims claims) {
			this.claims = claims;
		}
	   
		
	
}
