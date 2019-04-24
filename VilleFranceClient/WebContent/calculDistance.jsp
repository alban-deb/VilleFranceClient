<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.web.client.RestTemplate" %>
<%@ page import="com.APIRest.Ville" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Calcul de la distance</title>
<titre> <h1><center><FONT color = "#176CA4">Les Villes de France</FONT> </center> </h1> </titre>
</head>
<body>
<% 
	RestTemplate restTemplate = new RestTemplate();
	Ville[] villes = restTemplate.getForObject("http://127.0.0.1:8181/villeget", Ville[].class); %>
	Calcul de la distance :
	<form method="post" action="CalculDistance">
		Ville 1 :
		
		<SELECT name="ville1" size="1">
				<%for(int i=0; i<villes.length; i++){
			%><OPTION><%=   villes[i].getNomCommune()   %><% 
		}%>
		</SELECT> <br><br>
		Ville 2 :
		
		<SELECT name="ville2" size="1">
				<%for(int i=0; i<villes.length; i++){
			%><OPTION><%=   villes[i].getNomCommune()   %><% 
		}%>
		</SELECT> <br><br>
		<input type="submit" value="Calculer la distance"/>
	</form>
	
	
	
</body>
</html>