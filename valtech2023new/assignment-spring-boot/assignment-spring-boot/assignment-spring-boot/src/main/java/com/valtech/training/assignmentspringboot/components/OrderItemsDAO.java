package com.valtech.training.assignmentspringboot.components;

import java.util.List;

public interface OrderItemsDAO {

	void createOrderItems(OrderItems orderItems);

	long count();

	

	List<OrderItems> getAllOrderItems();

	void updateOrderItems(OrderItems orderItems, int id);

	void deleteOrderItems(int id);

	List<OrderItems> getOrderItems(int id);

	

}