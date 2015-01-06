<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="fluid-container">
	<div class="row">
		<div class="col-xs-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5>
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Shopping Cart
								</h5>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-6">
							<h3>Product</h3>
						</div>
						<div class="col-xs-3 text-right">
							<h3>Price</h3>
						</div>
						<div class="col-xs-3">
							<h3>Quantity</h3>
						</div>
					</div>
					<hr>
					<c:set var="total" value="0" />
					<c:set var="count" value="0" />
					<c:forEach items="${cartProducts}" var="cartProduct">
						<jsp:include page="shopping_cart_item.jsp">
							<jsp:param value="${cartProduct.product.smallImage}" name="img" />
							<jsp:param value="${cartProduct.product.name }" name="name" />
							<jsp:param value="${cartProduct.product.price }" name="price" />
							<jsp:param value="${cartProduct.quantity }" name="quantity" />
							<jsp:param value="${cartProduct.id }" name="cartProductId" />
						</jsp:include>
						<c:set var="total"
							value="${total + cartProduct.quantity*cartProduct.product.price}"></c:set>
						<c:set var="count" value="${count + cartProduct.quantity}" />
					</c:forEach>
					<div class="row">
						<div class="col-xs-12">
							<h4>
								<strong>Total products: ${count}</strong>
							</h4>
						</div>
					</div>
					<div class="row">
						<div class="text-center">
							<div class="col-xs-10 col-md-3 pull-right">
								<button type="button" class=" btn btn-default btn-sm btn-block" id="btn-updateCart">
									Update cart</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">
								Total <strong>${total} $</strong>
							</h4>
						</div>
						<div class="col-xs-10 col-md-3">
							<a href="${pageContext.request.contextPath}/checkout"
								type="button" class="btn btn-success btn-block"> Checkout</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>