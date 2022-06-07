package com.CallCenter.master.Objects;

public class RegisterEmployee {

	//customer info
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private Long Tel;
	public RegisterEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterEmployee(String firstName, String lastName, String email, String password, String confirmPassword,
			Long tel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		Tel = tel;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Long getTel() {
		return Tel;
	}
	public void setTel(Long tel) {
		Tel = tel;
	}
    
    
}
