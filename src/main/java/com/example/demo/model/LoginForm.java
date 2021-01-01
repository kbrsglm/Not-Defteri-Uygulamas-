package com.example.demo.model;

public class LoginForm {
	
  private  String emailId;
  private  String  password;
  private boolean aktiflikDurumu;
public boolean isAktiflikDurumu() {
	return aktiflikDurumu;
}
public void setAktiflikDurumu(boolean aktiflikDurumu) {
	this.aktiflikDurumu = aktiflikDurumu;
}
public LoginForm() {
	super();
	
}
public LoginForm(String emailId, String password,boolean aktiflikDurumu) {
	super();
	this.emailId = emailId;
	this.password = password;
	this.aktiflikDurumu=aktiflikDurumu;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  
}
