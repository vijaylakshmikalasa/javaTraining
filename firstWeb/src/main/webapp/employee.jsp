<%@page import="firstWeb.EmployeeD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Retrieval</title>
</head>
<body>

<% EmployeeD emp=(EmployeeD) session.getAttribute("emp"); %>
<table>
	<tr>
		<td>ID</td>
		<td><%=emp.getId() %></td>
	</tr>
	
	<tr>
		<td>Name</td>
		<td><%=emp.getName() %></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><%=emp.getAge() %></td>
	</tr>
	<tr>
		<td>Experience</td>
		<td><%=emp.getExperience() %></td>
	</tr>
	<tr>
		<td>Seniority</td>
		<td><%=emp.getSeniority() %></td>
	</tr>
	<tr>
		<td>Salary</td>
		<td><%=emp.getSalary() %></td>
	</tr>
	<tr>
		<td>
			<form action="empCtlr" method="post">
				<input type="Submit" value="First" name="action"/>
				<input type="Submit" value="Previous" name="action"/>
				<input type="Submit" value="Next" name="action"/>
				<input type="Submit" value="Last" name="action"/>
			</form>
		</td>
	</tr>
</table>
</body>
</html>