package com.example.demo.model;

public class AdminloginForm {
	
	private String email;
	private String parola;
	public AdminloginForm() {
		super();
		
	}
	public AdminloginForm(String email, String parola) {
		super();
		this.email = email;
		this.parola = parola;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
}
