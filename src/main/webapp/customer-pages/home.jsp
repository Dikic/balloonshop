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
			<c:if test="${page ne 1}">
				<li><a href="?page=${page - 1}&search=${search}"> <span
						aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span></a></li>
			</c:if>
			<c:forEach begin="1" end="${pageCount}" varStatus="status">
				<li class="${page == status.count? 'active':'' }"><a
					href="?page=${status.count}&search=${search}">${status.count}</a></li>
			</c:forEach>
			<c:if test="${page ne pageCount}">
				<li><a href="?page=${page + 1}&search=${search}"> <span
						aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
				</a></li>
			</c:if>
		</ul>
	</nav>
</div>