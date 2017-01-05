 var map;
 var markers = [];



function initMap() 
{
		// Create a map object and specify the DOM element for display.
		map = new google.maps.Map(document.getElementById("carte"), {
		center: {lat: -34.397, lng: 150.644},
		scrollwheel: false,
		zoom: 1
		// mapTypeId: google.maps.MapTypeId.ROADMAP
	});
		
	map.addListener('click', function(e) {
		addPostIt(e.latLng, map);
	});

}

function addPostIt(latLng, map) 
{
	//alert(latLng.lat()+"--"+latLng.lng());
	  var marker = new google.maps.Marker({
	    position: latLng,
	    map: map
	  });
	  map.panTo(latLng);
	  google.maps.event.addListener(marker, 'click', function(){ 
	  															 var index = markers.indexOf(marker);
	  															 if (index > -1) 
	  															 {
	  															 	markers.splice(index, 1);
	  															 }
	  															marker.setMap(null);
	  														   }
	  								);
	  
	  markers.push(marker);
	  alert("after push");
	  
	  var params =
	  {
			  op : "ajP",
			  id : "1",
			  type: "autre",
			  emeteur: "test",
			  temporaire: "test",
			  comEm : "test",
			  long: latLng.lng(),
			  lat :latLng.lat()   
	  };
	  
	  alert("before post");
	  
	  $.post("GestionPostItServlet", $.param(params), function(response) {});
	  
	  alert("postIt successfully added");
}




