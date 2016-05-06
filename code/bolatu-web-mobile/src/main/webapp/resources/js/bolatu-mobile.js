var globalPosition;

$(function() {	 
	 if (navigator.geolocation) {
		 navigator.geolocation.getCurrentPosition(function (position) {
			 globalPosition = position;
			 $(document.getElementById("main:inputUserLocation")).val(position.coords.latitude + ','
					 + position.coords.longitude);
			 $(document.getElementById("main:inputUserLocationWithUpload")).val(position.coords.latitude + ','
					 + position.coords.longitude);			 
		 }); 
	 }
});


