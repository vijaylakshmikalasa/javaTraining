<%@page import="com.valtech.training.firstspringboot.models.OrderModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%OrderModel order= (OrderModel)request.getAttribute("orders"); %>
	<form method="post" action="save?id=<%= order.getId()%>">
		<table border="2px">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" disabled="disabled" value="<%=order.getId() %>" ></td>

			</tr>
			<tr>
				<td>Item</td>
				<td><input type="text" name="item" value="<%=order.getItem() %>"></td>

			</tr>
			<tr>
				<td>ItemCount</td>
				<td><input type="text" name="itemcount" value="<%=order.getItemcount() %>"></td>

			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" value="<%=order.getDescription() %>"></td>

			</tr>
			<tr>
				<td>OrderDate</td>
				<td><input type="text" name="orderDate" value="<%=order.getOrderDate() %>"></td>

			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="create" />
					<input type="submit" name="cancel" value="cancel" /></td>

			</tr>
			
		</table>
		</form>
</body>
</html>