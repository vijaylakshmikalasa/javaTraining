package com.valtech.training.emp;

import java.util.ArrayList;

public class Department {

	private int deptid;
	private String deptname;
	private String location;
	private String emplist;
	private String dempid;

	public Department(String deptname, String location, String emplist, String dempid) {
		super();
		this.deptname = deptname;
		this.location = location;
		this.emplist = emplist;
		this.dempid = dempid;
	}

	public Department(int deptid, String deptname, String location, String emplist, String dempid) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.location = location;
		this.emplist = emplist;
		this.dempid = dempid;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

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

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname + ", location=" + location + ", emplist="
				+ emplist + ", dempid=" + dempid + "]";
	}

}
