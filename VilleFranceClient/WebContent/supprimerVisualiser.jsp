<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.web.client.RestTemplate" %>
<%@ page import="org.springframework.http.HttpMethod"%>
<%@ page import="com.APIRest.Ville" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<titre> <h1><center><FONT color = "#176CA4">Les Villes de France</FONT> </center> </h1> </titre>
</head>
<body>
La ville suivante a été supprimée :
	 
	<%= session.getAttribute("villeNom") %>
	
	<br><br><a class="btn btn-primary" href="visualiser.jsp" role="button">Retour</a>

</body>
</html>