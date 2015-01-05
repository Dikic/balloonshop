<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div class="row">
		<div class="col-lg-12">
			<table class="tablesorter table table-border" id="myTable">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th class="not-sortable">Action</th>
					</tr>
				</thead>
				<c:forEach var="category" items="${categories}">
					<tr>
						<td>${category.name}</td>
						<td>${category.description}</td>
						<td><button class="btn btn-warning">Edit</button><br><button class="btn btn-danger" onclick="deleteCategory(${category.id})">Delete</button></td>
					</tr>
				</c:forEach>
			</table>		
			<br>	
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<h4>Add new category</h4>
    <form:form class="form-horizontal col-sm-9" role="form" method="post" commandName="category" action="${pageContext.request.contextPath}/admin/add/category">
        <div class="form-group">
            <label class="control-label col-sm-2">Name:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Description:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="description" name="description" placeholder="Enter description">
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-danger" value="Create new category"></input>
            </div>
        </div>
    </form:form>
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
	</script>