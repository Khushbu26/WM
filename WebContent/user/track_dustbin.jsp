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
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/iframe.css">
<script src="js/vendor/modernizr-2.6.2.min.js"></script>
<!--[if lt IE 9]>
            <script src="js/vendor/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<jsp:include page="u_header.jsp"></jsp:include>


	<section id="middle" class="light_section">
	
		<div class="container">

<div class="row">
<h1 class="text-center">
						Track Our<br> <span>Dustbin</span>
					</h1>
</div>

			<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="container_map" >

					
					<iframe id="myframe" src="mymap.jsp" width="100%" height="100%"></iframe>

				</div>
				</div>
			</div>

		</div>

	</section>
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
	<script src="js/plugins.js"></script>
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