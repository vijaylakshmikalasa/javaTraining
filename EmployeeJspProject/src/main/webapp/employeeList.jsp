<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<link rel="stylesheet" type="text/css" href="employeeList.css">
<style>
/* Global Styles */
body {
    font-family: Arial, sans-serif;
}

.container {
    margin-top: 20px;
}

/* Header Styles */
.navbar {
    background-color: blue; /* Change background color to blue */
    border-radius: 0;
}

.navbar-brand {
    font-size: 1.5rem;
    font-weight: bold;
    color: white;
}

.navbar-nav .nav-link {
    color: white;
}

/* Table Styles */
.table {
    background-color: green; /* Change background color to green */
    border: 2px solid #f0f0f0;
}

.table th {
    background-color: #66ff66; /* Light green background color */
    color: black; /* Text color for table header */
}

.table td {
    background-color: #99ff99; /* Slightly darker green background color */
}

/* Button Styles */
.btn-success {
    background-color: red; /* Change background color to red */
    color: white; /* Change text color to white */
    border: 2px solid #ff3333; /* Red border color */
}

.btn-success:hover {
    background-color: #ff3333; /* Darker red on hover */
}

/* Responsive Styles */
@media (max-width: 768px) {
    .container {
        width: 100%;
    }
}

</style>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<p class="navbar-brand"> Employee Management Application </p>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Employee</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Employee</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Emp_ID</th>
						<th>Emp_Name</th>
						<th>Age</th>
						<th>Experience</th>
						<th>Seniority</th>
						<th>Salary</th>
						<th>Dept_ID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="Employee" items="${getAllEmployees}">

						<tr>
							<td><c:out value="${Employee.eid}" /></td>
							<td><c:out value="${Employee.name}" /></td>
							<td><c:out value="${Employee.age}" /></td>
							<td><c:out value="${Employee.experience}" /></td>
							<td><c:out value="${Employee.seniority}" /></td>
							<td><c:out value="${Employee.salary}" /></td>
							<td><c:out value="${Employee.did}" /></td>
							<td><a href="edit?eid=<c:out value='${Employee.eid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?eid=<c:out value='${Employee.eid}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="show?eid=<c:out value='${Employee.eid}' />">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>