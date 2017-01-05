<!DOCTYPE html>
<html lang="en">
<head>
<title>Post-it de jean-jacques</title>
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

<!--[if lt IE 9]>
	<script type="text/javascript" src="http://info.template-help.com/files/ie6_warning/ie6_script_other.js"></script>
	<script type="text/javascript" src="js/html5.js"></script>
<![endif]-->
</head>
<body onload="initMap(); startTimer();">
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
								<li><a href="#">Register</a></li>
								<li><a href="#">Log In</a></li>
								<li><a href="#">Help</a></li>
							</ul>
						</nav>
					</div>	
				</div>
			</div>
			<nav>
				<ul id="menu">
					<li><a href="index.html" class="nav1">Accueil</a></li>
					<li><a href="About.html" class="nav2">Ajout post-it </a></li>
					<li><a href="Tours.html" class="nav3">Mon compte</a></li>
					<li class="end"><a href="Contacts.html" class="nav5">Nous contacter</a></li>
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
				<h3>Hot Point</h3>
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
				<h2>Post-it de jean-jacques</h2>
				
					<h3>Post-it</h3>
					<div class="conteneur_postit">
						<span class="titre_postit">Titre</span>
						<div class="contenu_postit">Contenu du post-it</div>
					</div>
					
					<div class="note_postit"><img alt="Étoile" src="images/star-icon.png" /><div>48.2</div></div>
					<div class="like_dislike"><img alt="Aimer" src="images/liked-icon.png"  />
					<img alt="Désaimer" src="images/dislike-icon.png" class="dislike" /></div>
					
					<div class="infos_apropos_postit">
					
						<div class="profil_postant">
							<div class="entete_profil_postant">Pseudo</div>
							<div class="wrapper desc_profil_postant">
								<figure class="left marg_right1"><img src="images/page4_img1.jpg" alt=""></figure>
								<p class="pad_bot2">Note : 5</p>
								<a href="#" class="marker_2"></a>
							</div>
						</div>
						
						<div id="carte" style="float: right; width: 300px;height: 245px;"></div>
					</div>
					
					
					
					<h3>Commentaires</h3>
					
					<div class="un_commentaire under">
						<div class="infos_auteur_commentaire">
							<div class="pseudo_auteur_commentaire">Pseudo</div>
							<img src="images/page4_img1.jpg" alt=""></figure>
						</div>
						
						<div class="noter_supprimer_commentaire">
							<div><img alt="supprimer" title="supprimer" src="images/delete-icon.png" /></div>
							<div class="note_comment"><img alt="Étoile" src="images/star-icon.png" /><div>48.2</div></div>
							<div class="like_dislike_comment"><img alt="Aimer" src="images/liked-icon.png"  />
							<img alt="Désaimer" src="images/dislike-icon.png" class="dislike" /></div>
						</div>
						
						<div class="contenu_commentaire">
							HZERZHUFEZPPFHZUFZUE	hezfiuzfhzupe<br />
							zhzohrzoehrzuedha auzau aa zazae aa<br/><br />
							
							zeoirzrohz <strong>jzhiq</strong> zrez !
						</div>
					</div>
					
					<div class="un_commentaire">
						<div class="infos_auteur_commentaire">
							<div class="pseudo_auteur_commentaire">Pseudo</div>
							<img src="images/page4_img1.jpg" alt=""></figure>
						</div>
						
						<div class="noter_supprimer_commentaire">
							<div class="note_comment"><img alt="Étoile" src="images/star-icon.png" /><div>48.2</div></div>
							<div class="like_dislike_comment"><img alt="Aimer" src="images/liked-icon.png"  />
							<img alt="Désaimer" src="images/dislike-icon.png" class="dislike" /></div>
						</div>
						
						<div class="contenu_commentaire">
							ozenrfueziryvbzeoirbzyroibzye eg :/<br /><br />
							
							<iframe width="280" height="158" src="https://www.youtube.com/embed/arh3olQDxvw" frameborder="0" allowfullscreen></iframe>
						</div>
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
