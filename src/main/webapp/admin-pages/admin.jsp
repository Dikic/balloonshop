<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-md-4">
			<jsp:include page="admin_block.jsp">
				<jsp:param value="primary" name="type" />
				<jsp:param value="Orders" name="title" />
				<jsp:param value="usd" name="icon" />
				<jsp:param value="123" name="count"/>
				<jsp:param value="orders" name="description"/>
			</jsp:include>
		</div>
	</div>
</div>