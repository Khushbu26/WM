<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">

<title>Assign Area Staff list</title>
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
		<jsp:include page="c_header.jsp" />
		<!-- end: header -->

		<div class="inner-wrapper">
			<!-- start: sidebar -->
			<jsp:include page="c_menu.jsp" />
			<!-- end: sidebar -->

			<section role="main" class="content-body">
				<jsp:include page="c_page_header.jsp" />

				<!-- start: page -->
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#" class="panel-action panel-action-toggle"
								data-panel-toggle=""></a> <a href="#"
								class="panel-action panel-action-dismiss" data-panel-dismiss=""></a>
						</div>

						<h2 class="panel-title">Assign Area Staff list</h2>
					</header>
					<div class="panel-body">
						<!-- <div class="row">
									<div class="col-sm-6">
										<div class="mb-md">
											<button id="addToTable" class="btn btn-primary">Add <i class="fa fa-plus"></i></button>
										</div>
									</div>
								</div> -->
						<div id="datatable-editable_wrapper"
							class="dataTables_wrapper no-footer">
							<!-- <div class="row datatables-header form-inline">
								<div class="col-sm-12 col-md-6">
									<div class="dataTables_length" id="datatable-editable_length">
										<label><select name="datatable-editable_length"
											aria-controls="datatable-editable" class=""><option
													value="10">10</option>
												<option value="25">25</option>
												<option value="50">50</option>
												<option value="100">100</option></select> records per page</label>
									</div>
								</div>
								<div class="col-sm-12 col-md-6">
									<div id="datatable-editable_filter" class="dataTables_filter">
										<label><input type="search" class="" placeholder=""
											aria-controls="datatable-editable"></label>
									</div>
								</div>
							</div> -->
							<div class="table-responsive">
							
										<%-- <c:forEach items="${sessionScope.cStaff }" var="y"> --%>
								<table
									class="table table-bordered table-striped mb-none dataTable no-footer"
									id="datatable-editable" role="grid"
									aria-describedby="datatable-editable_info">
									<thead>
										<tr role="row">
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">No</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">StaffCategory</th>
											 <th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Area</th>
											<!--<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Address</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Pin</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Contact</th>
											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Email</th>-->

											<th class="sorting" tabindex="0"
												aria-controls="datatable-editable" rowspan="1" colspan="1">Actions</th> 
										</tr>
									</thead>
									<tbody>
									
										<%
											System.out.println("in search.jsp");
										%>
										<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
										<c:forEach items="${sessionScope.assignstaff }" var="x">
											<%-- <c:if test="${y.cStaffRef.staffId eq x.employeeName}"> --%>
											
										
										
										<tr class="gradeX odd" role="row">
												<td>${x.cAssignAreaId}</td>
												<td>${x.cStaffRef.employeeName}</td>
												<td>${x.areaRef.areaName }
												<%-- <td>${x.employeeName}</td>
												<td>${x.address}</td>
												<td>${x.pin}</td>
												<td>${x.contactNo}</td>
												<td>${x.email}</td>
												 --%>

												<td class="actions"><a
													href="<%=request.getContextPath() %>/CAssignAreaController?flag=edit&id=${x.cAssignAreaId}"
													class="btn" rel="tooltip" title="Edit"> <i
														class="fa fa-pencil"></i>
												</a> <%-- <a
													href="<%=request.getContextPath() %>/CAssignAreaController?flag=delete&id=${x.areaId}"
													class="btn" rel="tooltip" title="Delete"> <i
														class="fa fa-trash-o"></i>
												</a> --%></td>
											</tr>
										<%-- </c:if> --%>
										</c:forEach>
									</tbody>
								
								</table>
								<%-- </c:forEach> --%>
							</div>
							
						</div>
					</div>
				</section>
				<!-- end: page -->
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
								<li class="status-online">
									<figure class="profile-picture">
										<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
											class="img-circle">
									</figure>
									<div class="profile-info">
										<span class="name">Joseph Doe Junior</span> <span
											class="title">Hey, how are you?</span>
									</div>
								</li>
								<li class="status-online">
									<figure class="profile-picture">
										<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
											class="img-circle">
									</figure>
									<div class="profile-info">
										<span class="name">Joseph Doe Junior</span> <span
											class="title">Hey, how are you?</span>
									</div>
								</li>
								<li class="status-offline">
									<figure class="profile-picture">
										<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
											class="img-circle">
									</figure>
									<div class="profile-info">
										<span class="name">Joseph Doe Junior</span> <span
											class="title">Hey, how are you?</span>
									</div>
								</li>
								<li class="status-offline">
									<figure class="profile-picture">
										<img src="assets/images/!sample-user.jpg" alt="Joseph Doe"
											class="img-circle">
									</figure>
									<div class="profile-info">
										<span class="name">Joseph Doe Junior</span> <span
											class="title">Hey, how are you?</span>
									</div>
								</li>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</aside>
	</section>

	<div id="dialog" class="modal-block mfp-hide">
		<section class="panel">
			<header class="panel-heading">
				<h2 class="panel-title">Are you sure?</h2>
			</header>
			<div class="panel-body">
				<div class="modal-wrapper">
					<div class="modal-text">
						<p>Are you sure that you want to delete this row?</p>
					</div>
				</div>
			</div>
			<footer class="panel-footer">
				<div class="row">
					<div class="col-md-12 text-right">
						<button id="dialogConfirm" class="btn btn-primary">Confirm</button>
						<button id="dialogCancel" class="btn btn-default">Cancel</button>
					</div>
				</div>
			</footer>
		</section>
	</div>

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