<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">

<title>ADD SUBCATEGORY</title>
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
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>					
						<c:forEach items="${sessionScope.editsubcategory }" var="y">
	<form action="<%=request.getContextPath()%>/SubcategoryController" method="post">
	<section class="body">

		<!-- start: header -->
		<jsp:include page="header.jsp"/>
		<!-- end: header -->

		<div class="inner-wrapper">
			<!-- start: sidebar -->
			<jsp:include page="menu.jsp"/>
			<!-- end: sidebar -->

			<section role="main" class="content-body">
				<jsp:include page="menu.jsp"/>





				<!-- hinal block start -->
				<header class="panel-heading">
					<div class="panel-actions">
						<a href="#" class="panel-action panel-action-toggle"
							data-panel-toggle></a> <a href="#"
							class="panel-action panel-action-dismiss" data-panel-dismiss></a>
					</div>

					<h2 class="panel-title">ADD SUBCATEGORY</h2>
					<!-- <p class="panel-subtitle">
											Basic validation will display a label with the error after the form control.
										</p> -->
				</header>


				<div class="panel-body">
					<div class="form-group">
						<label class="col-md-3 control-label" for="inputSuccess">Select Category</label>
						<div class="col-md-6">
							<select name="categoryId" class="form-control mb-md">
								<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
												<c:forEach items="${sessionScope.category}" var="x">
												<c:if test="${y.catRef.categoryId eq x.categoryId}">
												<option value="${x.categoryId }" selected="selected">${x.categoryName }</option>
												</c:if>
													<c:if test="${y.catRef.categoryId ne x.categoryId}">
													<option value="${x.categoryId }">${x.categoryName }</option>
													</c:if>
												</c:forEach>				</select> 
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Add Subcategory <span
							class="required"></span></label>
						<div class="col-md-6">
							<input type="text" name="subcat" class="form-control"
								placeholder="Add subcategory" value="${y.subcategoryName}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="textareaAutosize">Subcategory
							Description</label>
						<div class="col-md-6">
							<textarea name="subcat_des" class="form-control" rows="3" id="textareaAutosize"
								data-plugin-textarea-autosize>${y.subcategoryDes}</textarea>
						</div>
					</div>



				</div>
				<footer class="panel-footer">
					<div class="row">
					<input type="hidden" name="id" value="${y.subcategoryId}">
										<input type="hidden" name="flag" value="update">
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