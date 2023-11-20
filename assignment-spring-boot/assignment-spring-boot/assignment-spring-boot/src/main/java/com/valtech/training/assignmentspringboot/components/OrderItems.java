package com.valtech.training.assignmentspringboot.components;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
public class OrderItems {

	private int orderId;
	private int  proId;
	private int proQuantity;
	

	public OrderItems() {
	}


	public OrderItems(int proQuantity) {
		this.proQuantity = proQuantity;
	}


	@Override
	public String toString() {
		return "OrderItems [orderId=" + orderId + ", proId=" + proId + ", proQuantity=" + proQuantity + "]";
	}


	public OrderItems(int orderId, int proId, int proQuantity) {
		this.orderId = orderId;
		this.proId = proId;
		this.proQuantity = proQuantity;
	}


	public OrderItems(int proId, int proQuantity) {
		this.proId = proId;
		this.proQuantity = proQuantity;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getProId() {
		return proId;
	}


	public void setProId(int proId) {
		this.proId = proId;
	}


	public int getProQuantity() {
		return proQuantity;
	}


	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}

	
}	
