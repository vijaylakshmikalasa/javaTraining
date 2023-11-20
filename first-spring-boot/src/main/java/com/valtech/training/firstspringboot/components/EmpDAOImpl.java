package com.valtech.training.firstspringboot.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	private DataSource dataSource;

	public class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setExperience(rs.getInt(4));
			e.setSenior(rs.getInt(5));
			e.setSalary(rs.getInt(6));
			return e;
		}
	}

	

	

	@Override
	public long count() {
		String countQry = "SELECT COUNT(ID) FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}

	@Override
	public void deleteEmployee(int id) {

		String deleteQry = "DELETE  FROM EMPLOYEE WHERE ID =?";
		new JdbcTemplate(dataSource).update(deleteQry, id);

	}

	@Override
	public void updateEmployee(Employee emp) {
		String updateQry = "UPDATE EMPLOYEE SET NAME=?,AGE=?, EXP=?, SINIOR=?,SALARY=? WHERE ID=?";
		new JdbcTemplate(dataSource).update(updateQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getId());

	}
	
	@Override
	public void createEmployee(Employee emp)  {

		String createQry = "INSERT INTO EMPLOYEE (NAME,AGE,EXP,SINIOR,SALARY) VALUES(?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getId());
		
	}
	
	@Override
	public List<Employee> getAllEmployees()  {
		String selectAllQry = "SELECT ID,NAME,AGE,EXP,SINIOR,SALARY FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).query(selectAllQry, new EmployeeRowMapper());
		
	}

	@Override
	public Employee getEmployee(int id) {

		String selectQry = "SELECT ID ,NAME,AGE,EXP,SINIOR, SALARY FROM EMPLOYEE WHERE ID =?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new EmployeeRowMapper());
	}

	@Override
	public void getListOfEmployeeinEachDepartment() throws SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"UPDATE DEPARTMENT D SET EMPLIST=(SELECT COUNT(*) FROM EMPLOYEE E WHERE E.DEPTID=D.DEPTID)");

		int rowsUpdated = ps.executeUpdate();

		System.out.println("Rows update:" + rowsUpdated);

		con.close();
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getEmployeeByDeptName(String name) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTNAME=?)");

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		List<Employee> emps1 = new ArrayList<>();

		while (rs.next()) {

			emps1.add(mapRowToEmployee1(rs));

		}

		con.close();

		System.out.println(emps1.size());

		return emps1;
	}

	@Override
	public List<Employee> getEmployeesSalaryGT(double amount) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY >=?");
		ps.setFloat(1, (float) amount);
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			emps.add(mapRowToEmployee1(rs));

		}
		conn.close();

		return emps;

	}

	@Override
	public List<Employee> getEmployeesSalaryLT(double amount) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY <=?");
		ps.setFloat(1, (float) amount);
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			emps.add(mapRowToEmployee1(rs));

		}

		conn.close();

		return emps;
	}

	@Override
	public List<Employee> getEmployeeSeniority(int seniority) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(SINIOR)  FROM EMPLOYEE ");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			int ans = rs.getInt(1);
			System.out.println(ans);

		}
		return emps;
	}

	@Override
	public List<Employee> getEmployeeAgeBetween() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT *  FROM EMPLOYEE WHERE AGE BETWEEN 20 AND 30 ");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			emps.add(mapRowToEmployee1(rs));

		}

		return emps;

	}

	@Override
	public List<Employee> getEmployeeLocation(String location) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTLOC=?)");

		ps.setString(1, location);

		ResultSet rs = ps.executeQuery();

		List<Employee> emps = new ArrayList<>();

		while (rs.next()) {

			emps.add(mapRowToEmployee1(rs));
		}
		return emps;
	}

	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSenior());
		empSalary(emp, ps);
	}

	private void empSalary(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setInt(5, (int) emp.getSalary());
	}

	

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		mapRow(rs, e);
		return e;
	}

	private void mapRow(ResultSet rs, Employee e) throws SQLException {
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSenior(rs.getInt(5));
		e.setSalary(rs.getInt(6));
	}

	private Employee mapRowToEmployee1(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setName(rs.getString(1));
		e.setAge(rs.getInt(2));
		e.setExperience(rs.getInt(3));
		e.setSenior(rs.getInt(4));
		e.setSalary(rs.getInt(5));
		return e;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}

	public static void main(String[] args) throws SQLException {
		EmpDAO dao = new EmpDAOImpl();
		// System.out.println(dao.getEmployee(1));
		// System.out.println(dao.getEmployee(2));
		// System.out.println(dao.getEmployee(3));
		// System.out.println(dao.getAllEmployees());
		// dao.createEmployee(new Employee("latha",29,2,1,30000.0));
		// System.out.println(dao.getEmployee(3));
		Employee e = dao.getEmployee(5);
//		e.setSenior(8);
//		e.setAge(55);

//		dao.updateEmployee(e);
//		dao.deleteEmployee(4);
//		System.out.println(dao.getEmployee(1));

		// dao.count();
		// System.out.println(dao.getEmployee(1));

		// System.out.println(dao.getEmployeesSalaryGT(100000.0));
		// System.out.println(dao.getAllEmployees());

//		System.out.println(dao.getAllEmployees());
//		System.out.println(dao.getEmployeeSeniority(1));

//		System.out.println(dao.getEmployeeAgeBetween());
//		System.out.println(dao.getEmployeeLocation("bengaluru"));

		System.out.println(dao.getEmployeeByDeptName("Fedeveloper"));

	}

}
