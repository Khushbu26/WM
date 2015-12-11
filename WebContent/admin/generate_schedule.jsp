<%@page import="controller.ScheduleController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">

<title>Advanced Forms | Porto Admin - Responsive HTML5 Template
	1.4.1</title>
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
	href="assets/vendor/jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet" href="assets/vendor/select2/select2.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-multiselect/bootstrap-multiselect.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-tagsinput/bootstrap-tagsinput.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-colorpicker/css/bootstrap-colorpicker.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-timepicker/css/bootstrap-timepicker.css" />
<link rel="stylesheet" href="assets/vendor/dropzone/css/basic.css" />
<link rel="stylesheet" href="assets/vendor/dropzone/css/dropzone.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-markdown/css/bootstrap-markdown.min.css" />
<link rel="stylesheet" href="assets/vendor/summernote/summernote.css" />
<link rel="stylesheet"
	href="assets/vendor/summernote/summernote-bs3.css" />
<link rel="stylesheet"
	href="assets/vendor/codemirror/lib/codemirror.css" />
<link rel="stylesheet" href="assets/vendor/codemirror/theme/monokai.css" />

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
	<section class="body"> <!-- start: header --> <jsp:include
		page="header.jsp" /> <!-- end: header -->

	<div class="inner-wrapper">
		<!-- start: sidebar -->
		<jsp:include page="menu.jsp" />
		<!-- end: sidebar -->

		<section role="main" class="content-body"> <jsp:include
			page="page_header.jsp" /> <!-- start: page -->
		<div class="row">
			<div class="col-lg-12"></div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<section class="panel"> <header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="panel-action panel-action-toggle"
						data-panel-toggle></a> <a href="#"
						class="panel-action panel-action-dismiss" data-panel-dismiss></a>
				</div>

				<h2 class="panel-title">Manage Schedule</h2>
				</header>
				<div class="panel-body">
					<form action="<%=request.getContextPath()%>/ScheduleController" method="post" class="form-horizontal form-bordered">
						<div class="form-group">
							<label class="col-md-3 control-label">Select Your Area</label>
							<div class="col-md-6">
								<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
								<select name="area" 
									class="form-control populate">
									<c:forEach items="${sessionScope.area }" var="x">
										<option value="${x.areaId }">${x.areaName }</option>
									</c:forEach>



								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 control-label">Time</label>
							<div class="col-md-6">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-clock-o"></i>
									</span> <input name="timePick"type="text" data-plugin-timepicker class="form-control">
								</div>
							</div>
						</div>
						<div class="row">
							
							<div class="col-sm-9 col-sm-offset-3">
								<input type="hidden" name="flag" value="insert">
								<button class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>



						
					</form>
				</div>
				</section>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12"></div>
		</div>


		</section>
	</div>

	<aside id="sidebar-right" class="sidebar-right">
	<div class="nano">
		<div class="nano-content">
			<a href="#" class="mobile-close visible-xs"> Collapse <i
				class="fa fa-chevron-right"></i>
			</a>

			<div class="sidebar-right-wrapper">

				<div class="sidebar-widget widget-calendar">
					<h6>Upcoming Tasks</h6>
					<div data-plugin-datepicker data-plugin-skin="dark"></div>

					<ul>
						<li><time datetime="2014-04-19T00:00+00:00">04/19/2014</time>
							<span>Company Meeting</span></li>
					</ul>
				</div>

				<div class="sidebar-widget widget-friends">
					<h6>Friends</h6>
					<ul>
						<li class="status-online"><figure class="profile-picture">
							<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
								class="img-circle"> </figure>
							<div class="profile-info">
								<span class="name">Joseph Doe Junior</span> <span class="title">Hey,
									how are you?</span>
							</div></li>
						<li class="status-online"><figure class="profile-picture">
							<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
								class="img-circle"> </figure>
							<div class="profile-info">
								<span class="name">Joseph Doe Junior</span> <span class="title">Hey,
									how are you?</span>
							</div></li>
						<li class="status-offline"><figure class="profile-picture">
							<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
								class="img-circle"> </figure>
							<div class="profile-info">
								<span class="name">Joseph Doe Junior</span> <span class="title">Hey,
									how are you?</span>
							</div></li>
						<li class="status-offline"><figure class="profile-picture">
							<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
								class="img-circle"> </figure>
							<div class="profile-info">
								<span class="name">Joseph Doe Junior</span> <span class="title">Hey,
									how are you?</span>
							</div></li>
					</ul>
				</div>

			</div>
		</div>
	</div>
	</aside> </section>

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
	<script src="assets/vendor/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
	<script
		src="assets/vendor/jquery-ui-touch-punch/jquery.ui.touch-punch.js"></script>
	<script src="assets/vendor/select2/select2.js"></script>
	<script
		src="assets/vendor/bootstrap-multiselect/bootstrap-multiselect.js"></script>
	<script src="assets/vendor/jquery-maskedinput/jquery.maskedinput.js"></script>
	<script src="assets/vendor/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>
	<script
		src="assets/vendor/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
	<script
		src="assets/vendor/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
	<script src="assets/vendor/fuelux/js/spinner.js"></script>
	<script src="assets/vendor/dropzone/dropzone.js"></script>
	<script src="assets/vendor/bootstrap-markdown/js/markdown.js"></script>
	<script src="assets/vendor/bootstrap-markdown/js/to-markdown.js"></script>
	<script src="assets/vendor/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script src="assets/vendor/codemirror/lib/codemirror.js"></script>
	<script src="assets/vendor/codemirror/addon/selection/active-line.js"></script>
	<script src="assets/vendor/codemirror/addon/edit/matchbrackets.js"></script>
	<script src="assets/vendor/codemirror/mode/javascript/javascript.js"></script>
	<script src="assets/vendor/codemirror/mode/xml/xml.js"></script>
	<script src="assets/vendor/codemirror/mode/htmlmixed/htmlmixed.js"></script>
	<script src="assets/vendor/codemirror/mode/css/css.js"></script>
	<script src="assets/vendor/summernote/summernote.js"></script>
	<script src="assets/vendor/bootstrap-maxlength/bootstrap-maxlength.js"></script>
	<script src="assets/vendor/ios7-switch/ios7-switch.js"></script>
	<script
		src="assets/vendor/bootstrap-confirmation/bootstrap-confirmation.js"></script>

	<!-- Theme Base, Components and Settings -->
	<script src="assets/javascripts/theme.js"></script>

	<!-- Theme Custom -->
	<script src="assets/javascripts/theme.custom.js"></script>

	<!-- Theme Initialization Files -->
	<script src="assets/javascripts/theme.init.js"></script>


	<!-- Examples -->
	<script src="assets/javascripts/forms/examples.advanced.form.js"></script>

</body>
</html>