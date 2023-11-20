package com.valtech.training.assignmentspringboot.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.assignmentspringboot.components.AddressDAOImpl.AddressRowMapper;
@Component
public class OrderItmesDAOImpl implements OrderItemsDAO {
	@Autowired
	private DataSource dataSource;
	
	
	
	@Override
	public void createOrderItems(OrderItems orderItems) {

		String createQry = "INSERT INTO ORDERITEMS (PROQUANTITY,ORDERID,PROID) VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,orderItems.getProQuantity(),orderItems.getOrderId(),orderItems.getProId());
		
	}
	
	
	@Override
	public long count() {
		String countQry = "SELECT COUNT(PROID) FROM ORDERITEMS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}
	
	@Override
	public void deleteOrderItems(int id) {

		String deleteQry = "DELETE  FROM ORDERITEMS WHERE PROID =?";
		new JdbcTemplate(dataSource).update(deleteQry, id);

	}
	@Override
	public void updateOrderItems(OrderItems orderItems,int id) {
		String updateQry = "UPDATE ORDERITEMS SET PROQUANTITY=? WHERE PROID=?";
		new JdbcTemplate(dataSource).update(updateQry,orderItems.getProQuantity(),id );

	}
	
	
	
	@Override
	public List<OrderItems> getAllOrderItems()  {
		String selectAllQry = "SELECT PROQUANTITY,ORDERID,PROID FROM ORDERITEMS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new OrderItemsRowMapper());
		
	}

	@Override
	public List<OrderItems> getOrderItems(int id) {

		String selectQry = "SELECT * FROM ORDERITEMS WHERE ORDERID = ?";
		return (List<OrderItems>) new JdbcTemplate(dataSource).query(selectQry, new  OrderItemsRowMapper(),id);
	}
	public class OrderItemsRowMapper implements RowMapper<OrderItems> {

		@Override
		public OrderItems mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderItems e = new OrderItems();
			e.setProQuantity(rs.getInt(1));
			e.setOrderId(rs.getInt(2));
			e.setProId(rs.getInt(3));
			return e;
		}
	}

}
