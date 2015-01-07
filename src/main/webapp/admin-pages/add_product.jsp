<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="jumbotron row">
	<h4>Add new product</h4>
	<form:form enctype='multipart/form-data' class="form-horizontal col-sm-9" commandName="product" role="form" method="post"
		action="${pageContext.request.contextPath}/admin/product">
		<div class="form-group">
			<label class="control-label col-sm-2">Name:</label>

			<div class="col-sm-10">
				<form:input class="form-control" path="name"
					placeholder="Enter name"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Description:</label>

			<div class="col-sm-10">
				<form:input class="form-control" path="description" placeholder="Enter description"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Price:</label>

			<div class="col-sm-10">
				<form:input class="form-control" path="price"
					placeholder="Enter price"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Large image:</label>

			<div class="col-sm-10">
			<form:input type="file" path="fileLargeImage" />
				<!--  <input type="file" class="form-control" id="largeImage"
					name="largeImage" placeholder="Enter password">-->
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Small Image:</label>

			<div class="col-sm-10">
			<form:input type="file" path="fileSmallImage" />
				<!--<input type="file" class="form-control" id="smallImage"
					name="smallImage" placeholder="Enter address">-->
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">On promotion:</label>
			<div class="col-sm-1">
				<form:checkbox class="form-control" path="onPromotion"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-danger"
					value="Create new product"></input>
			</div>
		</div>
	</form:form>
</div>