<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-md-3">
			<jsp:include page="admin_block.jsp">
				<jsp:param value="primary" name="type" />
				<jsp:param value="Users" name="title" />
				<jsp:param value="${usersCount}" name="count" />
				<jsp:param value="users" name="link" />
			</jsp:include>
		</div>
		<div class="col-xs-12 col-md-3">
			<jsp:include page="admin_block.jsp">
				<jsp:param value="primary" name="type" />
				<jsp:param value="Products" name="title" />
				<jsp:param value="${productsCount}" name="count" />
				<jsp:param value="products" name="link" />
			</jsp:include>
		</div>
		<div class="col-xs-12 col-md-3">
			<jsp:include page="admin_block.jsp">
				<jsp:param value="primary" name="type" />
				<jsp:param value="Categories" name="title" />
				<jsp:param value="${categoriesCount}" name="count" />
				<jsp:param value="categories" name="link" />
			</jsp:include>
		</div>
		<div class="col-xs-12 col-md-3">
			<jsp:include page="admin_block.jsp">
				<jsp:param value="primary" name="type" />
				<jsp:param value="Purchases" name="title" />
				<jsp:param value="${purchasesCount}" name="count" />
				<jsp:param value="purchases" name="link" />
			</jsp:include>
		</div>
	</div>
	<div class="jumbotron">
		<div class="row">
			<h3>Products on promotion!!!<small>(change this in products page.)</small></h3>
		</div>
		<div class="row">
			<c:forEach var="promotion" items="${promotions}">
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<a
							href="${pageContext.request.contextPath}/details/${promotion.id}">
							<img class="img img-static"
							src="${pageContext.request.contextPath}/images/${promotion.smallImage}"
							alt="Balloonshop - ${promotion.name }">
						</a>
						<div class="caption">
							<h4 class="no-wrap">${promotion.name}</h4>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>