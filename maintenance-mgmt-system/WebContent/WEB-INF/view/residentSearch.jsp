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
			<h3>Resident Search</h3>
			<hr>
		</div>
		<div>
			<form:form class="form-inline" action="search" method="GET" >
			  <div class="form-group mb-2">
			    <label for="residentName" class="">Resident Name</label>
			  </div>
			  <div class="form-group mx-sm-3 mb-2">
			    <input type="text" class="form-control" id="residentName" name="residentName" placeholder="">
			  </div>
			  <button type="submit" class="btn btn-primary mb-2">Search</button>
			</form:form>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Resident Id </th>
						<th scope="col"> First Name </th>
						<th scope="col"> Last Name </th>
						<th scope="col"> Email </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${residents}" var="resident">
		    			<tr scope="row">
							<td> <a href="" id="${resident.residentId}" onclick="window.opener.document.getElementById('residentId').value = this.id; window.opener.document.getElementById('residentName').value = '${resident.firstName} ${resident.lastName} ';  window.close();"  >${resident.residentId}</a></td>
							<td> ${resident.firstName}</td>
							<td> ${resident.lastName}</td>
							<td> ${resident.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>