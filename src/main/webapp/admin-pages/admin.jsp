<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tablesorter.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	
<title>Admin</title>
</head>
<body>
	<table class="tablesorter table table-border" id="myTable">
		<thead>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>E-mail</th>
				<th>Password</th>
				<th>Address</th>
				<th>Authority</th>
			</tr>
		</thead>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name}</td>
				<td>${user.surname}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td>${user.address}</td>
				<td>${user.authority}</td>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>