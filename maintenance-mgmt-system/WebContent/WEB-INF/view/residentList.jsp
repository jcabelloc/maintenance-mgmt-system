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
			<h3>Resident List</h3>
			<hr>
		</div>
		<div>
			<a href="addResidentForm" class="btn btn-primary" role="button">Add Resident</a>
			<br><br>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> First Name </th>
						<th scope="col"> Last Name </th>
						<th scope="col"> User Name </th>
						<th scope="col"> Apartment </th>
						<th scope="col"> Email </th>
						<th scope="col"> Phone Number</th>
						<th scope="col"> Status </th>
						<th scope="col">  </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${residents}" var="resident">
						<c:url var="updateLink" value="/resident/updateResidentForm">
							<c:param name="residentId" value="${resident.residentId}"/>
						</c:url>
						<c:url var="deleteLink" value="/resident/delete">
							<c:param name="residentId" value="${resident.residentId}"/>
						</c:url>
		    			<tr scope="row">
							<td> ${resident.firstName}</td>
							<td> ${resident.lastName}</td>
							<td> ${resident.userName}</td>
							<td> ${resident.apartment.number}</td>
							<td> ${resident.email}</td>
							<td> ${resident.phoneNumber}</td>
							<td> ${resident.status}</td>
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