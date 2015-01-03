<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<div class="panel panel-${param.type}">
	<div class="panel-heading">
		<h3 class="panel-title">${param.title}</h3>
	</div>
	<div class="panel-body">
			<div class="col-xs-5 text-center">
			<h1 class="glyphicon glyphicon-${param.icon}"></h1>
			<p><a href="#">full details!</a></p>
			</div>
			<div class="col-xs-7 text-right">
				<h4>${param.description } <span class="label label-primary">${param.count }</span></h4>
				<h4>${param.description } <span class="label label-danger">${param.count }</span></h4>
				<h4>${param.description } <span class="label label-warning">${param.count }</span></h4>
			</div>
	</div>
</div>