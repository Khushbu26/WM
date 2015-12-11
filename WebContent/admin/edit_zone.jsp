<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">

<title>ADD ZONE</title>
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
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<!-- start: header -->
		<jsp:include page="header.jsp"/>
		<!-- end: header -->

		<div class="inner-wrapper">
			<!-- start: sidebar -->
			<jsp:include page="menu.jsp"/>
			<!-- end: sidebar -->
			<c:forEach items="${sessionScope.editzone }" var="x">	
				<form action="<%=request.getContextPath()%>/ZoneController" method="post">
			<section role="main" class="content-body">
				<jsp:include page="page_header.jsp"/>
								<!-- hinal block start -->
				<header class="panel-heading">
					<div class="panel-actions">
						<a href="#" class="panel-action panel-action-toggle"
							data-panel-toggle></a> <a href="#"
							class="panel-action panel-action-dismiss" data-panel-dismiss></a>
					</div>

					<h2 class="panel-title">ADD ZONE</h2>
					<!-- <p class="panel-subtitle">
											Basic validation will display a label with the error after the form control.
										</p> -->
				</header>


				<div class="panel-body">
					<div class="form-group">
						<label class="col-md-3 control-label">Add Zone <span
							class="required"></span></label>
						<div class="col-md-6">
							<input type="text" value="${x.zoneName }" name="zone" class="form-control"
								placeholder="Add Zone" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="textareaAutosize">Zone Description</label>
						<div class="col-md-6">
							<textarea name="zone_des" class="form-control" rows="3" id="textareaAutosize"
								data-plugin-textarea-autosize>${x.zoneDes }</textarea>
						</div>
					</div>



				</div>
				
				<footer class="panel-footer">
				<input type="hidden" name="id" value="${x.zoneId }">
				<input type="hidden" name="flag" value="update">
					<div class="row">
						<div class="col-sm-9 col-sm-offset-3">
						
							<button class="btn btn-primary">Update</button>
							<button type="reset" class="btn btn-default">Reset</button>
						</div>
					</div>
				</footer>
			</section>
			</form>
			</c:forEach>
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