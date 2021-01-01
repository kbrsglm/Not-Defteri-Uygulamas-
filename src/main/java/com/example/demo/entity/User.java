package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ParamDef;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
public class User {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String lastName;
	
	private String  emailId;
	
	private String password;
	
	private boolean aktiflikDurumu;
	public User() {
		super();
		
	}
	public User(String firstName, String lastName, String emailId, String password,boolean aktiflikDurumu) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.aktiflikDurumu=aktiflikDurumu;
		
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
	public boolean isAktiflikDurumu() {
		return aktiflikDurumu;
	}
	public void setAktiflikDurumu(boolean aktiflikDurumu) {
		this.aktiflikDurumu = aktiflikDurumu;
	}
	
}
