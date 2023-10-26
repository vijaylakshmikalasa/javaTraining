package com.valtech.training.emp;

 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 

public class EmployeeList {
	public static void main(String[] args) {
		List<Employee> employees =new ArrayList<>();

		employees.add(new Employee(4,8,"Vidya",42,360000));
		employees.add(new Employee(3,6,"Sheethal",40,290000));
		employees.add(new Employee(2,4,"Vishnu",38,420000));
		employees.add(new Employee(1,2,"Srusti",26,220000));
		employees.add(new Employee(10,15,"Priya",68,55000));
		employees.add(new Employee(8,10,"Chandana",49,40000));
		employees.add(new Employee(9,12,"Yamini",55,50000));
		employees.add(new Employee(1,1,"Sahana",22,18000));

		Collections.sort(employees);

		for(Employee employee:employees) {
			System.out.println(employee);
		}
	}
}