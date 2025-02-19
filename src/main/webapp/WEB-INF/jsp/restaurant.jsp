<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/custom.css">
<title>Pizza YOLO</title>
</head>
<body>

	<%@ include file="/WEB-INF/fragments/header.jspf" %>
	
	<h1>${restaurant.nom}</h1>
		<div>
			<form action="inscription" method="GET">	
				<input type="submit" value="Inscrivez-vous pour réserver">
			</form>
		</div>
		<div>
			<a href="connexion">Vous avez déjà un compte</a>
		</div>
		
	<div>
		<h2>Nos horaires</h2>
			<c:forEach items="${restaurant.horaires}" var="horaire" varStatus="status">
					<div>
						<p>${horaire.jour} :
						<fmt:parseDate value="${horaire.ouverture}" pattern="yyyy-MM-dd'T'HH:mm" var="ouvertureDate" type="both" />
						<fmt:formatDate value="${ouvertureDate}" pattern="HH:mm" />
						-
						<fmt:parseDate value="${horaire.fermeture}" pattern="yyyy-MM-dd'T'HH:mm" var="fermetureDate" type="both" />
						<fmt:formatDate value="${fermetureDate}" pattern="HH:mm" />
						</p>
					</div>
			</c:forEach>
	</div>
	<div>
		<form action="carte" method="GET">
			<input type="hidden" name="id" value="${Carte.id }">	
			<input type="submit" value="Voir la carte">
		</form>
			
		<form action="listeRestaurants" method="GET">
			<input type="hidden" name="id" value="${restaurant.id }">	
			<input type="submit" value="Retour à la liste de restaurants">
		</form>
 	</div>
 	
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>