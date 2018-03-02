<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<link rel="import" href="${pageContext.request.contextPath}/resources/html/bootstrap.html">
</head>
<body>
	<div class="container">
		<br><br>
		<div>
			<h3>Apartment Search</h3>
			<hr>
		</div>
		<div>
			<form:form class="form-inline" action="search" method="GET" >
			  <div class="form-group mb-2">
			    <label for="apartmentNumber" class="">Apartment Number</label>
			  </div>
			  <div class="form-group mx-sm-3 mb-2">
			    <input type="number" class="form-control" id="apartmentNumber" name="apartmentNumber" placeholder="">
			  </div>
			  <button type="submit" class="btn btn-primary mb-2">Search</button>
			</form:form>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Apartment Number </th>
						<th scope="col"> Number of Rooms </th>
						<th scope="col"> Block </th>
						<th scope="col"> Floor </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${apartments}" var="apartment">
		    			<tr scope="row">
							<td> <a href="" id="${apartment.number}" onclick="window.opener.document.getElementById('apartmentNumber').value = this.id; window.close();"  >${apartment.number}</a></td>
							<td> ${apartment.numberOfRooms}</td>
							<td> ${apartment.block}</td>
							<td> ${apartment.floor}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>