<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">
		<script>
  function loadWard()
	{
	  

		var zoneId=document.getElementById("zoneId");
		var xmlhttp;
		//alert("2222");
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		
				removeAllWard();
		
		xmlhttp.onreadystatechange = function() 
		{
			if (xmlhttp.readyState == 4)
			{
				var jsonObj = JSON.parse(xmlhttp.responseText);
				for(i=0 ; i < jsonObj.length ; i++)
				{
					var createOption=document.createElement("option");
					
					createOption.value=jsonObj[i].wardId;
					createOption.text=jsonObj[i].wardName;
					
					document.areaForm.wardId.options.add(createOption);
					
				}
			}
			else
			{
				loader();
			}
		}
		//alert("zzz is jj");
		xmlhttp.open("get", "${pageContext.request.contextPath}/AreaController?flag=loadWard&zoneId="+zoneId.value, true);
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
	
  
  function removeAllWard()
	{
	  var removeWard=document.areaForm.wardId.options.length;
		for(i=removeWard ; i>0 ; i-- )
		{
			document.areaForm.wardId.remove(i);
		}
	}

</script>
<title>ADD AREA</title>
<meta name="keywords" content="HTML5 Admin Template" />
<meta name="description"
	content="Porto Admin - Responsive HTML5 Template">
<meta name="author" content="okler.net">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Web Fonts  -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light"
	rel="stylesheet" type="text/css">

<!-- Vendor CSS -->
<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />

<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="assets/vendor/magnific-popup/magnific-popup.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />

<!-- Specific Page Vendor CSS -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap-fileupload/bootstrap-fileupload.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme.css" />

<!-- Skin CSS -->
<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">

<!-- Head Libs -->
<script src="assets/vendor/modernizr/modernizr.js"></script>
</head>
<body>
	<section class="body">

		<!-- start: header -->
		<jsp:include page="header.jsp" />
		<!-- end: header -->

		<div class="inner-wrapper">
			<!-- start: sidebar -->
			<jsp:include page="menu.jsp" />
			<!-- end: sidebar -->
			<form action="<%=request.getContextPath()%>/AreaController" method="POST" name="areaForm">
				<section role="main" class="content-body">
					<jsp:include page="page_header.jsp" />





					<!-- hinal block start -->
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#" class="panel-action panel-action-toggle"
								data-panel-toggle></a> <a href="#"
								class="panel-action panel-action-dismiss" data-panel-dismiss></a>
						</div>

						<h2 class="panel-title">ADD AREA</h2>
						<!-- <p class="panel-subtitle">
											Basic validation will display a label with the error after the form control.
										</p> -->
					</header>


					<div class="panel-body">
						<div class="form-group">
							<label class="col-md-3 control-label" for="inputSuccess">Select
								Zone</label>
							<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
							<div class="col-md-6">
								<select name="zone" id="zoneId" onchange="loadWard()" class="form-control mb-md">
								<option>Choose One</option>
									<c:forEach items="${sessionScope.zone }" var="x">
										<option value="${x.zoneId }">${x.zoneName }</option>
									</c:forEach>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label" for="inputSuccess">Select
								Ward</label>
							<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
							<div class="col-md-6">
								<select name="wardId" id="wardId" data-rule-required="true"
									class="form-control">
									<option>Choose One</option>
									<%-- <c:forEach items="${sessionScope.ward }" var="x">
										<option value="${x.wardId }">${x.wardName }</option>
									</c:forEach> --%>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Add Area <span
								class="required"></span></label>
							<div class="col-md-6">
								<input type="text" name="area" class="form-control"
									placeholder="Add Area" required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label" for="textareaAutosize">Area
								Description</label>
							<div class="col-md-6">
								<textarea name="area_des" class="form-control" rows="3"
									id="textareaAutosize" data-plugin-textarea-autosize></textarea>
							</div>
						</div>



					</div>
					<footer class="panel-footer">
						<div class="row">
							<input type="hidden" name="flag" value="insert">
							<div class="col-sm-9 col-sm-offset-3">

								<button class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>
					</footer>
				</section>
			</form>
		</div>

		<!-- hinal block end -->




		<!-- end: page -->
	</section>
	</div>


	</section>

	<!-- Vendor -->
	<script src="assets/vendor/jquery/jquery.js"></script>
	<script
		src="assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
	<script src="assets/vendor/nanoscroller/nanoscroller.js"></script>
	<script
		src="assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="assets/vendor/magnific-popup/magnific-popup.js"></script>
	<script src="assets/vendor/jquery-placeholder/jquery.placeholder.js"></script>

	<!-- Specific Page Vendor -->
	<script src="assets/vendor/jquery-autosize/jquery.autosize.js"></script>
	<script
		src="assets/vendor/bootstrap-fileupload/bootstrap-fileupload.min.js"></script>

	<!-- Theme Base, Components and Settings -->
	<script src="assets/javascripts/theme.js"></script>

	<!-- Theme Custom -->
	<script src="assets/javascripts/theme.custom.js"></script>

	<!-- Theme Initialization Files -->
	<script src="assets/javascripts/theme.init.js"></script>

</body>
</html>