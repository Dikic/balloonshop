<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-lg-12">
		<table class="tablesorter table table-border" id="myTable">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
					<th class="not-sortable">Action</th>
				</tr>
			</thead>
			<c:forEach var="category" items="${categories}">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><button 
							class="btn btn-warning btn-block" onclick="editCategory(${category.id})">Edit</button>
						<button class="btn btn-danger btn-block"
							onclick="deleteCategory(${category.id})">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</div>
</div>
<div class="row">
	<div class="col-lg-12" id="category_form">
		<jsp:include page="category_form.jsp"></jsp:include>
		<!--  -->
	</div>
</div>

<script type="text/javascript">
		$(document).ready(function() {
			$("#myTable").tablesorter();
		});
		
		function deleteCategory(id){
		    if(confirm("Are you sure you want to delete the category?") ){
		           location.href="/balloonshop/admin/delete/category?id="+id;
		     }
		}
		
		function editCategory(id){
			$.get(("/balloonshop/admin/edit/categoryform/"+id),function(form){
				$("#category_form").html(form);
			});
		};
	</script>