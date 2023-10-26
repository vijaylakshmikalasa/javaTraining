package departmentDisplay;
import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

	int firstDept() throws SQLException;

	int lastDept() throws SQLException;

	int nextDept(int deptId) throws SQLException;

	int previousDept(int deptId) throws SQLException;
	
	void createDepartment(DepartmentD dept) throws SQLException;

	List<DepartmentD> getDepartments() throws SQLException;

	void updateDepartment(DepartmentD dept) throws SQLException;

	void deleteDepartment(int id) throws SQLException;

	DepartmentD getDepartment(int id) throws SQLException;

}