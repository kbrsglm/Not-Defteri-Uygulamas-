package com.example.demo.model;

public class UserUpdateForm {
	private String userName;
	private String islem;
	private Long id;

	public UserUpdateForm() {
		super();
	}
	
	public UserUpdateForm(String userName,String islem,Long id) {
		super();
		this.userName=userName;
		this.islem=islem;
		this.id=id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIslem() {
		return islem;
	}

	public void setIslem(String islem) {
		this.islem = islem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
