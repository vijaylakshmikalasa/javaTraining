package com.valtech.training.assignmentspringboot.components;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
public class Company {
	
	
	private  int compId;
	private String compName;
	private int addrId;
	
	
	public Company() {
		
	}
	
	
	public Company(String compName) {
		this.compName = compName;
	}


	public Company(String compName, int addrId) {
		this.compName = compName;
		this.addrId = addrId;
	}

	public Company(int compId, String compName, int addrId) {
		this.compId = compId;
		this.compName = compName;
		this.addrId = addrId;
	}



	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

}
