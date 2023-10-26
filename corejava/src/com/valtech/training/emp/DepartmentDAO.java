package com.valtech.training.emp;
import java.sql.SQLException;
import java.util.List;


public interface DepartmentDAO {
	
	void deleteDepartment(int id) throws SQLException;

	void updateDepartment(Department dept) throws SQLException;

	void createDepartment(Department dept) throws SQLException;

	List<Department> getAllDepartment() throws SQLException;

	Department getDepartment(int id) throws SQLException;
	
	long count() throws SQLException;

	List<Department> getDepartment() throws SQLException;


	

}


