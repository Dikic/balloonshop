<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="sing-in-modal" tabindex="-1" role="dialog"
	aria-labelledby="sign-in-label" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header modal-header-primary">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="sign-in-label">Sign in</h4>
			</div>
			<div class="modal-body">

				<form:form action="${pageContext.request.contextPath}/signin" htmlEscape="true" method="POST"
					role="form" commandName="user">

					<div class="container-fluid">
						<div class="row">
							<div class="input-group">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-envelope"></span></span>
								<form:input path="email" cssClass="form-control col-xs-12"
									placeholder="Email" />
							</div>
						</div>
						<br />
						<div class="row">
							<div class="input-group">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-lock"></span></span>
								<form:password path="password" cssClass="form-control col-xs-12"
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

			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->