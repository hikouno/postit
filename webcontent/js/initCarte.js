 var map;
 var markers = [];



function initMap() 
{
		// Create a map object and specify the DOM element for display.
		map = new google.maps.Map(document.getElementById("carte"), {
		center: {lat: -34.397, lng: 150.644},
		scrollwheel: false,
		zoom: 5
		// mapTypeId: google.maps.MapTypeId.ROADMAP
	});
		
	map.addListener('click', function(e) {
		//addPostIt(e.latLng, map);
		ajoutPostIt(e.latLng, map);
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
	 // alert("after push");	  
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
	  
	  //alert("before post");	  
	  $.post("GestionPostItServlet", $.param(params), function(response) {});	  
	  //alert("postIt successfully added");
}


function ajoutPostIt(latLng, map)
{	
	
	var marker = new google.maps.Marker({
	    position: latLng,
	    map: map
	  });
	  map.panTo(latLng);
	  map.setCenter(latLng);
	  map.setZoom(3);
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
	  	  
	  var geocoder = new google.maps.Geocoder;
	  geocoding = geocodeLatLng
	  			  (geocoder, latLng, function(results)
	  					  			{

	  				  					var adresse;
	  				  					adresse = results[0].formatted_address;
	  				  				
		  				  					
		  				  				 //modifications sur la page
		  				  				var div_Wcarte = document.getElementById('carte_wrapper');
			  				  			var div_carte = document.getElementById('carte');
			  				  			
			  				  			
			  				  			
			  				  			div_carte.style.width = '50%';
			  				  			div_carte.style.height = '200px';
			  				  			
	  				  				  
	  				  				  var divform = document.createElement('div');
	  				  				  divform.setAttribute('class','col2');
	  				  				  
	  				  				  var form = document.createElement('form');
	  				  				  form.setAttribute('id','postitForm');
	  				  				  form.setAttribute('method','post');
	  				  				  form.setAttribute('action','GestionPostItServlet');
	  				  				  
	  				  				  var inputOp = document.createElement('input');
	  				  				  inputOp.setAttribute('type','hidden');
	  				  				  inputOp.setAttribute('name','op');
	  				  				  inputOp.setAttribute('id','op');
	  				  				  inputOp.setAttribute('value','ajPostIt');
	  				  					
	  				  				 //titre
	  				  				  var inputTitre = document.createElement('input');
	  				  				  var titreTxt = document.createTextNode("Titre:");
	  				  				  inputTitre.setAttribute('type','text');
	  				  				  inputTitre.setAttribute('class','input');
	  				  				  inputTitre.setAttribute('name','inputTitre');
	  				  				  inputTitre.setAttribute('id','inputTitre');
	  				  				  
	  				  				  var divtitre = document.createElement('div');
	  				  				  divtitre.setAttribute('class','wrapper');
	  				  				  divtitre.appendChild(titreTxt);
	  				  				  divtitre.appendChild(inputTitre);
	  				  				  
	  				  				  //latitude
	  				  				  var inputlat = document.createElement('input');
	  				  				  var latTxt = document.createTextNode("Latitude:");
	  				  				  inputlat.setAttribute('type','text');
	  				  				  inputlat.setAttribute('class','input');
	  				  				  inputlat.setAttribute('name','inputlat');
	  				  				  inputlat.setAttribute('value',latLng.lat());
	  				  				  inputlat.setAttribute('id','inputlat');
	  				  				  inputlat.setAttribute('readonly','true');
	  				  				  
	  				  				  var divlat = document.createElement('div');
	  				  				  divlat.setAttribute('class','wrapper');
	  				  				  divlat.appendChild(latTxt);
	  				  				  divlat.appendChild(inputlat);
	  				  				  
	  				  				  
	  				  				  //longitude
	  				  				  var inputlng = document.createElement('input');
	  				  				  var lngTxt = document.createTextNode("Longitude:");
	  				  				  inputlng.setAttribute('type','text');
	  				  				  inputlng.setAttribute('name','inputlng');
	  				  				  inputlng.setAttribute('class','input');
	  				  				  inputlng.setAttribute('value',latLng.lng());
	  				  				  inputlng.setAttribute('id','inputlng');
	  				  				  inputlng.setAttribute('readonly','true');
	  				  				  
	  				  				  var divlng = document.createElement('div');
	  				  				  divlng.setAttribute('class','wrapper');
	  				  				  divlng.appendChild(lngTxt);
	  				  				  divlng.appendChild(inputlng);

	  				  				  //description
	  				  				  var inputdesc = document.createElement('textarea');
	  				  				  var descTxt = document.createTextNode("Description");
	  				  				  inputdesc.setAttribute('rows','4');
	  				  				  inputdesc.setAttribute('cols','50');
	  				  				  inputdesc.setAttribute('class','input');
	  				  				  inputdesc.setAttribute('name','inputdesc');
	  				  				  inputdesc.setAttribute('id','inputdesc');
	  				  				  inputdesc.setAttribute('form','postitForm');
	  				  				  
	  				  				  var divdesc = document.createElement('div');
	  				  				  divdesc.setAttribute('class','wrapper');
	  				  				  divdesc.appendChild(descTxt);
	  				  				  divdesc.appendChild(inputdesc);
	  				  				  
	  				  				  //video
	  				  				  var inputVideo = document.createElement('input');
	  				  				  var videoTxt = document.createTextNode("lien video:");
	  				  				  inputVideo.setAttribute('type','text');
	  				  				  inputVideo.setAttribute('class','input');
	  				  				  inputVideo.setAttribute('name','inputVideo');
	  				  				  inputVideo.setAttribute('id','inputVideo');
	  				  				  
	  				  				  var divVideo = document.createElement('div');
	  				  				  divVideo.setAttribute('class','wrapper');
	  				  				  divVideo.appendChild(videoTxt);
	  				  				  divVideo.appendChild(inputVideo);
	  				  				  
	  				  				  
	  				  				  //adresse
	  				  				  var inputadresse  = document.createElement('input');
	  				  				  var txtadresse = document.createTextNode("Adresse       ");
	  				  				  inputadresse.setAttribute('type','text');
	  				  				  inputadresse.setAttribute('name','inputadresse');
	  				  				  inputadresse.setAttribute('class','input');
	  				  				  inputadresse.setAttribute('id','inputadresse');
	  				  				  inputadresse.setAttribute('value',adresse);
	  				  				  
	  				  				  var divadresse = document.createElement('div');
	  				  				  divadresse.setAttribute('class','wrapper');
	  				  				  divadresse.appendChild(txtadresse);
	  				  				  divadresse.appendChild(inputadresse);
	  				  				  
	  				  				  //pseudo
	  				  				  var inputpseudo  = document.createElement('input');
	  				  				  var txtpseudo = document.createTextNode("pseudo");
	  				  				  inputpseudo.setAttribute('type','text');
	  				  				  inputpseudo.setAttribute('name','inputpseudo');
	  				  				  inputpseudo.setAttribute('class','input');
	  				  				  inputpseudo.setAttribute('id','inputpseudo');
	  				  				  
	  				  				  var divpseudo = document.createElement('div');
	  				  				  divpseudo.setAttribute('class','wrapper');
	  				  				  divpseudo.appendChild(txtpseudo);
	  				  				  divpseudo.appendChild(inputpseudo);
	  				  				  
	  				  				  
	  				  				  //bouton submit
	  				  				  var aButton = document.createElement('a');
	  				  				  var txtButton = document.createTextNode("Valider");
	  				  				  aButton.setAttribute('class','button');
	  				  				  aButton.setAttribute('onclick','document.getElementById(\'postitForm\').submit()');
	  				  				  aButton.appendChild(txtButton);
	  				  				  
	  				  				  //finalisation
	  				  				  form.appendChild(inputOp);
	  				  				  form.appendChild(divtitre);
	  				  				  form.appendChild(divlat);
	  				  				  form.appendChild(divlng);
	  				  				  form.appendChild(divdesc);
	  				  				  form.appendChild(divVideo);
	  				  				  form.appendChild(divadresse);
	  				  				  form.appendChild(divpseudo);
	  				  				  form.appendChild(aButton);
	  				  				  divform.appendChild(form);
	  				  				  
	  				  				  div_Wcarte.appendChild(divform);
	  				  					
	  					  			}
	  			  );
	  		
}


function geocodeLatLng(geocoder,latlng,fn) 
{ 
		var res;
	  geocoder.geocode({'location': latlng}, function(results, status) 
	  {
	    if (status === google.maps.GeocoderStatus.OK) 
	    {
	    	fn(results);
	    } 
	    else 
	    {
	    	fn('Geocoder failed due to: ' + status);
	    	
	    }
	  });
}
