<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
<title>Home</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.4.2.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>  
<script type="text/javascript" src="js/Myriad_Pro_600.font.js"></script>
<script type="text/javascript" src="js/swap.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCAIZrHcZmqc80RMhdvsOrwBR6Z-2xwP5s&callback=initMap"></script>
<script type="text/javascript" src="js/initCarte2.js"></script>
<script type="text/javascript" src="js/utilitaires.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!--[if lt IE 9]>
	<script type="text/javascript" src="http://info.template-help.com/files/ie6_warning/ie6_script_other.js"></script>
	<script type="text/javascript" src="js/html5.js"></script>
<![endif]-->
</head>
<body id="page1" onload="initMap(); startTimer();">
<div class="extra">
	<div class="main">
<!-- header -->
		<header>
			<%@include file="header.jsp"%>
		</header>
<!-- / header -->
<!-- content -->
		<section id="content">
		
			<article class="col2 pad_left1">
				<h2>Research Form</h2>
				<form id="rechPostIt" method="post" action="GestionMembresServlet">
					<input type="hidden" name="op" value="rechPostIt" id="op" />
					<div>
						<div class="wrapper"><input type="text" class="input" name="auteur" value="auteur" id="auteur"/>Auteur:<br /></div>
						<div class="wrapper"><input type="text" class="input" name="notesup" value="notesup" id="notesup"/>Note > :<br /></div>
						<div class="wrapper"><input type="text" class="input" name="noteinf" value="noteinf" id="noteinf"/>Note <  :<br /></div>
						<div class="wrapper"><input type="text" class="input" name="distance" value="distance" id="distance"/>perimètre :<br /></div>
						<div class="wrapper"><input type="password" class="input" name="zone" value="zone" id="zone"/>Zone:<br /></div>
						<a class="button" onclick="document.getElementById('rechPostIt').submit()">Chercher</a>					
					</div>
				</form>
        	</article>
		
			<article class="colcarte " id="carte_wrapper">
				<h2>Map</h2>
				<div class="wrapper under" >
						<div id="carte"></div>	
				</div>
       		</article>
		</section>
<!-- / content -->
	</div>
	<div class="block"></div>
</div>
<div class="body1">
	<div class="main">
<!-- footer -->
		<footer>
		
		</footer>
<!-- / footer -->
	</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
