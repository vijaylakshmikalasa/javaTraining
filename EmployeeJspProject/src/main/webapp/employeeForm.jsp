<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<link rel="stylesheet" type="text/css" href="employeeForm.css">
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
    background-color: red; /* Change background color to red */
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

/* Form Styles */
.form-group {
    margin: 10px 0;
}

.form-control {
    width: 100%;
}

fieldset {
    border: 1px solid #ccc;
    padding: 10px;
    border-radius: 5px;
    margin-bottom: 10px;
}

label {
    font-weight: bold;
}

.btn-success {
    margin-top: 10px;
    background-color: red; /* Change button background color to red */
    color: white;
    border: none;
}

/* Responsive Styles */
@media (max-width: [your media query value here]) {
    /* Add your responsive styles here */
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Employee != null}">
				
					<form action="update" method="post">
					
					<h2>Edit Employee</h2>
					
					<fieldset class="form-group">
					<label>Employee ID</label> <input type="number" 
						value="<c:out value='${Employee.eid}' />" class="form-control"  
						name="eid" required="required" readonly/>
				</fieldset>
				
				</c:if>
				
				<c:if test="${Employee == null}">
				
					<form action="insert" method="post">
					
					<h2> Add New Employee</h2>
					
					<fieldset class="form-group">
					<label>Employee ID</label> <input type="number" 
						value="<c:out value='${Employee.eid}' />" class="form-control"  
						name="eid" required="required"/>
				</fieldset>
				
				</c:if>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${Employee.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="number"
						value="<c:out value='${Employee.age}' />" class="form-control"
						name="age">
				</fieldset>

				<fieldset class="form-group">
					<label>Experience</label> <input type="number"
						value="<c:out value='${Employee.experience}' />" class="form-control" 
						name="experience">
				</fieldset>

				<fieldset class="form-group">
					<label>Seniority</label> <input type="number"
						value="<c:out value='${Employee.seniority}' />" class="form-control" 
						name="seniority">
				</fieldset>

				<fieldset class="form-group">
					<label>Salary</label> <input type="number"
						value="<c:out value='${Employee.salary}' />" class="form-control"
						name="salary">
				</fieldset>

				<fieldset class="form-group">
					<label>Department ID</label> <input type="number"
						value="<c:out value='${Employee.did}' />" class="form-control"
						name="did">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>