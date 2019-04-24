<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="org.springframework.web.client.RestTemplate" %>
<%@ page import="com.APIRest.Ville" %>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Villes de France</title>
<titre> <h1><center><FONT color = "#176CA4">Les Villes de France</FONT> </center> </h1> </titre>
</head>
<body>


<% 
		RestTemplate restTemplate = new RestTemplate();
		Ville[] villes = restTemplate.getForObject("http://127.0.0.1:8181/villeget", Ville[].class);
		
		%>
		
		<a href="creer.jsp" class="list-group-item list-group-item-action">Ajouter une nouvelle ville</a> 
		<a href="modifier.jsp" class="list-group-item list-group-item-action">Modifier une ville</a> 
		<a href="supprimer.jsp" class="list-group-item list-group-item-action">Supprimer une ville</a> <br>
		
		<table class="table">
		<thead>
		    <tr>
		        <th> Code Commune INSEE</th>
		        <th> Nom </th>
		        <th> Code Postal </th>
		        <th> Libelle Acheminement </th>
		        <th> Ligne 5 </th>
		        <th> Latitude </th>
		        <th> Longitude </th>
		    </tr>
		</thead>
		<tbody>
		<% 
		
		for(int i=0; i<villes.length; i++){
			%>
		    <tr>
		        <td><%=   villes[i].getCodeCommuneINSEE()   %></td>
		        <td><%=   villes[i].getNomCommune()   %></td>
		        <td><%=   villes[i].getCodePostal()   %></td>
				<td><%=   villes[i].getLibelleAcheminement()   %></td>
				<td><%=   villes[i].getLigne5()   %></td>
				<td><%=   villes[i].getLatitude()   %></td>
				<td><%=   villes[i].getLongitude()   %></td>
		    </tr>
		<% 
		}
		
		%>
		</tbody>
	</table>

 





	

	
</body>
</html>