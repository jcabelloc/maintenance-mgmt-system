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
			<h3>Problem List</h3>
			<hr>
		</div>
		<div>
			<a href="addProblemForm" class="btn btn-primary" role="button">Add Problem</a>
			<br><br>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Problem Code</th>
						<th scope="col"> Description </th>
						<th scope="col"> State </th>
						<th scope="col">  </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${problems}" var="problem">
						<c:url var="updateLink" value="/problem/updateProblemForm">
							<c:param name="problemCode" value="${problem.problemCode}"/>
						</c:url>
						<c:url var="deleteLink" value="/problem/delete">
							<c:param name="problemCode" value="${problem.problemCode}"/>
						</c:url>
		    			<tr scope="row">
							<td> ${problem.problemCode}</td>
							<td> ${problem.description}</td>
							<td> ${problem.state}</td>
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