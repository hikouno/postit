<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
<script type="text/javascript" src="js/initCarte.js"></script>
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
			<div class="wrapper">
				<h1><a href="index.html" id="logo">Website name</a></h1>
				<div class="right">
					<div class="wrapper">
						<form id="search" action="" method="post">
							<div class="bg">
								<input type="submit" class="submit" value="">
								<input type="text" class="input">
							</div>
						</form>
					</div>
					
					<%
						try
						{
							String resCo = (String)request.getAttribute("echecCo") ;
							if(resCo.equals("success"))
							{
								HttpSession sess = request.getSession();
								String nom = (String)sess.getAttribute("nom");
								String prenoms = (String)sess.getAttribute("prenom");
								String pseudo = (String)sess.getAttribute("pseudo");
								
					%>
					<div class="wrapper">
					<p>Bienvenue Mr <%=nom%> <%=prenoms%></p>
						<nav>
							<ul id="top_nav">
								<li><a href="monCompte.html"><%=pseudo%> </a></li>
								<li><a onclick="logout()">log-out</a></li>
								<li><a href="#">Help</a></li>
							</ul>
						</nav>
					</div>
					
					<% 
							}
							else
							{
					%>
					<div class="wrapper">
						<nav>
							<ul id="top_nav">
								<li><a href="Inscription.html">Register</a></li>
								<li><a href="Login.html">Log In</a></li>
								<li><a href="#">Help</a></li>
							</ul>
						</nav>
					</div>
					<%
								
							}
						}
						catch(Exception e)
						{
					%>
					<div class="wrapper">
						<nav>
							<ul id="top_nav">
								<li><a href="Inscription.html">Register</a></li>
								<li><a href="Login.html">Log In</a></li>
								<li><a href="#">Help</a></li>
							</ul>
						</nav>
					</div>
					<%
							
						}
					%>
					
					 
				</div>
			</div>
			<nav>
				<ul id="menu">
					<li><a href="index.jsp" class="nav1">Accueil</a></li>
					<li><a href="About.html" class="nav2">Ajout post-it </a></li>
					<li><a href="Tours.html" class="nav3">Mon compte</a></li>
					<li class="end"><a href="Contacts.html" class="nav4">Nous contacter</a></li>
				</ul>
			</nav>
			
			<article class="col_s">
				<div class="defil">
					 <img id="img" src="images/page1_img1.jpg"/>
				</div>
			</article>
		</header>
<!-- / header -->
<!-- content -->
		<section id="content">
			<article class="col1">
				<h3>Hot Points</h3>
				<div class="pad">
					<div class="wrapper under">
						<figure class="left marg_right1"><img src="images/page1_img1.jpg" alt=""></figure>
						<p class="pad_bot2"><strong>Italy<br>Holidays</strong></p>
						<p class="pad_bot2">Lorem ipsum dolor sit amet, consect etuer adipiscing.</p>
						<a href="#" class="marker_1"></a>
					</div>
					<div class="wrapper under">
						<figure class="left marg_right1"><img src="images/page1_img2.jpg" alt=""></figure>
						<p class="pad_bot2"><strong>Philippines<br>Travel</strong></p>
						<p class="pad_bot2">Lorem ipsum dolor sit amet, consect etuer adipiscing.</p>
						<a href="#" class="marker_1"></a>
					</div>
					<div class="wrapper">
						<figure class="left marg_right1"><img src="images/page1_img3.jpg" alt=""></figure>
						<p class="pad_bot2"><strong>Cruise<br>Holidays</strong></p>
						<p class="pad_bot2">Lorem ipsum dolor sit amet, consect etuer adipiscing.</p>
						<a href="#" class="marker_1"></a>
					</div>
				</div>
       		</article>
			<article class="col2 pad_left1">
				<h2>Map</h2>
				<div class="wrapper under">
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