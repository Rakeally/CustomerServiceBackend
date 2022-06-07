package com.CallCenter.master.Entities;


import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class AppUser {
	
	@Id
    @GeneratedValue
    private Long id;
    private String password;
    private String username;
    private String email;
    private Long Tel;
    private boolean active;
    private String token;
    
    @JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;
	

    @ManyToOne(fetch = FetchType.EAGER)
    private AppRole role;
    
    @JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employeeId")
	private Employee employee;
	

    public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppUser(Long id, String password, String username, String email, Long tel, boolean active, String token,
			Customer customer, AppRole role, Employee employee) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.email = email;
		Tel = tel;
		this.active = active;
		this.token = token;
		this.customer = customer;
		this.role = role;
		this.employee = employee;
	}




	public AppRole getRole() {
		return role;
	}

	public void setRole(AppRole role) {
		this.role = role;
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
	
	public Long getTel() {
		return Tel;
	}

	public void setTel(Long tel) {
		this.Tel = tel;
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



	


}