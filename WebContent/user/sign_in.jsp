<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-Up/Login Form</title>
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div class="form">
		<ul class="tab-group">
			<li class="tab"><a href="#login">Log In</a></li>
			<li class="tab active"><a href="#signup">Sign Up</a></li>

		</ul>
		<div class="tab-content">
			<div id="login">
				<h1>Welcome Back!</h1>

				<form action="login_db.php" method="post">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input type="password" name="pass" required autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>

					<button type="submit" class="button button-block" >
					Log In
					</button>

				</form>

			</div>
			<div id="signup">
				<h1>Sign Up for Free</h1>
				<form name="signin"
					action="<%=request.getContextPath()%>/USignController"
					Class="contact-form" method="post" onsubmit="return matchpass()">
					<!-- <form action="db_form.php" method="post"> -->
					<div class="top-row">
						<div class="field-wrap">
							<label> First Name<span class="req">*</span>
							</label> <input type="text" name="fname" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Last Name<span class="req">*</span>
							</label> <input type="text" name="lname" required autocomplete="off" />
						</div>
					</div>
					<div class="field-wrap">
						<label> Mobile No<span class="req">*</span>
						</label> <input type="text" name="mobile" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="email" required autocomplete="off" />
					</div>


					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label> <input type="password" name="pass" id="password" required
							autocomplete="off" data-rule-required="true" />
					</div>
					<div class="field-wrap">
						<label> conform Password<span class="req">*</span>
						</label> <input type="password" name="cpass" required autocomplete="off"
							data-rule-equalTo="#password" data-rule-required="true" />
					</div>
					<div class="field-wrap">
						<label> City<span class="req">*</span>
						</label> <input type="text" name="city" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> Pincode<span class="req">*</span>
						</label> <input type="text" name="pincode" required autocomplete="off" />
					</div>
					<input type="hidden" name="flag" value="insert">
					<button type="submit" class="button button-block">Get
						Started</button>

				</form>

			</div>



		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>
	<script type="text/javascript">
		function matchpass() {
			var firstpassword = document.signin.pass.value;
			var secondpassword = document.signin.cpass.value;

			if (firstpassword == secondpassword) {
				return true;
			} else {
				alert("password must be same!");
				return false;
			}
		}
	</script>


</body>
</html>