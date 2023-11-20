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
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private DataSource dataSource;
	
	
	
	@Override
	public void createCustomer(Customer customer) {

		String createQry = "INSERT INTO Customer (CUSID,CUSNAME,PHONE,ADDRID) VALUES(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,customer.getCusId(),customer.getName(),customer.getPhone(),customer.getAddrId());
		
	}
	
	@Override
	public long count() {
		String countQry = "SELECT COUNT(CUSID) FROM CUSTOMER";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}
	@Override
	public void deleteCustomer(int id) {

		String deleteQry = "DELETE  FROM CUSTOMER WHERE CUSID =?";
		new JdbcTemplate(dataSource).update(deleteQry, id);

	}
	@Override
	public void updateCustomer(Customer customer,int id) {
		String updateQry = "UPDATE CUSTOMER SET CUSNAME=?,PHONE=? WHERE CUSID=?";
		new JdbcTemplate(dataSource).update(updateQry,customer.getName(),customer.getPhone(),id );

	}
	
	
	
	@Override
	public List<Customer> getAllCustomer()  {
		String selectAllQry = "SELECT CUSID,CUSNAME,PHONE,ADDRID FROM CUSTOMER";
		return new JdbcTemplate(dataSource).query(selectAllQry, new CustomerRowMapper());
		
	}

	@Override
	public List<Customer>getCustomers (int id) {

		String selectQry = "SELECT ID,STREET,CITY,ZIPCODE FROM ADDRESS WHERE ID = ?";
		return (List<Customer>) new JdbcTemplate(dataSource).query(selectQry, new CustomerRowMapper(),id);
	}
	public class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer e = new Customer();
			e.setCusId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPhone(rs.getInt(3));
			e.setAddrId(rs.getInt(4));
			return e;
		}
	}
	
}
