<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="jumbotron">
	<c:if test="${not user.enabled }">
		<h2 class="text-danger">Please verify you account before doing
			transactions.</h2>
	</c:if>
	<c:if test="${user.enabled }">

		<form:form class="form-horizontal" role="form"
			action="${pageContext.request.contextPath}/checkout"
			commandName="user" method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2">First name:</label>

				<div class="col-sm-10">
					<form:input path="name" class="form-control" id="name"
						placeholder="Enter name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Last name:</label>

				<div class="col-sm-10">
					<form:input path="surname" class="form-control" id="surname"
						placeholder="Enter surname" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>

				<div class="col-sm-10">
					<form:input path="email" type="email" class="form-control"
						id="email" placeholder="Enter email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Shipping address:</label>

				<div class="col-sm-10">
					<form:input path="address" class="form-control" id="address"
						placeholder="Enter shipping address" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">City:</label>

				<div class="col-sm-10">
					<form:input path="city" type="text" class="form-control" id="city"
						placeholder="Enter your city" />
				</div>
			</div>
			<div class="form-group">
				<div class="row col-sm-offset-1">
					<div class="col-sm-6">
						<label class="control-label col-sm-2">Zip:</label>

						<div class="col-sm-10">
							<form:input path="zip" type="text" class="form-control" id="zip"
								placeholder="Zip number" />
						</div>
					</div>
					<div>
						<div class="col-sm-6">
							<label class="control-label col-sm-2">Country:</label>

							<div class="col-sm-10">
								<form:input path="country" type="text" class="form-control"
									id="country" placeholder="Your country" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Credit card:</label>

				<div class="col-sm-10">
					<input name="cardNumber" class="form-control"
						placeholder="Enter your credit card number" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Expire date:</label>

				<div class="col-md-3 col-sm-10">
					<input type="text" name="dateExpire" class="form-control"
						placeholder="Enter expire date of card" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Proceed to
						payment</button>
				</div>
			</div>
		</form:form>

	</c:if>
</div>