<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizza Yolo</title>
</head>
<body>
	<h1>${restaurant.nom}</h1>
		<div>
			<form action="inscription" method="GET">	
				<input type="submit" value="Inscrivez-vous pour réserver">
			</form>
		</div>
		
		<div>
		<h2>Nos horaires</h2>
			<c:forEach items="${restaurant.horaires}" var="horaire" varStatus="status">
				<div>			
					<label for="jour${status.index}">Jour ${status.index + 1} : </label>
					<div>
						<input id="jour${status.index}" readonly value="${horaire.jour}"/>
					</div>
					<div>
						<input readonly value="${horaire.ouverture}"/>
					</div>
					<div>
						<input readonly value="${horaire.fermeture}"/>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div>
			<form action="carte" method="GET">
				<input type="hidden" name="id" value="${Carte.id }">	
				<input type="submit" value="Afficher la carte">
			</form>
			
			<form action="listeRestaurants" method="GET">
				<input type="hidden" name="id" value="${restaurant.id }">	
				<input type="submit" value="Retour à la liste de restaurants">
			</form>
 		</div>

</body>
</html>