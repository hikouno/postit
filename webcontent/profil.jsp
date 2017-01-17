<%@ page import="postit.*, utilisateur.*, notable.*, java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Membre profil= request.getAttribute("membre");
if (profil != null){
	String nom = profil.getNom();
	String prenom = profil.getPrenom();
	String pseudo = profil.getPseudo();
} else {
	String nom = "Membre";
	String Prenom = "introuvable";
	String pseudo = "sur le serveur";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Profil</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.4.2.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>  
<script type="text/javascript" src="js/Myriad_Pro_600.font.js"></script>
<!--[if lt IE 9]>
	<script type="text/javascript" src="http://info.template-help.com/files/ie6_warning/ie6_script_other.js"></script>
	<script type="text/javascript" src="js/html5.js"></script>
<![endif]-->
</head>
<body id="page2">
<div class="extra">
	<div class="main">
<!-- header -->
		<header>
			<div class="wrapper">
				<h1><a href="index.html" id="logo">Around the World</a></h1>
				<div class="right">
					<div class="wrapper">
						<form id="search" action="" method="post">
							<div class="bg">
								<input type="submit" class="submit" value="">
								<input type="text" class="input">
							</div>
						</form>
					</div>
					<div class="wrapper">
						<nav>
							<ul id="top_nav">
								<li><a href="#">Profil</a></li>
								<li><a href="#">Deconnecter</a></li>
								<li><a href="#">Help</a></li>
							</ul>
						</nav>
					</div>	
				</div>
			</div>
			<nav>
				<ul id="menu">
					<li><a href="index.html" class="nav1">ACCUEIL</a></li>
					<li><a href="About.html" class="nav2">AJOUT POST-IT</a></li>
					<li><a href="Tours.html" class="nav3">MON COMPTE</a></li>
					<li><a href="Destinations.html" class="nav4">NOUS CONTACTER</a></li>
				</ul>
			</nav>
			<div class="profil">	
				<img src="images/inconnu.jpg" alt="">
			</div>
			<div class="image">
				<h2> <% prenom nom %> </h2>
				<h2> <% pseudo%> </h2>
			</div>
		</header>
<!-- / header -->
<!-- content -->
<section id="content">
			<article class="col1">
				<h3>Post It recents</h3>
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
				<h2>Modification du Profil</h2>
				<form id="ContactForm" method="post" action="GestionMembresServlet">
					<input type="hidden" name="op" value="inscrMbr" id="op" />
					<div>
						<div class="wrapper"><input type="text" class="input" name="nom" value="nom" id="nom"/>Nom:<br /></div>
						<div class="wrapper"><input type="text" class="input" name="prenom" value="prenom" id="prenom"/>Prenom:<br /></div>
						<div class="wrapper"><input type="text" class="input" name="pseudo" value="pseudo" id="pseudo"/>Pseudo:<br /></div>
						<div class="wrapper"><input type="password" class="input" name="Oldpassword" value="Oldpassword" id="Oldpassword"/>Old Password:<br /></div>
						<div class="wrapper"><input type="password" class="input" name="password" value="newpassword" id="password"/>New Password:<br /></div>
						<a class="button" onclick="document.getElementById('ContactForm').submit()">valider</a>					
					</div>
				</form>
        	</article>
		</section>
<!-- / content -->
	</div>
	<div class="block"></div>
</div>
<div class="body1">
	<div class="main">
	</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
