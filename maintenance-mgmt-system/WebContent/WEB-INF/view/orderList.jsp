<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<link rel="import" href="${pageContext.request.contextPath}/resources/html/bootstrap.html">
</head>
<body>
	<%@ include file = "header.jsp" %>
	<div class="container">
		<div>
			<h3>Work Order List</h3>
			<hr>
		</div>
		<div>
			<a href="addOrderForm" class="btn btn-primary" role="button">Add Work Order</a>
			<br><br>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Order Number </th>
						<th scope="col"> Creation Date </th>
						<th scope="col"> Resident Name </th>
						<th scope="col"> Apartment Number </th>
						<th scope="col"> Priority </th>
						<th scope="col"> Issue </th>
						<th scope="col"> Status </th>
						<th scope="col">  </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="order">
						<c:url var="detailLink" value="/order/detail">
							<c:param name="orderId" value="${order.orderId}"/>
						</c:url>
						<c:url var="updateLink" value="/order/updateOrderForm">
							<c:param name="orderId" value="${order.orderId}"/>
						</c:url>
						<c:url var="deleteLink" value="/order/delete">
							<c:param name="orderId" value="${order.orderId}"/>
						</c:url>
		    			<tr scope="row">
							<td> ${order.orderId}</td>
							<td> ${order.registeredDate}</td>
							<td> ${order.resident.firstName} ${order.resident.lastName} </td>
							<td> ${order.apartment.number}</td>
							<td> ${order.priority}</td>
							<td> ${order.issue.description}</td>
							<td> ${order.status}</td>
							<td> 
								<a href='<c:out value="${detailLink}" />'><i class="fas fa-info-circle"></i></a>
								<span>&nbsp&nbsp</span>
								<a href='<c:out value="${updateLink}" />'><i class="fas fa-edit"></i></a>
								<span>&nbsp&nbsp</span>
								<a href='<c:out value="${deleteLink}"/>' 
								   onclick="return confirm('Are you sure you want to delete this item?');"> 
								   <i class="fas fa-trash-alt"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>