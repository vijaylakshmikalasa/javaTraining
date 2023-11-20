package com.valtech.training.assignmentspringboot.components;

import java.util.List;

public interface CustomerDAO {

	void createCustomer(Customer customer);

	long count();


	List<Customer> getAllCustomer();

	void updateCustomer(Customer customer, int id);

	void deleteCustomer(int id);

	List<Customer> getCustomers(int id);

}