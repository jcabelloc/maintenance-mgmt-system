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
		function listResident()
		{ 
			document.onmousedown = focusPopup; 
			document.onkeyup = focusPopup;
			document.onmousemove = focusPopup; 
			document.onclick = focusPopup; 
			popupWindow =window.open('${pageContext.request.contextPath}/resident/search',"_blank","directories=no, status=no, menubar=no, scrollbars=yes, resizable=no,width=800, height=480,top=300,left=300");
		}
		function listIssue()
		{ 
			document.onmousedown = focusPopup; 
			document.onkeyup = focusPopup;
			document.onmousemove = focusPopup; 
			document.onclick = focusPopup; 
			popupWindow =window.open('${pageContext.request.contextPath}/issue/search',"_blank","directories=no, status=no, menubar=no, scrollbars=yes, resizable=no,width=800, height=480,top=300,left=300");
		}
	</script>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<div class="container">
		<br><br>
		<form:form action="saveOrder" modelAttribute="order" method="POST">
		  <div class="form-group row">
		    <label for="orderId" class="col-sm-2 col-form-label">Order Number</label>
		    <div class="col-sm-10">
		      	<form:input readonly="true" path="orderId" type="int" class="form-control" id="orderId"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="registeredDate" class="col-sm-2 col-form-label">Creation Date</label>
		    <div class="col-sm-10">
		      	<form:input readonly="true" path="registeredDate" type="date" class="form-control" id="registeredDate"/>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="residentName" class="col-sm-2 col-form-label">Resident Name</label>
		    <div class="col-sm-9">
		      	<input readonly value="${order.resident.firstName} ${order.resident.lastName}" type="text" class="form-control" id="residentName"/>
		    </div>
		    <div class="col-sm-1">
		    	<button type = "button" class="form-control" onclick='javascript:listResident()'> <i class="fas fa-search" ></i> </button>
		    </div>
		    <form:hidden path="resident.residentId" id="residentId"/>
		  </div>
		  <div class="form-group row">
		    <label for="priority" class="col-sm-2 col-form-label">Priority</label>
		    <div class="col-sm-10">
		    	<form:select path="priority" class="form-control" id="priority">
             		<form:option value="0" label="--Please Select"/>
             		<form:options items="${order.priorities}" />
            	</form:select>		      
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="issueDescription" class="col-sm-2 col-form-label">Issue</label>
		    <div class="col-sm-9">
		      	<input readonly value="${order.issue.description}" type="text" class="form-control" id="issueDescription"/>
		    </div>
		    <div class="col-sm-1">
		    	<button type = "button" class="form-control" onclick='javascript:listIssue()'> <i class="fas fa-search" ></i> </button>
		    </div>
		    <form:hidden path="issue.issueCode" id="issueCode"/>
		  </div>
		  <div class="form-group row">
		    <label for="issueComment" class="col-sm-2 col-form-label">Comment</label>
		    <div class="col-sm-10">
		      	<form:textarea path="issueComment" rows="5" cols="30" class="form-control" id="issueComment"/>
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