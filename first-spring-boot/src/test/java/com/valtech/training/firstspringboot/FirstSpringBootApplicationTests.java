package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.EmpDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.services.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {
	@Autowired
	private HelloWorld helloWorld;
	
	@Autowired
	private EmpDAO empDAO;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Test
	void testSI() {
		simpleInterest.ComputeInterest(20000, 3, 3);
	}
	
	
	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}

	@Test
	void testEmployee() {
		assertEquals(4, empDAO.count());
	}

	@Test
	void testOrders() {
//		Order o = orderService.createOrder(new Order("Hp", 21, "for the company", LocalDate.of(2023, 11, 8)));
//		assertEquals(4, o.getId());
//		assertTrue(orderService.getAllOrder().size() > 0);
	}

	

}