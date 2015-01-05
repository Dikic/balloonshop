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
						<td><button class="btn btn-warning">Edit</button><br><button class="btn btn-danger" onclick="deleteUser(${user.id})">Delete</button></td>
					</tr>
				</c:forEach>
			</table>		
			<br>	
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<h4>Add new user</h4>
    <form class="form-horizontal col-sm-9" role="form" method="post" action="${pageContext.request.contextPath}/admin/add/user">
        <div class="form-group">
            <label class="control-label col-sm-2">Name:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Surname:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="surname" name="surname" placeholder="Enter surname">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">E-mail:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="email" name="email" placeholder="Enter e-mail">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Password:</label>

            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Address:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" name="address" placeholder="Enter address">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Authority:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="authority" name="authority" placeholder="Enter authority">
            </div>
        </div>
        <div class="form-group">
        <label class="control-label col-sm-2">Enabled:</label>
            <div class="col-sm-1">
                <input type="checkbox" class="form-control" id="enabled" name="enabled">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-danger" value="Create new user"></input>
            </div>
        </div>
    </form>
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
	</script>