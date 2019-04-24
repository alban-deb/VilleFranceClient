<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.web.client.RestTemplate" %>
<%@ page import="com.APIRest.Ville" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Ajouter une ville</title>
<titre> <h1><center><FONT color = "#176CA4">Les Villes de France</FONT> </center> </h1> </titre>
</head>
<body>

	Ajouter une nouvelle ville :
	<form method="post" 	action="Creer">
		Code Commune INSEE <input type="text" name="codeCommuneINSEE" required/><br>
		Nom <input type="text" name="nom" required/><br>
		Code Postal <input type="text" name="codePostal" required/><br>
		Libelle Acheminement <input type="text" name="libelle" required/><br>
		Ligne 5 <input type="text" name="ligne5"/><br>
		Latitude <input type="text" name="latitude" required/><br>
		Longitude <input type="text" name="longitude" required/><br>
		<input type="submit" value="Ajouter"/><br>
	</form>

<br><br><a class="btn btn-primary" href="visualiser.jsp" role="button">Retour</a>
	
</body>
</html>