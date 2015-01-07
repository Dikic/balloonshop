<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid jumbotron shadow">
	<h2>${product.name}</h2>
	<hr />
	<div class="media">
		<div class="media-left">
			<img class="img-responsive img-thumbnail"
				src="${pageContext.request.contextPath}/images/${product.largeImage}"
				alt="img">
		</div>
		<div class="media-body">
			<h3 class="text-info">${product.price}&dollar;</h3>
			<p class="description">${product.description}</p>
			<h4 class="text-info">Categories:</h4>
			<ul>
				<c:forEach items="${product.categories}" var="cat">
					<li><a
						href="${pageContext.request.contextPath}/?category=${cat.id}">${cat.name }</a></li>
				</c:forEach>
			</ul>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/add-to-cart/${product.id}">Add
				to cart <span class="glyphicon glyphicon-shopping-cart"></span>
			</a>
		</div>
	</div>
</div>