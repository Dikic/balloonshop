<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="maxCharsTitle" value="10"></c:set>
<c:set var="maxCharsDesc" value="30"></c:set>

<div class="col-lg-3 col-sm-12 col-xs-12 col-md-6">
	<div class="panel panel-warning shadow">
		<div class="panel panel-heading">
			<h3>${fn:length(param.title) gt maxCharsTitle ? (fn:substring(param.title, 0 ,maxCharsTitle)) : param.title }
				${fn:length(param.title) gt maxCharsTitle ?'...':''}</h3>
		</div>
		<div class="panel-body">
			<img src="${pageContext.request.contextPath}/images/${param.image}"
				class="img img-thumbnail img-circle img-responsive text-center" />
			<h5>
				${fn:length(param.description) gt maxCharsDesc ?  (fn:substring(param.description,0,maxCharsDesc)) : param.description}
				${fn:length(param.description) gt maxCharsDesc ? '...':''} <small>
					<a href="#">(View details)</a>
				</small>
			</h5>
			<h4>${param.price}&dollar;</h4>
			<a href="#">Add to shopping cart</a>
		</div>
	</div>
</div>