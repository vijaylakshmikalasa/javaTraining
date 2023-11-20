package com.valtech.training.emp;

 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 

public class EmployeeList {
	public static void main(String[] args) {
		List<Employee> employees =new ArrayList<>();

		employees.add(new Employee("Vidya",8,4,42,360000));
		employees.add(new Employee("Sheethal",6,3,40,290000));
		employees.add(new Employee("Vishnu",4,2,38,420000));
		employees.add(new Employee("Srusti",2,1,26,220000));
		employees.add(new Employee("Priya",15,10,68,55000));
		employees.add(new Employee("Chandana",10,8,49,40000));
		employees.add(new Employee("Yamini",12,9,55,50000));
		employees.add(new Employee("Sahana",1,1,22,18000));

		Collections.sort(employees);

		for(Employee employee:employees) {
			System.out.println(employee);
		}
	}
}