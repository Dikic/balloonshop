<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<div class="panel panel-${param.type}">
	<div class="panel-heading">
		<h3 class="panel-title">${param.title}</h3>
	</div>
	<div class="panel-body static-height">
			<p>There are total ${param.count} ${param.title}.</p>
	</div>
	<div class="panel-footer"><a href="${pageContext.request.contextPath}/admin/${param.link}">See this in context</a></div>
</div>