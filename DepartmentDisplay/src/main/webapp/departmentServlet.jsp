<%@page import="departmentDisplay.DepartmentD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department and Employee Details</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
   body {
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
    margin: 0;
    padding: 0;
}

/* Add styles for the title */
h1 {
    text-align: center;
    margin: 20px 0;
    color: #333;
}

/* Add styles for the tables */
table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

table, th, td {
    border: 1px solid #ccc;
}

/* Add styles for table headers */
th {
    background-color: #333;
    color: #fff;
    text-align: left;
    padding: 10px;
}

/* Add styles for table data rows */
td {
    padding: 8px;
}

/* Add styles for form buttons */
input[type="submit"] {
    background-color: #333;
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    margin: 5px;
}

/* Add styles for the form buttons container */
td[colspan="2"] {
    text-align: center;
}

/* Add styles for links */
a {
    color: #333;
    text-decoration: none;
}

/* Add hover effect for links */
a:hover {
    text-decoration: underline;
}@charset "ISO-8859-1";
</style>
</head>
<body>



	<%
	DepartmentD dept = (DepartmentD) session.getAttribute("dept");
	%>
	<table class="table table-bordered">
		<tr>
			<td>Department Id:</td>
			<td><%=dept.getDeptId()%></td>
		</tr>
		<tr>
			<td>Department Name:</td>
			<td><%=dept.getDeptName()%></td>
		</tr>
		<tr>
			<td>Department Location:</td>
			<td><%=dept.getDeptLoc()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="dispEmpbyDept" method="post">
					<input type="submit" name="submit" value="First" /> <input
						type="submit" name="submit" value="Previous" /> <input
						type="submit" name="submit" value="Next" /> <input type="submit"
						name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>EXPERIENCE</th>
				<th>SENIORITY</th>
				<th>SALARY</th>
				<th>DEPTID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${emps}">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.age}" /></td>
					<td><c:out value="${employee.experience}" /></td>
					<td><c:out value="${employee.seniority}" /></td>
					<td><c:out value="${employee.salary}" /></td>
					<td><c:out value="${employee.deptId}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
