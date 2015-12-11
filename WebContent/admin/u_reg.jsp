<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="fixed">
<head>

<!-- Basic -->
<meta charset="UTF-8">
<title>Sign Up</title>
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

<!-- Theme CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme.css" />

<!-- Skin CSS -->
<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">

<!-- Head Libs -->

</head>

<body>

<script type="text/javascript">  
function matchpass(){  
var firstpassword=document.f1.password.value;  
var secondpassword=document.f1.password2.value;  
  
if(firstpassword==secondpassword){  
return true;  
}  
else{  
alert("password must be same!");  
return false;  
}  
} 
</script>

	<!-- start: page -->
	<section class="body-sign">
		<div class="center-sign">
			<a href="/" class="logo pull-left"> <img
				src="assets/images/logo-footer.png" height="54" alt="Porto Admin" />
			</a>

			<div class="panel panel-sign">
				<div class="panel-title-sign mt-xl text-right">
					<h2 class="title text-uppercase text-weight-bold m-none">
						<i class="fa fa-user mr-xs"></i> Sign Up
					</h2>
				</div>
				<div class="panel-body">
					<form name="f1" onsubmit="return matchpass()"
						action="<%=request.getContextPath()%>/URegistrationController"
						method="post">

						<div class="form-group mb-lg">
							<label>Name*</label> <input name="name" type="text"
								class="form-control input-lg" required />
						</div>


						<div class="form-group mb-lg">
							<label>Contact Number*</label> <input name="number" 
								type="number" class="form-control input-lg" 
								placeholder="Only Digits" required >
						</div>

						<div class="form-group mb-lg">
							<label>E-mail Address*</label> <input name="email" type="email"
								class="form-control input-lg" required />
						</div>

						<div class="form-group mb-none">
							<div class="row">
								<div class="col-sm-6 mb-lg">
									<label>Password*</label> <input name="password" type="password"
										class="form-control input-lg" required />
								</div>
								<div class="col-sm-6 mb-lg">
									<label>Password Confirmation*</label> <input name="password2"
										type="password" class="form-control input-lg" required />
								</div>
								<div class="col-sm-6 mb-lg">
									<label>City*</label> <input name="city" type="text"
										class="form-control input-lg" placeholder="City" required />
									<span id="numloc"></span>
								</div>
								<div class="col-sm-6 mb-lg">
									<label>Pin*</label> <input name="pin" type="number"
										class="form-control input-lg" placeholder="Only Digits"
										required /> <span id="numloc"></span>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-8">
								<div class="checkbox-custom checkbox-default">
									<input id="AgreeTerms" name="agreeterms" type="checkbox" required/> <label
										for="AgreeTerms">I agree with <a href="#">terms of
											use</a></label>
								</div>
							</div>
							<div class="col-sm-4 text-right">
								<input type="hidden" name="flag" value="insert">

								<button type="submit" value="submit"
									class="btn btn-primary hidden-xs">Sign Up</button>
								<button type="submit" value="submit"
									class="btn btn-primary btn-block btn-lg visible-xs mt-lg">Sign
									Up</button>
							</div>
						</div>

						<span class="mt-lg mb-lg line-thru text-center text-uppercase">
							<span>or</span>
						</span>

						<div class="mb-xs text-center">
							<a class="btn btn-facebook mb-md ml-xs mr-xs">Connect with <i
								class="fa fa-facebook"></i></a> <a
								class="btn btn-twitter mb-md ml-xs mr-xs">Connect with <i
								class="fa fa-twitter"></i></a>
						</div>

						<p class="text-center">
							Already have an account? <a href="signin.jsp">Sign In!</a>
					</form>
				</div>
			</div>

			<p class="text-center text-muted mt-md mb-md">&copy; Copyright
				2014. All Rights Reserved.</p>
		</div>
	</section>
	<!-- end: page -->

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

	<!-- Theme Base, Components and Settings -->
	<script src="assets/javascripts/theme.js"></script>

	<!-- Theme Custom -->
	<script src="assets/javascripts/theme.custom.js"></script>

	<!-- Theme Initialization Files -->
	<script src="assets/javascripts/theme.init.js"></script>

</body>
</html>