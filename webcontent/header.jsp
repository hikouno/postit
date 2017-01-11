<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="session.jsp"%>
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
					
					<% if (connected) { %>
					<div class="wrapper">
					<p>Bienvenue Mr <%=nomMembre%> <%=prenomsMembre%></p>
						<nav>
							<ul id="top_nav">
								<li><a href="monCompte.html"><%=pseudoMembre%> </a></li>
								<li><a onclick="logout()">log-out</a></li>
								<li><a href="#">Help</a></li>
							</ul>
						</nav>
					</div>
					<% } else { %>
					<div class="wrapper">
						<nav>
							<ul id="top_nav">
								<li><a href="#">Register</a></li>
								<li><a href="#">Log In</a></li>
								<li><a href="#">Help</a></li>
							</ul>
						</nav>
					</div>	
				<% } %>
				
				</div>
			</div>
			<nav>
				<ul id="menu">
					<li><a href="index.jsp" class="nav1">Accueil</a></li>
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