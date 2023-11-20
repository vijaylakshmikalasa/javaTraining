package com.valtech.training.assignmentspringboot.components;

import java.util.List;

public interface ProductDAO {

	void createProduct(Product product);

	long count();

	void deleteProducts(int id);

	void updateProducts(Product products, int id);

	

	List<Product> getAllProducts();


	List<Product> getProduct(int id);

}