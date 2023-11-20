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
public class ProductADOImpl implements ProductDAO {
	
	@Autowired
	private DataSource dataSource;
 
	@Override
	public void createProduct(Product product) {
		String createQry= "INSERT INTO PRODUCTS(PROID,PRONAME,PROAMOUNT,COMPANYID) values(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,product.getProId(),product.getProName(),product.getProAmount(),product.getCompId());
		
	}
	
	@Override
	public long count() {
		String countQry = "SELECT COUNT(PROID) FROM PRODUCTS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}
	@Override
	public void deleteProducts(int id) {

		String deleteQry = "DELETE  FROM PRODUCTS WHERE PROID =?";
		new JdbcTemplate(dataSource).update(deleteQry, id);

	}
	@Override
	public void updateProducts(Product products,int id) {
		String updateQry = "UPDATE PRODUCTS SET PRONAME=?,PROAMOUNT=? WHERE PROID=?";
		new JdbcTemplate(dataSource).update(updateQry,products.getProName(),products.getProAmount(),id );

	}
	
	
	
	@Override
	public List<Product> getAllProducts()  {
		String selectAllQry = "SELECT PROID,PRONAME,PROAMOUNT,COMPANYID FROM PRODUCTS";
		return new JdbcTemplate(dataSource).query(selectAllQry, new ProductRowMapper());
		
	}

	@Override
	public List<Product>getProduct(int id) {

		String selectQry = "SELECT PROID,PRONAME,PROAMOUNT,COMPANYID FROM PRODUCTS WHERE PROID = ?";
		return (List<Product>) new JdbcTemplate(dataSource).query(selectQry, new  ProductRowMapper(),id);
	}
	public class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product e = new Product();
			e.setProId(rs.getInt(1));
			e.setProName(rs.getString(2));
			e.setProAmount(rs.getDouble(3));
			e.setCompId(rs.getInt(4));
			return e;
		}
	}
	

}
