package com.valtech.training.firstspringboot.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee{
       
       private int id;
       private String name;
       private int age;
       private int experience;
       private int senior;
       private double salary;
       
       
    public Employee() {
		super();
	}
    @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", experience=" + experience + ", senior="
				+ senior + ", salary=" + salary + "]";
	}
	public Employee(int s,int e,String n,int a,double amt) {
        this.senior=s;
        this.experience=e;
        this.name=n;
        this.age=a;
        this.salary=amt;
  }
    

	public Employee(String name, int age, int experience, int senior, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.senior = senior;
		this.salary = salary;
	}
	public int getSenior() {
		return senior;
	}

	public void setSenior(int senior) {
		this.senior = senior;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Comparator<Employee> getEmpCompare() {
		return empCompare;
	}

	public static void setEmpCompare(Comparator<Employee> empCompare) {
		Employee.empCompare = empCompare;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
       
    public int getSeniority() {
        return senior;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
       
    	public static Comparator<Employee> empCompare = new Comparator<Employee> (){
            public int compare(Employee emp1, Employee emp2) {
                    //Sorting highest number as more senior member
            int sComp = Integer.compare(emp1.getSeniority(), emp2.getSeniority());
            if (sComp == 1) {
                return -1;
            }
            //If the seniority is same then  experience in the same way as seniority
            int eComp = Integer.compare(emp1.getExperience(), emp2.getExperience());
            if (eComp == 1) {
                return -1;
            }
           return emp1.getName().compareTo(emp2.getName());
             }
       };
              
       public static void main(String[] args) {
             //Can be added this way also
             ArrayList<Employee> emps=new ArrayList<Employee>();
             emps.add(new Employee(1,4,"Gagan",22,40000));
             emps.add(new Employee(3,7,"Ani",25,70000));
             emps.add(new Employee(6,10,"Kruthik",28,165000));
             emps.add(new Employee(8,12,"Ajay",36,265000));
            
             System.out.println("-----------------------");
             for (Employee emp:emps) {
                    System.out.println("Seniority "+emp.getSeniority() +" Experience "+ emp.getExperience() +" Name "+emp.getName());
             }
             System.out.println("-----------------------");
             Collections.sort(emps, empCompare); 
             System.out.println(emps.size());
             //generator function
             for (Employee emp:emps) {
                    System.out.println("Seniority "+emp.getSeniority() +" Experience "+ emp.getExperience() +" Name "+emp.getName());
             }
             System.out.println("-----------------------");
//             EmployeeGenerator e1 = new EmployeeGenerator();
//             EmployeeGenerator e2 = new EmployeeGenerator();
//             EmployeeGenerator e3 = new EmployeeGenerator();
//             EmployeeGenerator e4 = new EmployeeGenerator();
//             System.out.println("Seniority "+e1.getSeniority()+" Age "+e1.getAge()+" Experience "+e1.getExperience()+" Name "+e1.getName()+" Salary "+e1.getSalary());
             //employeeSet(new ArrayList<>());
       }
}


