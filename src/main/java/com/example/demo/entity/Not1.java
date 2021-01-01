package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Not1{
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO) 
	    private Long id;
	    
	    public String not1;
	    public String baslik;
		public String getNot1() {
			return not1;
		}
		public void setNot1(String not1) {
			this.not1 = not1;
		}
		public String getBaslik() {
			return baslik;
		}
		public void setBaslik(String baslik) {
			this.baslik = baslik;
		}
		
		public Not1( String not1, String baslik) {
			super();
			this.not1 = not1;
			this.baslik = baslik;
		}
		public Not1() {
			super();
		}
	    
	
}
