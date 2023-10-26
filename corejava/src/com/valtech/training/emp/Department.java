package com.valtech.training.emp;

import java.util.ArrayList;

public class Department {
		
		private int deptid;
		private  String deptname;
		private  String location;
		private  String emplist;
		private  String dempid;
		
		
		
		public String getEmplist() {
			return emplist;
		}
		public void setEmplist(String emplist) {
			this.emplist = emplist;
		}
		public String getDempid() {
			return dempid;
		}
		public void setDempid(String dempid) {
			this.dempid = dempid;
		}
		public Department(int did, String dname, String location, String emplist, String dempid) {
			super();
			Did = did;
			Dname = dname;
			this.location = location;
			this.emplist = emplist;
			this.dempid = dempid;
		}
		public Department(int did, String dname, String location) {
			super();
			Did = did;
			Dname = dname;
			this.location = location;
		}
		public Department() {
			super();
		}
		public int getDid() {
			return Did;
		}
		public void setDid(int did) {
			Did = did;
		}
		public String getDname() {
			return Dname;
		}
		public void setDname(String dname) {
			Dname = dname;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
//		public static void main(String[] args) {
//			List<Department> d =new ArrayList<>();
//			d.add(new Department(10,"Bend","bengaluru"));
//			d.add(new Department(12,"Fend","KA"));
//			 System.out.println("-----------------------");
//	         for (Department d1:d) {
//	                System.out.println("Did "+d1.getDid() +" Experience "+ d1.getDname() +" Name "+d1.getLocation());
//	         }   
//		}
	}


