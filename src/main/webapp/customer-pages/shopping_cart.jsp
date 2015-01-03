<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
					<div class="row">
						<div class="col-xs-2">
							<img class="img-responsive"
								src="${pageContext.request.contextPath}/images/logo.png">
						</div>
						<div class="col-xs-4">
							<h4 class="product-name">
								<strong>Balloon name</strong>
							</h4>

						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h6>
									<strong>cena <span class="text-muted">x</span></strong>
								</h6>
							</div>
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" value="1">
							</div>
							<div class="col-xs-2">
								<button type="button" class="btn btn-link btn-xs">
									<span class="glyphicon glyphicon-trash"> </span>
								</button>
							</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="text-center">
							<div class="col-xs-10 col-md-3 pull-right">
								<button type="button" class=" btn btn-default btn-sm btn-block">
									Update cart</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">
								Total <strong>$cena</strong>
							</h4>
						</div>
						<div class="col-xs-10 col-md-3">
							<a href="${pageContext.request.contextPath}/checkout" type="button" class="btn btn-success btn-block">
								Checkout</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>