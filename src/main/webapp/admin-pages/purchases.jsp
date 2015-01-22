<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-lg-12">
		<table class="tablesorter table table-border" id="myTable">
			<thead>
				<tr>

					<th>Id</th>
					<th>Date created</th>
					<th>Date shipped</th>
					<th class="not-sortable">Verified</th>
					<th class="not-sortable">Completed</th>
					<th class="not-sortable">Canceled</th>
					<th>Customer name</th>
					<th>Customer address</th>
					<th class="not-sortable">Action</th>
				</tr>
			</thead>
			<c:forEach var="purchase" items="${purchases}">
				<tr class=" text-center">
					<td>${purchase.id}</td>
					<td>${purchase.dateCreated}</td>
					<td>${empty purchase.dateShipped?'Not shipped yet':purchase.dateShipped}</td>
					<td><span
						class=" glyphicon glyphicon-${purchase.verified?'ok':'remove' }"></span></td>
					<td><span
						class="glyphicon glyphicon-${purchase.completed?'ok':'remove' }"></span></td>
					<td><span
						class="glyphicon glyphicon-${purchase.canceled?'ok':'remove' }"></span></td>
					<td>${purchase.user.name}</td>
					<td>${purchase.shippingAddress}</td>
					<td><button class="btn btn-warning btn-block"
							onclick="getPurchase('${pageContext.request.contextPath}/admin/purchases/edit?id=${purchase.id}')">Edit</button>
				</tr>
			</c:forEach>
		</table>
		<br>
	</div>
</div>
<div class="row">
	<nav class="text-center">
		<ul class="pagination shadow">
			<c:if test="${page ne 1}">
				<li><a href="?page=${page - 1}"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
			</c:if>
			<c:forEach begin="1" end="${pageCount}" varStatus="status">
				<li class="${page == status.count? 'active':'' }"><a
					href="?page=${status.count}">${status.count}</a></li>
			</c:forEach>
			<c:if test="${page ne pageCount}">
				<li><a href="?page=${page + 1}"> <span aria-hidden="true">&raquo;</span>
						<span class="sr-only">Next</span>
				</a></li>
			</c:if>
		</ul>
	</nav>
</div>
<div id="modal-container"></div>

<script type="text/javascript">
		$(document).ready(function() {
			$("#myTable").tablesorter();
		});
		function getPurchase(url){
			$.get(url,function(modal){
				$("#modal-container").html(modal);
				$("#purchaseModal").modal("show");
			});
		}
	
	</script>