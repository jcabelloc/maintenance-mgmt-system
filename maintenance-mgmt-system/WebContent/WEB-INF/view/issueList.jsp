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
			<h3>Issue List</h3>
			<hr>
		</div>
		<div>
			<a href="addIssueForm" class="btn btn-primary" role="button">Add Issue</a>
			<br><br>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Issue Code</th>
						<th scope="col"> Description </th>
						<th scope="col"> State </th>
						<th scope="col">  </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${issues}" var="issue">
						<c:url var="updateLink" value="/issue/updateIssueForm">
							<c:param name="issueCode" value="${issue.issueCode}"/>
						</c:url>
						<c:url var="deleteLink" value="/issue/delete">
							<c:param name="issueCode" value="${issue.issueCode}"/>
						</c:url>
		    			<tr scope="row">
							<td> ${issue.issueCode}</td>
							<td> ${issue.description}</td>
							<td> ${issue.state}</td>
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