<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-lg-10 col-lg-offset-2">
		<h3>Our products</h3>
	</div>
</div>
<div class="row row-md-height">
	<c:forEach items="${products}" var="product" varStatus="status">

		<jsp:include page="product_block.jsp">
			<jsp:param value="${product.name}" name="title" />
			<jsp:param value="${product.largeImage}" name="image" />
			<jsp:param value="${product.description}" name="description" />
			<jsp:param value="${product.price}" name="price" />
			<jsp:param value="${product.id }" name="id" />
		</jsp:include>
		<c:if test="${status.count mod 4 == 0}">
</div>
<div class="row">
	</c:if>
	</c:forEach>
</div>
<div class="row">
	<nav class="text-center">
		<ul class="pagination shadow">
			<li><a href="#"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span></a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#"> <span aria-hidden="true">&raquo;</span> <span
					class="sr-only">Next</span>
			</a></li>
		</ul>
	</nav>
</div>