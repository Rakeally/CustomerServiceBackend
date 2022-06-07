package com.CallCenter.master.Objects;

public class ResetPasswordRequest {

	public String token;
	public String password;
	public ResetPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResetPasswordRequest(String token, String password) {
		super();
		this.token = token;
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
