<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="maxCharsTitle" value="10"></c:set>
<c:set var="maxCharsDesc" value="30"></c:set>

<div class="col-lg-3 col-sm-12 col-xs-12 col-md-6">
	<div class="panel panel-warning shadow">
		<div class="panel panel-heading">
			<h3 class="no-wrap">${param.title }</h3>
		</div>
		<div class="panel-body">
			<img src="${pageContext.request.contextPath}/images/${param.image}"
				class="img img-thumbnail img-circle img-responsive img-static" />
			<h5>
				${fn:length(param.description) gt maxCharsDesc ?  (fn:substring(param.description,0,maxCharsDesc)) : param.description}
				${fn:length(param.description) gt maxCharsDesc ? '...':''} <small>
					<a href="${pageContext.request.contextPath}/details/${param.id}">(View
						details)</a>
				</small>
			</h5>

		</div>
		<div class="panel-footer">
			<h4>${param.price}&dollar;</h4>
			<a href="${pageContext.request.contextPath}/add-to-cart/${param.id}">Add
				to shopping cart</a>
		</div>
	</div>
</div>