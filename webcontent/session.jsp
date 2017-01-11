<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//Session
Boolean connected = false;
HttpSession sess = request.getSession();
String pseudoMembre = "", prenomsMembre = "", nomMembre = "";
if (sess.getAttribute("pseudo") != null) {
	connected = true;
	pseudoMembre = (String) sess.getAttribute("pseudo");
	prenomsMembre = (String)sess.getAttribute("prenom");
	nomMembre = (String)sess.getAttribute("nom");
}
%>