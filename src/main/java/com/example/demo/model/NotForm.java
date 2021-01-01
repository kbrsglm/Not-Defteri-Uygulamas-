package com.example.demo.model;

public class NotForm {

	private String baslik;
	private String not;
	public NotForm() {
		super();
		
	}
	public NotForm(String baslik, String not) {
		super();
		this.baslik = baslik;
		this.not = not;
	}
	public String getBaslik() {
		return baslik;
	}
	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}
	public String getNot() {
		return not;
	}
	public void setNot(String not) {
		this.not = not;
	}
	
}
