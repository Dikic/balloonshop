<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form class="form-horizontal col-sm-9 jumbotron" role="form"
	method="post" commandName="user"
	action="${pageContext.request.contextPath}/profile">
	<div class="form-group">
		<label class="control-label col-sm-2">E-mail:</label>

		<div class="col-sm-10">
				<div class="form-control-static">${user.email}</div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Name:</label>

		<div class="col-sm-10">
			<form:input class="form-control" path="name" placeholder="Enter name" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Surname:</label>

		<div class="col-sm-10">
			<form:input class="form-control" path="surname"
				placeholder="Enter surname" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Address:</label>

		<div class="col-sm-10">
			<form:input class="form-control" path="address"
				placeholder="Enter address" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">City:</label>

		<div class="col-sm-10">
			<form:input class="form-control" path="city" placeholder="Enter city" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Zip:</label>

		<div class="col-sm-10">
			<form:input class="form-control" path="zip" placeholder="Enter zip" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Country:</label>

		<div class="col-sm-10">
			<form:input class="form-control" path="country"
				placeholder="Enter country" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="submit" class="btn btn-primary" value="Update"></input>
		</div>
	</div>
</form:form>