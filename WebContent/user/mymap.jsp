<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body onload="getArray()">
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function (p) {
        var LatLng = new google.maps.LatLng(p.coords.latitude, p.coords.longitude);
        var mapOptions = {
            center: LatLng,
            zoom: 11,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("dvMap"), mapOptions);
        var marker = new google.maps.Marker({
            position: LatLng,
            icon:'man2.png',
            map: map,
            title: "<div style = 'height:60px;width:200px'><b>Your location:</b><br />Latitude: " + p.coords.latitude + "<br />Longitude: " + p.coords.longitude
        });
        google.maps.event.addListener(marker, "click", function (e) {
            var infoWindow = new google.maps.InfoWindow();
            infoWindow.setContent(marker.title);
            infoWindow.open(map, marker);
        });
        
     
        
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
        var marker1, i;

        for (i = 0; i < locations.length; i++) {
          marker1 = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
             icon:'dustbin1.png', 
            map: map
          });

          google.maps.event.addListener(marker, 'click', (function(marker1, i) {
            return function() {
              infowindow.setContent(locations[i][0]);
              infowindow.open(map, marker1);
            }
          })(marker1, i));
        }
        
        
    });
} else {
    alert('Geo Location feature is not supported in this browser.');
}

function getArray() {
	
	
}



</script>
<div id="dvMap" style="width: 100%; height: 600px">
</div>
<input type="hidden" value="${x.dustId}" />
</body>


</html>
