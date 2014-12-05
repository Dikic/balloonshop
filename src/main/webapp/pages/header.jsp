<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta name="generator"
	content="HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39" />
<meta charset="UTF-8" />
<title></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/balloonshop.css" />
</head>
<body>
	<br />
	<div class="container">
		<div class="row">
			<div class=" hidden-xs col-sm-2">
				<img width="200"
					src="${pageContext.request.contextPath}/images/logo.png"
					class="img-responsive" alt="Responsive image" />
			</div>
			<div class="col-sm-10">
				<h1>
					Balloon Shop <small>selling happiness</small>
				</h1>
				<button type="button" class="btn btn-link" data-toggle="modal"
					data-target="#sing-in-modal">sign in</button>

			</div>

		</div>
		<hr />
		<div class="row">
			<div class="col-lg-10 col-lg-offset-2">
				<h3>Our products</h3>
			</div>
		</div>
		<!-- header -->
		<div class="row">
			<div class="col-lg-2 col-md-3">
				<!-- sidebar -->
				<div class="container-fluid">
					<div class="row">
						<div class="list-group shadow">
							<div class="list-group-item list-group-item-warning">Choose
								a category</div>
							<a class="list-group-item" href="#">Love &amp; romance</a> <a
								class="list-group-item" href="#">Birthdays</a> <a
								class="list-group-item" href="#">Wedding</a> <a
								class="list-group-item" href="#">Cartoons</a> <a
								class="list-group-item" href="#">Message balloons</a>
						</div>
					</div>
					<div class="row">
						<!-- shopping cart -->
						<button class="btn btn-block btn-primary shadow" type="button">
							<span class="glyphicon glyphicon-shopping-cart pull-left"></span>
							Shopping cart <span class="badge">2</span>
						</button>
					</div>
					<!-- shopping cart -->
				</div>
			</div>
			<div class="col-lg-10 col-md-9">
				<!-- main -->
				<div class="row">
					<div class="col-lg-4 col-sm-6 col-xs-12 ">
						<div class="panel panel-default shadow">
							<div class="panel-body">
								<h3>
									Balloon title <small> <a href="#">(View details)</a>
									</small>
								</h3>
								<img src="${pageContext.request.contextPath}/images/balonce.jpg"
									class="img img-thumbnail img-responsive" />
								<h5>Balloon description</h5>
								<h4>Price</h4>
								<a href="#">Add to shopping cart</a>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-sm-6 col-xs-12">
						<div class="panel panel-default shadow">
							<div class="panel-body">
								<h3>
									Balloon title <small> <a href="#">(View details)</a>
									</small>
								</h3>
								<img src="${pageContext.request.contextPath}/images/balonce.jpg"
									class="img img-thumbnail img-responsive" />
								<h5>Balloon description</h5>
								<h4>Price</h4>
								<a href="#">Add to shopping cart</a>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-sm-6 col-xs-12">
						<div class="panel panel-default shadow">
							<div class="panel-body">
								<h3>
									Balloon title <small> <a href="#">(View details)</a>
									</small>
								</h3>
								<img src="${pageContext.request.contextPath}/images/balonce.jpg"
									class="img img-thumbnail img-responsive" />
								<h5>Balloon description</h5>
								<h4>Price</h4>
								<a href="#">Add to shopping cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<nav class="text-center">
			<ul class="pagination shadow">
				<li><a href="#"> <span aria-hidden="true">&laquo;</span> <span
						class="sr-only">Previous</span></a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</nav>
	</div>

	<jsp:include page="login.jsp"></jsp:include>
</body>
</html>
