<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<div class="row">
	<div class="col-xs-2">
		<img class="img-responsive"
			src="${pageContext.request.contextPath}/images/${param.img}">
	</div>
	<div class="col-xs-4">
		<h4 class="product-name">
			<strong>${param.name}</strong>
		</h4>

	</div>
	<div class="col-xs-6">
		<div class="col-xs-6 text-right">
			<h6>
				<strong>${param.price} <span class="text-muted">x</span></strong>
			</h6>
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control input-sm" value="${param.quantity }">
		</div>
		<div class="col-xs-2">
			<a href="${pageContext.request.contextPath}/removeFromCart/${param.cartProductId}" type="button" class="btn btn-link btn-xs">
				<span class="glyphicon glyphicon-trash"> </span>
			</a>
		</div>
	</div>
</div>
<hr>