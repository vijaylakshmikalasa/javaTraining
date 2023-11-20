package com.valtech.training.assignmentspringboot.components;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.stereotype.Component;

@Component
public class Order {
	
	private int orderId;
	@Basic() @Temporal(TemporalType.DATE)
	private Date orderDate;
	private int  cusId;
	
	

	public Order() {
	}

	

	public Order(Date orderDate) {
		this.orderDate = orderDate;
	}



	public Order(int cusId, Date orderDate) {
		this.cusId = cusId;
		this.orderDate = orderDate;
	}



	public Order(int orderId, int cusId, Date orderDate) {
		this.orderId = orderId;
		this.cusId = cusId;
		this.orderDate = orderDate;
	}



	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getCusId() {
		return cusId;
	}


	public void setCusId(int cusId) {
		this.cusId = cusId;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}
