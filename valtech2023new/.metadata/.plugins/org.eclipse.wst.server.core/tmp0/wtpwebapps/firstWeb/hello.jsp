<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Example</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
  background-color: white;
}

.container {
  max-width: 350px;
  margin: 0 auto;
  padding: 10px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2);
}

.form-group {
  margin-bottom: 15px;
}

.form-control {
  border-radius: 3px;
  border: 1px solid #ccc;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
}

.form-control:focus {
  border-color: #66afe9;
  outline: 0;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(102, 175, 233, 0.6);
}

.btn-secondary {
  background-color: #4267b2;
  border-color: #4267b2;
  color: #fff;
}

.btn-secondary:hover, .btn-secondary:focus, .btn-secondary:active, .btn-secondary.active {
  background-color: #3558a3;
  border-color: #3558a3;
  color: #fff;
}

</style>
</head>
<body class="body">
	<div class="container mt-4">
		<%
		if (request.getAttribute("loginerr") != null) {
		%>
		<p style="color: red;"><%=request.getAttribute("loginerr")%></p>
		<%
		}
		%>
		<form action="login" class="form" method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input name="name" type="text"
					class="form-control" id="name">
				<%
				if (request.getAttribute("nameerr") != null) {
				%>
				<p style="color: red;"><%=request.getAttribute("nameerr")%></p>
				<%
				}
				%>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input name="password"
					type="password" class="form-control" id="password">
				<%
				if (request.getAttribute("passworderr") != null) {
				%>
				<p style="color: red;"><%=request.getAttribute("passworderr")%></p>
				<%
				}
				%>
			</div>
			<button type="submit" class="btn btn-secondary">Login</button>
		</form>
		<%
		if (request.getAttribute("message") != null) {
		%>
		<p style="color: red;">
			Message =
			<%=request.getAttribute("message")%></p>
		<%
		}
		%>
	</div>
</body>
</html>