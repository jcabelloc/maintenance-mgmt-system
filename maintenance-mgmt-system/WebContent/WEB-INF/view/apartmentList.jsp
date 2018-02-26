<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<link rel="import" href="${pageContext.request.contextPath}/resources/html/bootstrap.html">
</head>
<body>
	<div class="container">
		<div>
			<h3>Apartment List</h3>
			<hr>
		</div>
		<div>
			<a href="addApartmentForm" class="btn btn-primary" role="button">Add Apartment</a>
			<br><br>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Apartment Number </th>
						<th scope="col"> Number of Rooms </th>
						<th scope="col"> Block </th>
						<th scope="col"> Floor </th>
						<th scope="col">  </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${apartments}" var="apartment">
						<c:url var="updateLink" value="/apartment/updateApartmentForm">
							<c:param name="apartmentId" value="${apartment.apartmentId}"/>
						</c:url>
						<c:url var="deleteLink" value="/apartment/delete">
							<c:param name="apartmentId" value="${apartment.apartmentId}"/>
						</c:url>
		    			<tr scope="row">
							<td> ${apartment.number}</td>
							<td> ${apartment.numberOfRooms}</td>
							<td> ${apartment.block}</td>
							<td> ${apartment.floor}</td>
							<td> 
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