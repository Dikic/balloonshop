<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="${pageContext.request.contextPath}/signin"
	htmlEscape="true" method="POST" role="form" commandName="user">

	<div class="container-fluid">
		<div class="row">
			<div class="input-group">
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-envelope"></span></span>
				<form:input path="email" cssClass="form-control col-xs-12 col-md-4"
					placeholder="Email" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="input-group">
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-lock"></span></span>
				<form:password path="password" cssClass="form-control col-xs-12 col-md-4"
					placeholder="Password" />
			</div>
		</div>
		<br />
		<div class="row">

			<input type="submit" value="Sign in"
				class="btn btn-primary col-xs-12 col-md-4 col-md-offset-8">
		</div>
	</div>

</form:form>