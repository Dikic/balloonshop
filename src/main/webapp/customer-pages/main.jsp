<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/balloon-shop.js"></script>
<script type="text/javascript" async defer  data-pin-color="red" data-pin-hover="true" src="//assets.pinterest.com/js/pinit.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/balloonshop.css" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/speed-logo.png" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balloon shop emk</title>
</head>
<body>

	<br />
	<div class="container">
		<c:if test="${not empty notice}">
			<div class="alert alert-warning alert-dismissible text-center"
				role="alert">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				${notice }
			</div>
		</c:if>
		<div class="row">
			<div class=" hidden-xs col-sm-2">
				<a href="${pageContext.request.contextPath}" class=""> <img
					width="200"
					src="${pageContext.request.contextPath}/images/logo.png"
					class="img-responsive" alt="Responsive image" /></a>
			</div>
			<div class="col-sm-8">
				<h1>
					<strong>Balloon Shop</strong> <small>selling happiness</small>

				</h1>
			</div>
			<br>
			<div class="col-sm-2">
				<div class="btn-group " role="group">

					<c:if test="${not empty customer}">
						<a class="btn btn-default"
							href="${pageContext.request.contextPath}/profile">${customer.name}</a>
						<a class="btn btn-warning btn-disabled"
							href="${pageContext.request.contextPath}/signout">sign out </a>
					</c:if>
					<c:if test="${empty customer}">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#sing-in-modal" id="btn-sign-in">Sign in</button>
						<button type="button" class="btn btn-warning" data-toggle="modal"
							data-target="#sign-up-modal" id="btn-sign-up">Sign up</button>
					</c:if>

				</div>
			</div>

		</div>
		<hr />

		<!-- header -->
		<div class="row">
			<div class="col-lg-2 col-md-3">
				<!-- sidebar -->
				<div class="container-fluid">
					<div class="row">
						<form class="form-inline" role="form" method="get"
							action="${pageContext.request.contextPath}/">
							<input type="hidden" name="category" value="${category}">
							<div class="input-group">
								<input type="text" class="form-control" name="search"
									placeholder="Search" value="${search}"> <span
									class="input-group-btn"> <input class="btn btn-primary"
									type="submit" value="Go!">
								</span>
							</div>
						</form>
					</div>
					<br>
					<div class="row">
						<div class="list-group shadow">
							<div class="list-group-item list-group-item-info">
								<a href="${pageContext.request.contextPath}/">Choose a
									category</a>
							</div>
							<c:forEach var="cat" items="${categories}">
								<a class="list-group-item ${category eq cat.id ? 'active':'' }"
									href="${pageContext.request.contextPath}/?page=${empty page?1:page}&search=${search}&category=${cat.id}">
									${cat.name } </a>
							</c:forEach>
						</div>
					</div>
					<div class="row">
						<!-- shopping cart -->
						<a href="${pageContext.request.contextPath}/cart"
							class="btn btn-block btn-primary shadow" type="button"> <span
							class="glyphicon glyphicon-shopping-cart pull-left"></span>
							Shopping cart <span class="badge">${cartProductCount}</span>
						</a>
					</div>
					<br>
					<!-- shopping cart -->
				</div>
			</div>
			<div class="col-lg-10 col-md-9">
				<jsp:include page="${view}.jsp"></jsp:include>
			</div>
		</div>
		<div class="jumbotron jumbotron-promotion shadow">
			<div class="row">
				<h2 class="text-center"><strong>Products on promotion</strong></h2>
			</div>
			<div class="row">
				<c:forEach var="promotion" items="${promotions}">
					<div class="col-sm-6 col-md-2">
						<div class="thumbnail">
							<a
								href="${pageContext.request.contextPath}/details/${promotion.id}">
								<img class="img img-static"
								src="${pageContext.request.contextPath}/images/${promotion.smallImage}"
								alt="Balloonshop - ${promotion.name }">
							</a>
							<div class="caption">
								<h4 class="no-wrap">${promotion.name}</h4>
								<p class="text-primary">${promotion.price}$
									<abbr title="Add this item to cart"><a
										href="${pageContext.request.contextPath}/add-to-cart/${promotion.id}"
										class="glyphicon glyphicon-shopping-cart"></a></abbr>
								</p>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="sign-up-modal.jsp"></jsp:include>
	<jsp:include page="sign-in-modal.jsp"></jsp:include>
</body>
</html>