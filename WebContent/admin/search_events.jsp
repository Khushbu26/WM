<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!doctype html>
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">

<title>Search event</title>
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
<link rel="stylesheet" href="assets/vendor/select2/select2.css" />
<link rel="stylesheet"
	href="assets/vendor/jquery-datatables-bs3/assets/css/datatables.css" />

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

			<section role="main" class="content-body">
				<jsp:include page="page_header.jsp" />

				<!-- start: page -->
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#" class="panel-action panel-action-toggle"
								data-panel-toggle=""></a> <a href="#"
								class="panel-action panel-action-dismiss" data-panel-dismiss=""></a>
						</div>

						<h2 class="panel-title">Search Event</h2>
					</header>
					<div class="panel-body">

						<div id="datatable-editable_wrapper"
							class="dataTables_wrapper no-footer">

							<div class="table-responsive">
								<table
									class="table table-bordered table-striped mb-none dataTable no-footer"
									id="datatable-editable" role="grid"
									aria-describedby="datatable-editable_info">
									<thead>
										<tr role="row">
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Event
												Id</th>

											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Event
												Name</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Description</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Start
												Date</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">End
												date</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Actions</th>
										</tr>
									</thead>
									<c:forEach items="${sessionScope.event}" var="x">
										<tbody>
											<tr class="gradeX odd" role="row">
												<td>${x.eventId}</td>
												<td>${x.eventName}</td>
												<td>${x.eventDes}</td>
												<td>${x.startDate}</td>
												<td>${x.endDate}</td>
												<td class="actions">
													<%
														System.out.println("in search");
													%> <a
													href="<%=request.getContextPath() %>/EventController?flag=edit&id=${x.eventId}"
													class="btn" rel="tooltip" title="Edit"> <i
														class="fa fa-pencil"></i>
												</a> <% System.out.println("in search jsp"); %> 
												<a href="<%=request.getContextPath() %>/EventController?flag=delete&id=${x.eventId}"
													class="btn" rel="tooltip" title="Delete"> <i
														class="fa fa-trash-o"></i>
												</a>
												</td>
											</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</section>
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
	<script src="assets/vendor/select2/select2.js"></script>
	<script
		src="assets/vendor/jquery-datatables/media/js/jquery.dataTables.js"></script>
	<script
		src="assets/vendor/jquery-datatables-bs3/assets/js/datatables.js"></script>

	<!-- Theme Base, Components and Settings -->
	<script src="assets/javascripts/theme.js"></script>

	<!-- Theme Custom -->
	<script src="assets/javascripts/theme.custom.js"></script>

	<!-- Theme Initialization Files -->
	<script src="assets/javascripts/theme.init.js"></script>


	<!-- Examples -->
	<script src="assets/javascripts/tables/examples.datatables.editable.js"></script>
</body>
</html>