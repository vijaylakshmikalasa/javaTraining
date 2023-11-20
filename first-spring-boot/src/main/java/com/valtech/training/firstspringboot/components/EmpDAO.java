package com.valtech.training.firstspringboot.components;

import java.sql.SQLException;
import java.util.List;

public interface EmpDAO {
	
	public long count() ;
	//
	public void getListOfEmployeeinEachDepartment() throws SQLException;
	//
	List<Employee> getEmployeeByDeptName(String name) throws SQLException;
	
	List<Employee> getEmployeesSalaryGT(double amount ) throws SQLException;
	
	List<Employee> getEmployeesSalaryLT(double amount) throws SQLException;

	
	List<Employee> getEmployeeSeniority(int seniority) throws SQLException;

	List<Employee> getEmployeeAgeBetween() throws SQLException;
	
	List<Employee> getEmployeeLocation(String location) throws SQLException;
	
	void createEmployee(Employee emp) ;

	void updateEmployee(Employee emp) ;

	void deleteEmployee(int id) ;

	List<Employee> getAllEmployees() ;

	Employee getEmployee(int id);


	
}