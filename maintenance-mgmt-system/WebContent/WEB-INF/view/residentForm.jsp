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
	<%@ include file = "header.jsp" %>
	<div class="container">
		<br><br>
		<form:form action="saveResident" modelAttribute="resident" method="POST">
		  <form:hidden path="residentId"/>
		  <div class="form-group row">
		    <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
		    <div class="col-sm-10">
		      	<form:input path="firstName" type="text" class="form-control" id="firstName"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
		    <div class="col-sm-10">
		      	<form:input path="lastName" type="text" class="form-control" id="lastName"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="userName" class="col-sm-2 col-form-label">User Name</label>
		    <div class="col-sm-10">
		      	<form:input path="userName" type="text" class="form-control" id="userName"/>
		    </div>
		  </div>
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
		    <label for="email" class="col-sm-2 col-form-label">Email</label>
		    <div class="col-sm-10">
		      	<form:input path="email" type="email" class="form-control" id="email" placeholder="my_email@example.com"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="phoneNumber" class="col-sm-2 col-form-label">Phone Number</label>
		    <div class="col-sm-10">
		      	<form:input path="phoneNumber" type="tel" class="form-control" id="phoneNumber" placeholder="(XXX) YYY-ZZZZ"/>
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