package departmentDisplay;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	@Override
	public int firstDept() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MIN(DEPTID) FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
			return id;
		}
		return 0;
	}

	@Override
	public int lastDept() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(DEPTID) FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int deptId = rs.getInt(1);
			conn.close();
			return deptId;
		}
		conn.close();
		return 0;
	}

	@Override
	public int nextDept(int deptId) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MIN(DEPTID) FROM DEPARTMENT WHERE DEPTID > ?");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
			return id == 0 ? firstDept() : id;
		}
		return 0;
	}

	@Override
	public int previousDept(int deptId) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(DEPTID) FROM DEPARTMENT WHERE DEPTID < ?");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			deptId = rs.getInt(1);
			conn.close();
			return deptId == 0 ? lastDept() : deptId;
		}
		return 0;
	}
	
	//Create Operation
	@Override
	public void createDepartment(DepartmentD dept) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO DEPARTMENT (DEPTID,DEPTNAME,DEPTLOC) VALUES(?,?,?)");
		populatePreparedStatment(dept, ps);
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();
	}
	
	//Read Operation
	@Override
	public List<DepartmentD> getDepartments() throws SQLException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM DEPARTMENT");
		ResultSet rs=ps.executeQuery();
		List<DepartmentD> dept=new ArrayList<>();
		while(rs.next()) {
			dept.add(mapSingleRow(rs));
		}
		con.close();
		return dept;
	}
	
	//Update Operation 
	@Override
	public void updateDepartment(DepartmentD dept) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE DEPARTMENT SET DEPTID=?,DEPTNAME=?,DEPTLOC=? WHERE DEPTID=? ");
		populatePreparedStatment(dept, ps);
		ps.setInt(4, dept.getDeptId());
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();	
	}
	
	//Delete Operation
	@Override
	public void deleteDepartment(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, id);
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();
	}
	
	@Override
	public DepartmentD getDepartment(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			DepartmentD dept = mapSingleRow(rs);
			con.close();
			return dept;
		}
		else {
			System.out.println("No DeptId found "+id+" ,Couldn't fetch data");
			return null;
		}
	}

	private DepartmentD mapSingleRow(ResultSet rs) throws SQLException {
		DepartmentD dept=new DepartmentD();
		dept.setDeptId(rs.getInt(1));
		dept.setDeptName(rs.getString(2));
		dept.setDeptLoc(rs.getString(3));
		dept.setEmpList(rs.getInt(4));
		return dept;
	}
	
	private void populatePreparedStatment(DepartmentD dept, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dept.getDeptId());
		ps.setString(2, dept.getDeptName());
		ps.setString(3, dept.getDeptLoc());
	}
	
	//Static methods are initialized as soon as an object instance is created
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false&allowPublicKeyRetrieval=true","root","root");
	}
	
	public static void main(String[] args) throws SQLException {
		DepartmentDAO dept=new DepartmentDAOImpl();
		System.out.println(dept.getDepartment(1));
		System.out.println("---------------------");
		System.out.println(dept.getDepartments());
		
		// Create Operation
//		System.out.println("---------------------");
//		System.out.println("Creating Department");
//		dept.createDepartment(new DepartmentD(5,"Human Resources","Banglore"));
		
		// Update Operation
//		System.out.println("---------------------");
//		System.out.println("Updating Department");
//		DepartmentD dept1=dept.getDepartment(2);
//		dept1.setDeptName("Back-end Developer");
//		dept.updateDepartment(dept1);
		
		// Delete Operation
//		System.out.println("---------------------");
//		System.out.println("Deleting a Department");
//		dept.deleteDepartment(6);
		
		//All function working just fine
		System.out.println(dept.lastDept());
		System.out.println(dept.firstDept());
		System.out.println(dept.nextDept(1));
		System.out.println(dept.previousDept(2));
	}
}
