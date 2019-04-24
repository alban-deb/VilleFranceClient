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
<title>Modifier une ville</title>
<titre> <h1><center><FONT color = "#176CA4">Les Villes de France</FONT> </center> </h1> </titre>
</head>
<body>

<% 
		RestTemplate restTemplate = new RestTemplate();
		Ville[] villes = restTemplate.getForObject("http://127.0.0.1:8181/villeget", Ville[].class);
		
		%>

	<form method="post" action="Modifier">
		Ville à modifier :
		
		<SELECT name="ville" size="1">
				<%for(int i=0; i<villes.length; i++){
			%><OPTION><%=   villes[i].getNomCommune()   %><% 
		}%>
		</SELECT> <br><br>
		
	
		Code Commune INSEE <input type="text" name="codeCommuneINSEE" required/><br>
		Nom <input type="text" name="nom" required/><br>
		Code Postal <input type="text" name="codePostal" required/><br>
		Libelle Acheminement <input type="text" name="libelle" required/><br>
		Ligne 5 <input type="text" name="ligne5"/><br>
		Latitude <input type="text" name="latitude" required/><br>
		Longitude <input type="text" name="longitude" required/><br>
		<input type="submit" value="Modifier"/><br>
	</form>
	
	
	
</body>
</html>