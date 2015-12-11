<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <!DOCTYPE html> -->
    <html>
    <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
      <title>Google Maps Multiple Markers</title>
      <script src="http://maps.google.com/maps/api/js?sensor=false"
              type="text/javascript"></script>
    </head>
    <body onload="initialize()">
   
      <div id="map" style="width:1000px; height: 500px;" align="center"></div>

      <script type="text/javascript">
     /*  var x = document.getElementById("map");
      function getLocation() {
    	    if (navigator.geolocation) {
    	        navigator.geolocation.getCurrentPosition(showPosition);
    	    } else { 
    	        x.innerHTML = "Geolocation is not supported by this browser.";
    	    }
    	}
		var latitude= position.coords.latitude;
		var longitude=position.coords.longitude;
    	 function showPosition(position) {
    	    x.innerHTML = "Latitude: " + position.coords.latitude + 
    	    "<br>Longitude: " + position.coords.longitude;	
    	}  */
        var locations = [
          [' Navrangpura, Ahmedabad, Gujarat, India', 23.0374465, 72.5663254, 1],
          ['Nehrunagar,Ahmedabad, Gujarat, India',22.9934119,72.6291612, 2],
          ['Naroda,Ahmedabad, Gujarat, India', 23.06859, 72.6536, 3],
          ['Bapunagar,Ahmedabad, Gujarat, India', 23.0387, 72.63075, 4],
          ['RTO,Ahmedabad, Gujarat, India', 23.0683918, 72.5815136, 5],
          ['Chandkheda,Ahmedabad, Gujarat, India', 23.11157, 72.57276, 6],
          ['Thaltej,Ahmedabad, Gujarat, India', 23.04974, 72.51172, 7],
          ['Bopal,Ahmedabad, Gujarat, India', 23.0334053, 72.467236, 8]
        ];
    	/* new block*/function initialize() {
    	     var myLatlng1 = new google.maps.LatLng(23.0300,72.5800);

    	     var mapOptions = {
    	         zoom: 10,
    	         center: myLatlng1,
    	         mapTypeId: google.maps.MapTypeId.ROADMAP
    	     };
    	     var map = new google.maps.Map(document.getElementById('map'),
    	     mapOptions);

    	      if (navigator.geolocation) {
    	         navigator.geolocation.getCurrentPosition(function (position) {
    	             initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    	             map.setCenter(initialLocation);
    	         });
    	     }
    	 } 
    	initialize()/*new block end*/
      /*   var map = new google.maps.Map(document.getElementById('map'), {
           zoom: 11, 
         
          center: new google.maps.LatLng(position.coords.latitude , position.coords.longitude), 
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }); */
        
        var infowindow = new google.maps.InfoWindow();

        var marker, i;

        for (i = 0; i < locations.length; i++) {
          marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
             icon:'dustbin1.png', 
            map: map
          });

          google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
              infowindow.setContent(locations[i][0]);
              infowindow.open(map, marker);
            }
          })(marker, i));
        }
        
        
      </script>
    </body>
    </html>