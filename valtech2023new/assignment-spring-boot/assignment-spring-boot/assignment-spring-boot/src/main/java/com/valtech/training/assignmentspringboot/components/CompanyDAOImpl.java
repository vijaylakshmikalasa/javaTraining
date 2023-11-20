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
import com.valtech.training.assignmentspringboot.components.OrderItmesDAOImpl.OrderItemsRowMapper;
@Component
public class CompanyDAOImpl implements CompanyDAO {

	@Autowired
	private DataSource dataSource;
	
	public class CompanyRowMapper implements RowMapper<Company> {

		@Override
		public  Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			Company e = new Company();
			e.setCompId(rs.getInt(1));
			e.setCompName(rs.getString(2));
			e.setAddrId(rs.getInt(3));
			return e;
		}
	}
	
	
	@Override
	public void createCompany(Company company) {

		String createQry = "INSERT INTO COMPANY (COMPANYID,COMPANYNAME,ADDRID) VALUES(?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,company.getCompId(),company.getCompName(),company.getAddrId() );
		
	}
	@Override
	public long count() {
		String countQry = "SELECT COUNT(COMPANYID) FROM COMPANY";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}
	@Override
	public void deleteCompany(int id) {

		String deleteQry = "DELETE  FROM COMPANY WHERE COMPANYID =?";
		new JdbcTemplate(dataSource).update(deleteQry, id);

	}
	@Override
	public void updateCompany(Company company,int id) {
		String updateQry = "UPDATE COMPANY SET COMPANYNAME=? WHERE COMPANYID=?";
		new JdbcTemplate(dataSource).update(updateQry,company.getCompName(),id );

	}
	
	
	
	@Override
	public List<Company> getAllCompany()  {
		String selectAllQry = "SELECT COMPANYID,COMPANYNAME,ADDRID FROM COMPANY";
		return new JdbcTemplate(dataSource).query(selectAllQry, new CompanyRowMapper());
		
	}

	@Override
	public List<Company> getCompany(int id) {

		String selectQry = "SELECT COMPANYID,COMPANYNAME,ADDRID FROM COMPANY WHERE COMPANYID = ?";
		return (List<Company>) new JdbcTemplate(dataSource).query(selectQry, new  CompanyRowMapper(),id);
	}
	
	
}
