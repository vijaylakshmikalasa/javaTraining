package com.valtech.training.assignmentspringboot.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.assignmentspringboot.components.AddressDAOImpl.AddressRowMapper;
@Component
public class OrderDAOImpl implements OrderDAO {
	
	

	@Autowired
	private DataSource dataSource;
	
	
	
	
	@Override
	public void createOrder(Order order) {

		String createQry = "INSERT INTO ORDERS (ORDERID,ORDERDATE,CUSID) VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,order.getOrderId(),order.getOrderDate(),order.getCusId());
		
	}
	
	
	@Override
	public long count() {
		String countQry = "SELECT COUNT(ORDERID) FROM ORDERS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}
	
	@Override
	public void deleteOrders(int id) {

		String deleteQry = "DELETE  FROM ORDERS WHERE ORDERID =?";
		new JdbcTemplate(dataSource).update(deleteQry, id);

	}
	@Override
	public void updateOrder(Order orders ,int id) {
		String updateQry = "UPDATE ORDERS SET ORDERDATE=? WHERE ORDERID=?";
		new JdbcTemplate(dataSource).update(updateQry,orders.getOrderDate(),id );

	}
	
	
	
	@Override
	public List<Order> getAllOrders()  {
		String selectAllQry = "SELECT ORDERID,ORDERDATE,CUSID FROM ORDERS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrderRowMapper());
		
	}

	@Override
	public List<Order>getOrder (int id) {

		String selectQry = "SELECT ORDERID,ORDERDATE,CUSID FROM ORDERS WHERE ORDERID = ?";
		return (List<Order>) new JdbcTemplate(dataSource).query(selectQry, new  OrderRowMapper(),id);
	}
	public class OrderRowMapper implements RowMapper<Order> {

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order e = new Order();
			e.setOrderId(rs.getInt(1));
			e.setOrderDate(rs.getDate(2));
			e.setCusId(rs.getInt(3));
			return e;
		}
	}
}
