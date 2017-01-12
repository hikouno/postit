function logout() 
{	  
	  var params =
	  {
			  op : "logout",
	  };
	   $.post("GestionMembresServlet", $.param(params), function(response) { window.location = "index.jsp"; });	  
}

