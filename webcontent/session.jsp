<%@ page import="utilisateur.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//Session
Boolean connected = false;
HttpSession sess = request.getSession();
Membre membre = null;

if (sess.getAttribute("membre") != null) {
	connected = true;
	membre = (Membre) sess.getAttribute("membre");
}
%>