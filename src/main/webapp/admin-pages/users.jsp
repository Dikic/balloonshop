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
						<th>City</th>
						<th>Zip</th>
						<th>Country</th>
						<th class="not-sortable">Action</th>
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
						<td>${user.city}</td>
						<td>${user.zip}</td>
						<td>${user.country}</td>
						<td><button class="btn btn-warning btn-block" onclick="editUser(${user.id})">Edit</button><button class="btn btn-danger btn-block" onclick="deleteUser(${user.id})">Delete</button></td>
					</tr>
				</c:forEach>
			</table>		
			<br>	
		</div>
	</div>
<div class="row">
	<nav class="text-center">
		<ul class="pagination shadow">
			<c:if test="${page ne 1}">
				<li><a
					href="?page=${page - 1}">
						<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
				</a></li>
			</c:if>
			<c:forEach begin="1" end="${pageCount}" varStatus="status">
				<li class="${page == status.count? 'active':'' }"><a
					href="?page=${status.count}">${status.count}</a></li>
			</c:forEach>
			<c:if test="${page ne pageCount}">
				<li><a
					href="?page=${page + 1}">
						<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
				</a></li>
			</c:if>
		</ul>
	</nav>
</div>
	<div class="row">
		<div class="col-lg-12" id="user_form">
			<jsp:include page="user_form.jsp"></jsp:include>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#myTable").tablesorter();
		});
		
		function deleteUser(id){
		    if(confirm("Are you sure you want to delete the user?") ){
		           location.href="/balloonshop/admin/delete/user?id="+id;
		     }
		}
		
		function editUser(id){
			$.get(("/balloonshop/admin/edit/userform/"+id),function(form){
				$("#user_form").html(form);
			});
		};
	</script>