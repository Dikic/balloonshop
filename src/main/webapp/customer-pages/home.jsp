<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row row-md-height">
	<c:forEach items="${products}" var="product" varStatus="status">

		<jsp:include page="product_block.jsp">
			<jsp:param value="${product.name}" name="title" />
			<jsp:param value="${product.largeImage}" name="image" />
			<jsp:param value="${product.description}" name="description" />
			<jsp:param value="${product.price}" name="price" />
		</jsp:include>
		<c:if test="${status.count mod 4 == 0}">
</div>
<div class="row">
</c:if>
</c:forEach>
</div>