package com.valtech.training.assignmentspringboot.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.assignmentspringboot.components.OrderItmesDAOImpl.OrderItemsRowMapper;


@Component
public class AddressDAOImpl implements AddressDAO {
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void createAddress(Address addr)  {

		String createQry = "INSERT INTO ADDRESS (ID,CITY,STREET,ZIPCODE) VALUES(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,addr.getId(),addr.getCity(),addr.getStreet(),addr.getZipCode() );
		
	}
	@Override
	public long count() {
		String countQry = "SELECT COUNT(ID) FROM ADDRESS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}
	
	@Override
	public void deleteAddress(int id) {

		String deleteQry = "DELETE  FROM ADDRESS WHERE ID =?";
		new JdbcTemplate(dataSource).update(deleteQry, id);

	}
	@Override
	public void updateAddress(Address addr,int id) {
		String updateQry = "UPDATE ADDRESS SET CITY=?,STREET=?,ZIPCODE=? WHERE ID=?";
		new JdbcTemplate(dataSource).update(updateQry,addr.getCity(),addr.getStreet(),addr.getZipCode(),id );

	}
	
	
	
	@Override
	public List<Address> getAllAddress()  {
		String selectAllQry = "SELECT ID,STREET,CITY,ZIPCODE FROM ADDRESS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new AddressRowMapper());
		
	}

	@Override
	public List<Address>getAddress (int id) {

		String selectQry = "SELECT ID,STREET,CITY,ZIPCODE FROM ADDRESS WHERE ID = ?";
		return (List<Address>) new JdbcTemplate(dataSource).query(selectQry, new  AddressRowMapper(),id);
	}
	public class AddressRowMapper implements RowMapper<Address> {

		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address e = new Address();
			e.setId(rs.getInt(1));
			e.setCity(rs.getString(2));
			e.setStreet(rs.getString(3));
			e.setZipCode(rs.getInt(4));
			return e;
		}
	}
	@Override
	public void updateAddress(Address addr) {
		// TODO Auto-generated method stub
		
	}
	
}

