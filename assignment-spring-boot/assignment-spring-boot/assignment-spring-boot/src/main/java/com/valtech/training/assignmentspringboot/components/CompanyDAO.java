package com.valtech.training.assignmentspringboot.components;

import java.util.List;

public interface CompanyDAO {

	void createCompany(Company company);

	long count();

	

	

	List<Company> getAllCompany();

	void updateCompany(Company company, int id);

	void deleteCompany(int id);

	List<Company> getCompany(int id);

	

}