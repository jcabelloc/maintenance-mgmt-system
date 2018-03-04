<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="import" href="${pageContext.request.contextPath}/resources/html/bootstrap.html">
</head>
<body>
	<%@ include file = "header.jsp" %>
	<div class="container">
		<br><br>
		<form:form action="saveProblem" modelAttribute="problem" method="POST">
		  <div class="form-group row">
		    <label for="problemCode" class="col-sm-2 col-form-label">Problem Code</label>
		    <div class="col-sm-10">
		      <form:input readonly="true" path="problemCode" type="text" class="form-control" id="problemCode"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="description" class="col-sm-2 col-form-label">Description</label>
		    <div class="col-sm-10">
		      <form:input path="description" type="text" class="form-control" id="description"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <div class="col-sm-10">
		      <button type="submit" class="btn btn-primary">Save</button>
		    </div>
		  </div>
		</form:form>	
	
	</div>
</body>

</html>