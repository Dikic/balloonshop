<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${product.id==0}">
		<title>Add new product</title>
	</c:when>
	<c:otherwise>
		<title>Edit product</title>
	</c:otherwise>
</c:choose>
<div class="jumbotron row">

	<c:choose>
		<c:when test="${product.id==0}">
			<h4>Add new product</h4>
		</c:when>
		<c:otherwise>
			<h4>Edit product</h4>
		</c:otherwise>
	</c:choose>

	<form:form enctype='multipart/form-data'
		class="form-horizontal col-sm-9" commandName="product" role="form"
		method="post"
		action="${pageContext.request.contextPath}/admin/product?productId=${product.id}">
		<div class="form-group">
			<label class="control-label col-sm-2">Name:</label>

			<div class="col-sm-10">
				<form:input class="form-control" path="name"
					placeholder="Enter name" value="${product.name}" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Description:</label>

			<div class="col-sm-10">
				<form:input class="form-control" path="description"
					placeholder="Enter description" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Price:</label>

			<div class="col-sm-10">
				<form:input class="form-control" path="price"
					placeholder="Enter price" />
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
				<form:checkbox class="form-control" path="onPromotion" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Select category:</label>
			<div class="col-sm-6">
				<form:select path="categories">
						<form:options items="${categoriesList}" itemValue="id"/>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${product.id==0}">
						<input type="submit" class="btn btn-danger"
							value="Create new product"></input>
					</c:when>
					<c:otherwise>
						<input type="submit" class="btn btn-danger"
					value="Edit product"></input>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</form:form>
</div>