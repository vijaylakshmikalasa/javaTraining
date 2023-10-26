package departmentDisplay;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	public void getListOfEmployeeinEachDepartment() throws SQLException;
	
	List<EmployeeD> getEmployeeByDeptLocation(String name) throws SQLException;
	
	List<EmployeeD> getEmployeeByDeptName(String name) throws SQLException;
	
	List<EmployeeD> getEmployeeAgeBetween(int min,int max) throws SQLException;
	
	List<EmployeeD> getEmployeeBySeniority(int limitVal) throws SQLException;
	
	List<EmployeeD> getEmployeeSalaryGreater(int amount) throws SQLException;
	
	List<EmployeeD> getEmployeeSalaryLesser(int amount) throws SQLException;
	
	public long countEmployee() throws SQLException;

	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(EmployeeD emp) throws SQLException;

	void createEmployee(EmployeeD emp) throws SQLException;

	List<EmployeeD> getAllEmployees() throws SQLException;

	EmployeeD getEmployee(int id) throws SQLException;

	List<EmployeeD> getEmployeeByDeptId(int deptId) throws SQLException;

}