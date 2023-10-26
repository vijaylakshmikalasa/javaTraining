<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<style>
	/* Global Styles */
body {
    font-family: Arial, sans-serif;
}

.container {
    margin-top: 20px;
}

.card {
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.card-body {
    padding: 20px;
}

/* Header Styles */
.navbar {
    border-radius: 0;
}

.navbar-brand {
    font-size: 1.5rem;
    font-weight: bold;
}

.navbar-nav .nav-link {
    color: white;
}

/* Form Styles */
.form-group {
    margin: 10px 0;
}

.form-control {
    width: 100%;
}

label {
    font-weight: bold;
}

.btn-success {
    margin-top: 10px;
}

/* Responsive Styles */
@media (max-width: 768px) {
    .container {
        width: 100%;
    }
}

/* Additional Styles with Different Alignment and Red Color */
.container {
    text-align: center; /* Center-align the content */
}

.card {
    background-color: #ff3333; /* Set a red background color */
    color: white; /* Set text color to white */
}

.card-body {
    text-align: left; /* Left-align the card body text */
}

.btn-success {
    background-color: #ff3333; /* Change button color to red */
}

	</style>
</head>
<link rel="stylesheet" type="text/css" href="employee.css">
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<form action="update" method="post">
					
				<table class="form-group">
					<tr>
					<td><label>Employee ID</label></td>
					<td><input type="number" 
						value="<c:out value='${Employee.eid}' />" class="form-control"  
						name="eid" required="required" readonly/></td>
					</tr>

					<tr>
					<td><label>Employee Name</label></td> 
					<td><input type="text"
						value="<c:out value='${Employee.name}' />" class="form-control"
						name="name" required="required" readonly/></td>
					</tr>

				<tr>
					<td><label>Age</label></td> 
					<td><input type="number"
						value="<c:out value='${Employee.age}' />" class="form-control"
						name="age" readonly/></td>
				</tr>

				<tr>
					<td><label>Experience</label></td>
					<td><input type="number"
						value="<c:out value='${Employee.experience}' />" class="form-control" 
						name="experience" readonly/></td>
				</tr>

				<tr>
					<td><label>Seniority</label></td>
					<td><input type="number"
						value="<c:out value='${Employee.seniority}' />" class="form-control" 
						name="seniority" readonly/></td>
				</tr>

				<tr>
					<td><label>Salary</label></td> 
					<td><input type="number"
						value="<c:out value='${Employee.salary}' />" class="form-control"
						name="salary" readonly/><td>
				</tr>

				<tr>
					<td><label>Department ID</label></td> 
					<td><input type="number"
						value="<c:out value='${Employee.did}' />" class="form-control"
						name="did" readonly/></td>
				</tr>

				<tr>
					<td><button type="submit" class="btn btn-success">Save</button></td>
				</tr>
				
				</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>