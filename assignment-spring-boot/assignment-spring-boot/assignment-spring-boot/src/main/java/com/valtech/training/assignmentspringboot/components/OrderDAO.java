package com.valtech.training.assignmentspringboot.components;

import java.util.List;

public interface OrderDAO {

	void createOrder(Order order);

	long count();

	void updateOrder(Order orders, int id);

	List<Order> getAllOrders();

	

	void deleteOrders(int id);

	List<Order> getOrder(int id);

}