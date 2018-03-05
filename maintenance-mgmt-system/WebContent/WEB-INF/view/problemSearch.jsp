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
			<h3>Problem Search</h3>
			<hr>
		</div>
		<div>
			<form:form class="form-inline" action="search" method="GET" >
			  <div class="form-group mb-2">
			    <label for="problemDescription" class="">Problem Description</label>
			  </div>
			  <div class="form-group mx-sm-3 mb-2">
			    <input type="text" class="form-control" id="problemDescription" name="problemDescription" placeholder="">
			  </div>
			  <button type="submit" class="btn btn-primary mb-2">Search</button>
			</form:form>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Problem Code </th>
						<th scope="col"> Description </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${problems}" var="problem">
		    			<tr scope="row">
							<td> <a href="" id="${problem.problemCode}" onclick="window.opener.document.getElementById('problemCode').value = this.id; window.close();"  >${problem.problemCode}</a></td>
							<td> ${problem.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>