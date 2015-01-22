<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modal fade" id="purchaseModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header modal-header-warning">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Edit Purchase</h4>
			</div>
			<div class="modal-body">
				<div class="container-fluid">
					<form:form class="form-horizontal" role="form"
						method="post" commandName="purchase"
						action="${pageContext.request.contextPath}/admin/purchases/edit">
						<form:hidden path="id" />
						<div class="form-group">
							<label class="control-label col-sm-3">Date shipped:</label>

							<div class="col-sm-9">
								<input type="checkbox" name="shipped" value="${purchase.dateShipped}">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">Completed:</label>

							<div class="col-sm-9">
								<form:checkbox  path="completed" value="${purchase.completed}"/>
							</div>
						</div>
						<div class="form-group">
							<label class=" control-label col-sm-3">Canceled:</label>

							<div class="col-sm-9">
								<form:checkbox path="canceled" value="${purchase.canceled}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">Shipping Address:</label>

							<div class="col-sm-9">
								<form:input class="form-control" path="shippingAddress"
									placeholder="Enter address" value="${purchase.shippingAddress}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">Comments:</label>
							<div class="col-sm-9">
								<form:textarea class="form-control" path="comments"
									placeholder="Enter comments..." value="${purchase.comments}"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<input type="submit" class="btn btn-danger btn-block" value="Edit"></input>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->