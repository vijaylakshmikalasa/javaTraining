<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Processing Results</title>
</head>
<link rel="stylesheet" type="text/css" href="results.css">
<body>
    <h1>Processing Results</h1>
    <p><strong>Inputted Text:</strong></p>
    <p><%= request.getAttribute("paragraph") %></p>
    <p><strong>Total Word Count is:</strong></p>
    <p><%= request.getAttribute("totalWordCount") %></p>
    <p><strong>Remaining Word Counts:</strong></p>
    <ul>
        <c:forEach var="entry" items="${wordCountMap}">
            <li>${entry.key}: ${entry.value}</li>
        </c:forEach>
    </ul>
</body>
</html>
