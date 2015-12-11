<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js">

<head>
<meta charset="utf-8">

<title>Green Planet</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animations.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<script src="js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>

	<jsp:include page="u_header.jsp" />

	<section id="middle" class="light_section" >
		<div class="container" align="center">

			<div class="row">

				<div class="block col-sm-7 to_animate"
					data-animation="fadeInRightBig">
					<h1 class="text-center">
						Enter Your<br> <span>Complaint</span>
					</h1>
					<form action="<%=request.getContextPath()%>/UComplaintController"
						Class="contact-form" method="post">
						<!-- <form class="contact-form" method="post" action="/"> -->
						<p class="contact-form-name">
							<label for="name">Select Area <span class="required">*</span></label></p>
						<div class="Complain_icon">
							<i class="fa fa-map-marker"></i>
						</div>
						

						<select name="area" aria-required="true" id="complain_text"><option
								selected="selected">---select area---</option>
							<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
							<c:forEach items="${sessionScope.areaName }" var="x">
								<option value="${x.areaId }">${x.areaName }</option>
							</c:forEach>
						</select>
						<p class="contact-form-name">
							<label for="name">Waste Information <span
								class="required">*</span></label>
						<div class="Complain_icon">
							<i class="fa fa-pencil-square-o"></i>
						</div>

						<input name="compName" id="complain_text" type="text"
							aria-required="true" size="30" s
							placeholder="Enter Subject Of Your Complaint" required>
						</p>
						<p class="contact-form-name">
							<label for="description">Waste Information <span
								class="required">*</span></label>
						<div class="Complain_icon">
							<i class="fa fa-align-left"></i>
						</div>
						<textarea name="compDes" id="complain_text" type="text"
							aria-required="true" size="30" s
							placeholder="Describe your waste information" required></textarea>

						<p class="contact-form-submit vertical-margin-40">
							<input type="hidden" name="flag" value="insert"> <input
								type="submit" value="Submit" class="theme_btn">
						</p>

					</form>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="u_email.jsp"></jsp:include>
	<jsp:include page="u_footer.jsp"></jsp:include>

	<div class="preloader">
		<div class="preloaderimg"></div>
	</div>

	<script src="js/vendor/jquery-1.11.1.min.js"></script>
	<script src="js/vendor/jquery-migrate-1.2.1.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/vendor/placeholdem.min.js"></script>
	<script src="js/vendor/hoverIntent.js"></script>
	<script src="js/vendor/superfish.js"></script>
	<script src="js/vendor/jquery.actual.min.js"></script>
	<script src="js/vendor/jquery.appear.js"></script>
	<script src="js/vendor/jquerypp.custom.js"></script>
	<script src="js/vendor/jquery.elastislide.js"></script>
	<script src="js/vendor/jquery.flexslider-min.js"></script>
	<script src="js/vendor/jquery.prettyPhoto.js"></script>
	<script src="js/vendor/jquery.easing.1.3.js"></script>
	<script src="js/vendor/jquery.ui.totop.js"></script>
	<script src="js/vendor/jquery.isotope.min.js"></script>
	<script src="js/vendor/jquery.easypiechart.min.js"></script>
	<script src='js/vendor/jflickrfeed.min.js'></script>
	<script src="js/vendor/jquery.sticky.js"></script>
	<script src='js/vendor/owl.carousel.min.js'></script>
	<script src='js/vendor/jquery.nicescroll.min.js'></script>
	<script src='js/vendor/jquery.fractionslider.min.js'></script>
	<script src='js/vendor/jquery.scrollTo-min.js'></script>
	<script src='js/vendor/jquery.localscroll-min.js'></script>
	<script src='js/vendor/jquery.parallax-1.1.3.js'></script>
	<script src='js/vendor/jquery.bxslider.min.js'></script>
	<script src='js/vendor/jquery.funnyText.min.js'></script>
	<script src='js/vendor/jquery.countTo.js'></script>
	<script src="js/vendor/grid.js"></script>
	<script src='twitter/jquery.tweet.min.js'></script>
<!-- 	<script src="js/plugins.js"></script>
 -->	<script src="js/main.js"></script>

	

</body>
</html>