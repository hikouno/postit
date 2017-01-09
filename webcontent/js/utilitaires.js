function logout() 
{	  
	  var params =
	  {
			  op : "logout",
	  };
	   $.post("GestionMembresServlet", $.param(params), function(response) { window.location = "http://localhost:8080/enchainement_pages/index.jsp"; });	  
}
