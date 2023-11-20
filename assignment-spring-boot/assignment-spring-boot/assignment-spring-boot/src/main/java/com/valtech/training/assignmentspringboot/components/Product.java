package com.valtech.training.assignmentspringboot.components;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	private int proId;
	private String proName;
	private double proAmount;
	private int compId ;

	public Product() {
	}

	
	public Product(String proName, double proAmount) {
		this.proName = proName;
		this.proAmount = proAmount;
	}


	public Product(int proId, String proName, double proAmount, int compId) {
		this.proId = proId;
		this.proName = proName;
		this.proAmount = proAmount;
		this.compId = compId;
	}

	public Product(String proName, double proAmount, int compId) {
		this.proName = proName;
		this.proAmount = proAmount;
		this.compId = compId;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public double getProAmount() {
		return proAmount;
	}

	public void setProAmount(double proAmount) {
		this.proAmount = proAmount;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}
	


}
