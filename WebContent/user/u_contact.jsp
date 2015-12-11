<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
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
<script src="js/vendor/modernizr-2.6.2.min.js"></script>
<!--[if lt IE 9]>
            <script src="js/vendor/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	
	<jsp:include page="u_header.jsp"></jsp:include>

	<section id="middle" class="light_section">
		<div class="container">

			<div class="row">

				<div class="block widget_text col-sm-5 to_animate"
					data-animation="fadeInLeftBig">
					<h1 class="text-center">
						contact<br>
						<span>info</span>
					</h1>
					<div id="map" class="light_section"></div>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Pariatur, aspernatur, velit. Adipisci, animi, molestiae, neque
						voluptatum non voluptas atque aperiam nam sed quidem quae harum
						ipsum sit veritatis expedita. Laudantium.</p>
					<p>
						<strong>Address:</strong> 504,JB Tower,Beside SAL Hospital,Drive
						IN Road, Ahmedabad, 380054<br> <strong>Phone: </strong>+919999887773<br>
						<strong>Email: </strong><a href="mailto:info@hglobal.in">info@hglobal.in</a><br>
						<strong>Website: </strong><a href="./">www.Travel_Portal.com</a>
					</p>

				</div>

				<div class="block col-sm-7 to_animate"
					data-animation="fadeInRightBig">
					<h1 class="text-center">
						contact<br>
						<span>form</span>
					</h1>
					<form action="<%=request.getContextPath()%>/UContactController"
						Class="contact-form" method="post">

						<p class="contact-form-name">
							<label for="name">Name <span class="required">*</span></label> <input
								type="text" aria-required="true" size="30" value="" name="name"
								id="name" class="form-control" placeholder="Name">
						</p>
						<p class="contact-form-email">
							<label for="email">Email <span class="required">*</span></label>
							<input type="email" aria-required="true" size="30" value=""
								name="email" id="email" class="form-control" placeholder="Email">
						</p>
						<p class="contact-form-subject">
							<label for="subject">Subject <span class="required">*</span></label>
							<input type="text" aria-required="true" size="30" value=""
								name="subject" id="subject" class="form-control"
								placeholder="Subject">
						</p>
						<p class="contact-form-message">
							<label for="message">Message</label>
							<textarea aria-required="true" rows="8" cols="45" name="message"
								id="message" class="form-control" placeholder="Message"></textarea>
						</p>
						<p class="contact-form-message">
						<label>Upload Important File</label>
						<iframe src="file_upload.jsp" width="300" height="100"> </iframe>
						</p>
						<p class="contact-form-submit vertical-margin-40">
							<input type="hidden" name="flag" value="insert"> <input
								type="submit" value="Send" id="contact_form_submit"
								name="contact_submit" class="theme_btn">
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
	<!--  <script src="js/plugins.js"></script> -->
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