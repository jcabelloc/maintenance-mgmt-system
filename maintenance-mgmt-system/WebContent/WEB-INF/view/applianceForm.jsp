<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="import" href="${pageContext.request.contextPath}/resources/html/bootstrap.html">
	<script type="text/javascript">
		var popupWindow=null;

		function focusPopup() {
			if(popupWindow && !popupWindow.closed) { 
				popupWindow.focus(); 
			} 
		}
		function listApartment()
		{ 
			document.onmousedown = focusPopup; 
			document.onkeyup = focusPopup;
			document.onmousemove = focusPopup; 
			document.onclick = focusPopup; 
			popupWindow =window.open('${pageContext.request.contextPath}/apartment/search',"_blank","directories=no, status=no, menubar=no, scrollbars=yes, resizable=no,width=800, height=480,top=300,left=300");
		}
	</script>
</head>
<body>

	<div class="container">
		<br><br>
		<form:form action="saveAppliance" modelAttribute="appliance" method="POST">
		  <form:hidden path="applianceId"/>
 		  <div class="form-group row">
		    <label for="apartmentNumber" class="col-sm-2 col-form-label">Apartment Number</label>
		    <div class="col-sm-9">
		      	<form:input readonly="true" path="apartment.number" type="text" class="form-control" id="apartmentNumber" />
		    </div>
		    <div class="col-sm-1">
		    	<button type = "button" class="form-control" onclick='javascript:listApartment()'> <i class="fas fa-search" ></i> </button>
		    </div>
		  </div>

		  <div class="form-group row">
		    <label for="serialNumber" class="col-sm-2 col-form-label">Serial Number</label>
		    <div class="col-sm-10">
		      	<form:input path="serialNumber" type="text" class="form-control" id="serialNumber"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="type" class="col-sm-2 col-form-label">Type</label>
		    <div class="col-sm-10">
		      	<form:input path="type" type="text" class="form-control" id="type"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="brand" class="col-sm-2 col-form-label">Brand</label>
		    <div class="col-sm-10">
		      	<form:input path="brand" type="text" class="form-control" id="brand"/>
		    </div>
		  </div>
		   <div class="form-group row">
		    <label for="purchaseDate" class="col-sm-2 col-form-label">Purchase Date</label>
		    <div class="col-sm-10">
		      	<form:input path="purchaseDate" type="date" class="form-control" id="purchaseDate"/>
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