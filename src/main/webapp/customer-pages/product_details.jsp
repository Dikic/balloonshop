<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<div class="container-fluid jumbotron shadow">
	<h2>${product.name}</h2>
	<hr />
	<div class="media">
		<div class="media-left">
			<img class="img-responsive img-thumbnail" src="../images/${product.largeImage}"
				alt="img">
		</div>
		<div class="media-body">
			<h3 class="text-info">${product.price}&dollar;</h3>
			<p class="description">${product.description}</p>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/add-to-cart/${param.id}">Add
				to cart <span class="glyphicon glyphicon-shopping-cart"></span>
			</a>
		</div>
	</div>
</div>