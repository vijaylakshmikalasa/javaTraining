package departmentDisplay;

public class DepartmentD {
	private int deptId;
	private String deptName;
	private String deptLoc;
	private int empList;
	
	public DepartmentD() {}

	public DepartmentD(int deptId, String deptName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public DepartmentD(int deptId, String deptName, String deptLoc, int empList) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "DepartmentD [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + ", empList="
				+ empList + "]";
	}

	//Constructor without deptId
	public DepartmentD(String deptName, String deptLoc, int empList) {
		super();
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.empList = empList;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public int getEmpList() {
		return empList;
	}

	public void setEmpList(int empList) {
		this.empList = empList;
	}
	
	
	
	
}
