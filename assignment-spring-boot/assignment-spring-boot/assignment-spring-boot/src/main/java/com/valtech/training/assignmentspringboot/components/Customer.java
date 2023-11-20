package com.valtech.training.assignmentspringboot.components;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	private int cusId;
	private String name;
	private int phone;
	private int addrId;
	
	public Customer() {
	}
	
	

	public Customer(String name, int phone) {
		this.name = name;
		this.phone = phone;
	}



	public Customer(int cusId, String name, int phone, int addrId) {
		this.cusId = cusId;
		this.name = name;
		this.phone = phone;
		this.addrId = addrId;
	}
	

	public Customer(String name, int phone, int addrId) {
		this.name = name;
		this.phone = phone;
		this.addrId = addrId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	
	
}
