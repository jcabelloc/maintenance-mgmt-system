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
			<h3>Issue Search</h3>
			<hr>
		</div>
		<div>
			<form:form class="form-inline" action="search" method="GET" >
			  <div class="form-group mb-2">
			    <label for="issueDescription" class="">Issue Description</label>
			  </div>
			  <div class="form-group mx-sm-3 mb-2">
			    <input type="text" class="form-control" id="issueDescription" name="issueDescription" placeholder="">
			  </div>
			  <button type="submit" class="btn btn-primary mb-2">Search</button>
			</form:form>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Issue Code </th>
						<th scope="col"> Description </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${issues}" var="issue">
		    			<tr scope="row">
							<td> <a href="" id="${issue.issueCode}" onclick="window.opener.document.getElementById('issueCode').value = this.id;  window.opener.document.getElementById('issueDescription').value = '${issue.description}'; window.close();"  >${issue.issueCode}</a></td>
							<td> ${issue.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>