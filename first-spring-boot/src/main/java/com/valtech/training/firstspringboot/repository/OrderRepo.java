package com.valtech.training.firstspringboot.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.firstspringboot.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
	
	@Query(value="SELECT o FROM Order o where o.itemcount=?1")
	List<Order> findAllByItemcount(int itemcount);
	
	List<Order> findAllByItemcountGreaterThan(int itemcount);
	
	List<Order> findAllByItemAndItemcount(String item, int itemcount);

	int countByItem(String item);
}
