<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
	
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
		    			<tr scope="row">
							<td> ${apartment.apartmentId}</td>
							<td> ${apartment.numberOfRooms}</td>
							<td> ${apartment.block}</td>
							<td> ${apartment.floor}</td>
							<td> 
								<a href=""><i class="fas fa-edit"></i></a>
								<span>&nbsp&nbsp</span>
								<a href=""><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>