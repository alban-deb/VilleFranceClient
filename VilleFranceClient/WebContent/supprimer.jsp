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
<title>Supprimer une ville</title>
<titre> <h1><center><FONT color = "#176CA4">Les Villes de France</FONT> </center> </h1> </titre>
</head>
<body>

<% 
		RestTemplate restTemplate = new RestTemplate();
		Ville[] villes = restTemplate.getForObject("http://127.0.0.1:8181/villeget", Ville[].class);
		
		%>

	<form method="post" action="Supprimer">
		Ville à supprimer :
		
		<SELECT name="ville" size="1">
				<%for(int i=0; i<villes.length; i++){
			%><OPTION><%=   villes[i].getNomCommune()   %><% 
		}%>
		</SELECT> <br><br>
		
		<input type="submit" value="Supprimer"/>
	</form>
	
	<br><br><a class="btn btn-primary" href="visualiser.jsp" role="button">Retour</a>

</body>
</html>