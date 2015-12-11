<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">

<title>Green Planet</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animations.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<script src="js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>


	<jsp:include page="u_header.jsp"></jsp:include>


	<section id="middle" class="light_section">
		<div class="container">



			<div class="row">

				<div class="block col-sm-7 to_animate"
					data-animation="fadeInRightBig">
					<h1 class="text-center">
						Post Information<br> <span>About waste</span>
					</h1>
					<form class="contact-form" method="post"
						action="<%=request.getContextPath()%>/WasteInfoController">
						<p class="contact-form-name">

							<label for="name">Select Area <span class="required">*</span></label>
						<div class="Complain_icon">
							<i class="fa fa-map-marker"></i>
						</div>
						</p>
						<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
						<select name="area" class="form-control populate" aria-required="true" >
							<option selected="selected">---select area---</option>
							<c:forEach items="${sessionScope.area }" var="x">
								<option value="${x.areaId }">${x.areaName }</option>
							</c:forEach>



						</select>
						<p class="contact-form-email">
							<label for="email">Waste Information <span
								class="required">*</span></label>
						<div class="Complain_icon">
							<i class="fa fa-info-circle"></i>
						</div>

						<input name="waste_info" id="complain_text" type="text"
							aria-required="true" size="30"
							placeholder="Enter waste information here" required />
						</p>
						<p class="contact-form-email">
							<label for="description">Waste Information <span
								class="required">*</span></label>
						<div class="Complain_icon">
							<i class="fa fa-align-left"></i>
						</div>
						<textarea name="des" id="complain_text" type="text"
							aria-required="true" size="30"
							placeholder="Describe your waste information" required></textarea>
						<iframe src="file_upload.jsp" width="300" height="100"> </iframe>

						<p class="contact-form-submit vertical-margin-40">
							<input type="hidden" name="flag" value="insert"> <input
								type="submit" value="Send waste Information" id="" name=""
								class="theme_btn">
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
	<!-- <script src="js/plugins.js"></script> -->
	<script src="js/main.js"></script>

	<!-- Map Scripts -->

	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">
		var lat;
		var lng;
		var map;

		//type your address after "address="
		jQuery
				.getJSON(
						'http://maps.googleapis.com/maps/api/geocode/json?address=london, baker street, 221b&sensor=false',
						function(data) {
							lat = data.results[0].geometry.location.lat;
							lng = data.results[0].geometry.location.lng;
						}).complete(function() {
					dxmapLoadMap();
				});

		function attachSecretMessage(marker, message) {
			var infowindow = new google.maps.InfoWindow({
				content : message
			});
			google.maps.event.addListener(marker, 'click', function() {
				infowindow.open(map, marker);
			});
		}

		window.dxmapLoadMap = function() {
			var center = new google.maps.LatLng(lat, lng);
			var settings = {
				mapTypeId : google.maps.MapTypeId.ROADMAP,
				zoom : 16,
				draggable : false,
				scrollwheel : false,
				center : center
			};
			map = new google.maps.Map(document.getElementById('map'), settings);

			var marker = new google.maps.Marker({
				position : center,
				title : 'Map title',
				map : map
			});
			marker.setTitle('Map title'.toString());
			//type your map title and description here
			attachSecretMessage(marker,
					'<h3>Map title</h3>Map HTML description');
		}
	</script>


</body>
</html>