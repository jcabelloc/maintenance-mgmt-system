<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
	
</head>
<body>

	<div class="container">
		<br><br>
		<form:form action="saveCustomer" modelAttribute="apartment" method="POST">
		  <div class="form-group row">
		    <label for="apartmentId" class="col-sm-2 col-form-label">Apartment Number</label>
		    <div class="col-sm-10">
		      <form:input path="apartmentId" type="number" class="form-control" id="apartmentId"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="numberOfRooms" class="col-sm-2 col-form-label">Number of Rooms</label>
		    <div class="col-sm-10">
		    	<form:select path="numberOfRooms" class="form-control" id="numberOfRooms">
             		<form:option value="0" label="--Please Select"/>
             		<form:options items="${apartment.roomChoices}" />
            	</form:select>		      
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="block" class="col-sm-2 col-form-label">Block</label>
		    <div class="col-sm-10">
		      	<form:select path="block" class="form-control" id="block">
              		<form:option value="-" label="--Please Select"/>
              		<form:options items="${blocks}" />
          		</form:select>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="floor" class="col-sm-2 col-form-label">Floor</label>
		    <div class="col-sm-10">
		   		<form:select path="floor" class="form-control" id="floor">
             		<form:option value="0" label="--Please Select"/>
             		<form:options items="${apartment.floorChoices}" />
            	</form:select>	
		    </div>
		  </div>
		  <div class="form-group row">
		    <div class="col-sm-10">
		      <button type="submit" class="btn btn-primary">Save</button>
		    </div>
		  </div>
		</form:form>	
	
	</div>

  
  	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js" ></script>
	<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>

</html>