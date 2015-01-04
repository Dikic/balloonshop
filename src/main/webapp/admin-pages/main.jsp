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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tablesorter.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/balloonshop.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/table.css" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/speed-logo.png" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/admin/">Admin</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a class="glyphicon glyphicon-bell" href="#"><span
							class="badge">${ordersCount}</span></a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Manage
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/admin/users">Users</a></li>
							<li><a href="#">Products</a></li>
							<li><a href="#">Categories</a></li>
							<li><a href="#">Orders</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-right" role="search" method="get">
					<div class="form-group">

						<input type="text" class="form-control" name="search"
							placeholder="Search" value="${search}">

					</div>
					<input class="btn btn-danger" type="submit" value="Search">
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>
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


		<!-- header -->
		<div class="row">
			<div class="col-lg-2 col-md-3">
				<!-- sidebar -->
				<div class="container-fluid">
					<br>
					<div class="row">
						<div class="list-group shadow">
							<div class="list-group-item list-group-item-danger">Choose</div>
							<a class="list-group-item" href="${pageContext.request.contextPath}/admin/users">Users</a> <a
								class="list-group-item" href="#">Products</a> <a
								class="list-group-item" href="#">Categories</a> <a
								class="list-group-item" href="#">Orders</a>
						</div>
					</div>

				</div>
			</div>
			<div class="container-fluid">
				<div class="col-lg-10 col-md-9">
					<jsp:include page="${view}.jsp"></jsp:include>
				</div>
			</div>
		</div>

	</div>
</body>
</html>