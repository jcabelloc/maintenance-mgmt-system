<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<link rel="import" href="${pageContext.request.contextPath}/resources/html/bootstrap.html">
</head>
<body>
	<div class="container">
		<div>
			<h3>Appliance List</h3>
			<hr>
		</div>
		<div>
			<a href="addApplianceForm" class="btn btn-primary" role="button">Add Appliance</a>
			<br><br>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Apartment Number </th>
						<th scope="col"> Serial Number </th>
						<th scope="col"> Type </th>
						<th scope="col"> Brand </th>
						<th scope="col"> Purchase Date </th>
						<th scope="col"> Description </th>
						<th scope="col"> Status </th>
						<th scope="col">  </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${appliances}" var="appliance">
						<c:url var="updateLink" value="/appliance/updateApplianceForm">
							<c:param name="applianceId" value="${appliance.applianceId}"/>
						</c:url>
						<c:url var="deleteLink" value="/appliance/delete">
							<c:param name="applianceId" value="${appliance.applianceId}"/>
						</c:url>
		    			<tr scope="row">
							<td> ${appliance.apartment.number}</td>
							<td> ${appliance.serialNumber}</td>
							<td> ${appliance.type}</td>
							<td> ${appliance.brand}</td>
							<td> ${appliance.purchaseDate}</td>
							<td> ${appliance.description}</td>
							<td> ${appliance.status}</td>
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