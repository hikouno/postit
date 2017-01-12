<%@ page import="postit.*, utilisateur.*, notable.*, java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PostIt postit = (PostIt) request.getAttribute("postit");
Utilisateur auteur = postit.getAuteur();
String titre = postit.getTitre();
Contenu contenu = postit.getContenu();
PointGeo geo = postit.getPointGeo();
List<Commentaire> commentaires = postit.getCommentaires();
Date dateCreation = postit.getDateCreation();

Integer postit_id = postit.getId();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Post-it de <%=auteur.getPseudo()%></title>
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
<body onload="initMap(); startTimer();">

<div class="extra">
	<div class="main">
<!-- header -->
		<header>
			<%@include file="header.jsp"%>
		</header>
<!-- / header -->
<!-- content -->
		<section id="content">
			<article class="col1">
				<h3>Hot Point</h3>
				<div class="pad">
					<div cl 1ass="wrapper under">
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
				<h2>Post-it de <%=auteur.getPseudo()%></h2>
				
					<h3>Post-it</h3>
					<div class="conteneur_postit">
						<span class="titre_postit"><%=titre%></span>
						<div class="contenu_postit"><%=contenu.toHtml()%></div>
					</div>
					
					<div class="note_postit"><img alt="Étoile" src="images/star-icon.png" /><div><%=postit.getNote()%></div></div>
					<div>
					<!-- Note du post-it. -->
					<% if (connected) {
						System.out.println("membre co :" + membre);
						postit.getNote();
						if (!postit.aVote(membre)) { %>
					
						<a class="like" href="GestionPostItServlet?op=noterPostIt&vote=1&postit=<%=postit_id%>"></a>
						<a class="dislike" href="GestionPostItServlet?op=noterPostIt&vote=-1&postit=<%=postit_id%>"></a>
						
					<%  } else {
							Notable.Vote vote = postit.getNoteDUnMembre(membre);
							if (vote == Notable.Vote.PLUS_1) {
								%>
								<a class="liked" href="GestionPostItServlet?op=denoterPostIt&postit=<%=postit_id%>"></a>
								<a class="dislike" href="GestionPostItServlet?op=noterPostIt&vote=-1&postit=<%=postit_id%>"></a>
								<%
							} else {
								%>
								<a class="like" href="GestionPostItServlet?op=noterPostIt&vote=1&postit=<%=postit_id%>"></a>
								<a class="disliked" href="GestionPostItServlet?op=denoterPostIt&postit=<%=postit_id%>"></a>
								<%
							}
						}
					   }
					%>
					</div>
					
					<div class="infos_apropos_postit">
					
						<div class="profil_postant">
							<div class="entete_profil_postant"><%=auteur.getPseudo()%></div>
							<% if (auteur instanceof Membre) { 
									Membre auteurMembre = (Membre) auteur;
							%>
								<div class="wrapper desc_profil_postant">
									<figure class="left marg_right1"><img class="avatar" src="<%=auteurMembre.getAvatarPath()%>" alt=""></figure>
									
									<p class="pad_bot2">Note : <%=auteurMembre.getNote()%></p>
									
									<a href="#" class="marker_2"></a>
								</div>
							<% } %>
						</div>
						
						<div id="carte" style="float: right; width: 300px;height: 245px;"></div>
					</div>
					
					
					
					<h3>Commentaires</h3>
					
					<div class="form_post_comment">
						<form action="GestionPostItServlet?op=ajComm&postit=<%=postit_id%>" method="post">
							<% if (!connected) { %>
								Pseudo : <input type="text" name="pseudo" /><br /> <%
								} else { 
							%>
								<div class="infos_auteur_commentaire">
								<div class="pseudo_auteur_commentaire"><%=membre.getPseudo()%></div>
									<img class="avatar_comm" src="<%=membre.getAvatarPath()%>" alt="" />
								</div>
							<% } %>
							
							<textarea style="width:99.2%;" name="contenuCommentaire" rows="7"></textarea><br />
							
							Inclure une image : <input type="checkbox" name="inclureImage" value="img" />
							<input type="text" name="cheminImage" /><br />
							
							Inclure une vidéo : <input type="checkbox" name="inclureVideo" value="vid" />
							<input type="text" name="cheminVideo" /><br />
							
							<input type="submit" value="Poster un commentaire" />
						</form>
					</div>
					<%
					if (commentaires.size() > 0) {
						
						///GESTION DE LA PAGINATION
						final int NB_COMMENTAIRES_PAR_PAGE = 5;

						Integer numPage = 1;
						
						if (request.getAttribute("p") != null) {
							try {
								numPage = Integer.parseInt((String)request.getAttribute("p"));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						
						System.out.println("NUM PAGE RECUP: " + (String)request.getAttribute("p"));
						
						if (numPage <= 0 || (numPage - 1) * NB_COMMENTAIRES_PAR_PAGE >= commentaires.size())
							numPage = 1;
						
						System.out.println("NUM PAGE : " + numPage);
						int nb_pages = commentaires.size() / NB_COMMENTAIRES_PAR_PAGE + 1;
								
						int indDebut = (numPage - 1) * NB_COMMENTAIRES_PAR_PAGE;
						int indFin = indDebut + NB_COMMENTAIRES_PAR_PAGE - 1;
						
						if (indFin >= commentaires.size()) {
							indFin = commentaires.size() - 1;
						}
						
						System.out.println("IND DEBUT : " + indDebut);
						System.out.println("IND FIN : " + indFin);
						
						///AFFICHAGE DES COMMENTAIRES QUE L'ON VEUT AFFICHER
						//Les plus récents d'abord
						for (int i = commentaires.size() - indDebut - 1; i >= commentaires.size() - indFin - 1; i--) {
							Commentaire c = commentaires.get(i);
							Utilisateur c_auteur = c.getAuteur();
							Contenu c_contenu = c.getContenu();
					%>
					
					<div class="un_commentaire<%if (i != 0) { %> under<%}%>">
						<div class="infos_auteur_commentaire">
							<div class="pseudo_auteur_commentaire"><%=c_auteur.getPseudo()%></div>
							<% if (c_auteur instanceof Membre) { %><img class="avatar_comm" src="<%=((Membre) c_auteur).getAvatarPath()%>" alt="" /><% } %>
						</div>
						
						<div class="noter_supprimer_commentaire">
							<!-- Suppression d'un commentaire -->
							<% if (connected) {
								if (c.getAuteur() == membre || membre == postit.getAuteur()) { %>
								<div><a href="GestionPostItServlet?op=rmComm&postit=<%=postit_id%>&comm=<%=i%>"><img alt="supprimer" title="supprimer" src="images/delete-icon.png" /></a></div>
							<% }
							}
							%>
							
							<!-- Note d'un commentaire. -->
							<% if (connected) {
								if (!c.aVote(membre)) { %>
							
								<a class="like small" href="GestionPostItServlet?op=noterComm&vote=1&postit=<%=postit_id%>&comm=<%=i%>"></a>
								<a class="dislike small" href="GestionPostItServlet?op=noterComm&vote=-1&postit=<%=postit_id%>&comm=<%=i%>"></a>
								
							<%  } else {
									Notable.Vote vote = c.getNoteDUnMembre(membre);
									if (vote == Notable.Vote.PLUS_1) {
										%>
										<a class="liked small" href="GestionPostItServlet?op=denoterComm&postit=<%=postit_id%>&comm=<%=i%>"></a>
										<a class="dislike small" href="GestionPostItServlet?op=noterComm&vote=-1&postit=<%=postit_id%>&comm=<%=i%>"></a>
										<%
									} else {
										%>
										<a class="like small" href="GestionPostItServlet?op=noterComm&vote=1&postit=<%=postit_id%>&comm=<%=i%>"></a>
										<a class="disliked small" href="GestionPostItServlet?op=denoterComm&postit=<%=postit_id%>&comm=<%=i%>"></a>
										<%
									}
								}
						   	}
						%>
							
							<div class="note_comment"><img alt="Étoile" src="images/star-icon.png" /><div><%=c.getNote()%></div></div>
						</div>
						
						<div class="contenu_commentaire">
							<%=c_contenu.toHtml()%>
						</div>
					</div>
					
					<%
						}
					} else { //PAS DE COMMENTAIRES
					%>
					<div>
						Il n'y a pas encore de commentaire !
					</div>
					<% } %>
				
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
