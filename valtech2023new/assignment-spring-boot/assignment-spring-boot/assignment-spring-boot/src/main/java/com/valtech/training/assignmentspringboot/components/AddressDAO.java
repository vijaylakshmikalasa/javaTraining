package com.valtech.training.assignmentspringboot.components;

import java.util.List;

import org.springframework.stereotype.Component;


public interface AddressDAO {

	void createAddress(Address addr);
	
	public  long count();

	void deleteAddress(int id);


	List<Address> getAllAddress();

	

	void updateAddress(Address addr);

	void updateAddress(Address addr, int id);

	List<Address> getAddress(int id);

	

}