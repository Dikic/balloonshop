<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="row">
		<div class="col-lg-12">
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
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#myTable").tablesorter();
		});
	</script>