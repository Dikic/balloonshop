<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="row">
		<div class="col-lg-12">
			<table class="tablesorter table table-border" id="myTable">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Large image</th>
						<th>Small image</th>
						<th>On promotion</th>
						<th class="not-sortable">Action</th>
					</tr>
				</thead>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.largeImage}</td>
						<td>${product.smallImage}</td>
						<td>${product.onPromotion}</td>
						<td><button class="btn btn-warning">Edit</button><br><button class="btn btn-danger" onclick="deleteProduct(${product.id})">Delete</button></td>
					</tr>
				</c:forEach>
			</table>		
			<br>	
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<h4>Add new product</h4>
    <form class="form-horizontal col-sm-9" role="form" method="post" action="${pageContext.request.contextPath}/admin/add/product">
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
            <label class="control-label col-sm-2">Price:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="price" name="price" placeholder="Enter price">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Large image treba upload na file da se napravi:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="largeImage" name="largeImage" placeholder="Enter password">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Small Image treba upload na file:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="smallImage" name="smallImage" placeholder="Enter address">
            </div>
        </div>
        <div class="form-group">
        <label class="control-label col-sm-2">On promotion:</label>
            <div class="col-sm-1">
                <input type="checkbox" class="form-control" id="onPromotion" name="onPromotion">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-danger" value="Create new product"></input>
            </div>
        </div>
    </form>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#myTable").tablesorter();
		});
		
		function deleteProduct(id){
		    if(confirm("Are you sure you want to delete the product?") ){
		           location.href="/balloonshop/admin/delete/product?id="+id;
		     }
		}
	</script>