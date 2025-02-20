<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		
	 <div class="jumbotron-resto px-2" style="background-image: url('${restaurant.url_image}')">
	  <div class="container">
	    <div class="row align-items-start">
	      <div class="col-10">
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">${restaurant.nom}</h1>
	      </div>
	      <div class="col-2 text-end">
	        <a href="ajouterfavori?idRestaurant=${restaurant.id }">
	        <c:if test="${utilisateur.restaurant.id == restaurant.id}"><i class="bi bi-star-fill border-2 rounded-0 text-white fs-3 ml-auto"></i></c:if>
	        <c:if test="${utilisateur.restaurant.id != restaurant.id}"><i class="bi bi-star border-2 rounded-0 text-white fs-3 ml-auto"></i></c:if>
	        </a>
	      </div>
	    </div>
	  </div>
	</div>
	
	<c:if test="${empty utilisateur}">
		<div class="container d-flex justify-content-center mt-5">
			<a href="inscription" class="btn btn-success btn-lg rounded-pill px-4">Inscrivez-vous pour réserver</a>
		</div>
		<div class="container d-flex justify-content-center mb-5">
			<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
				<div class="card-body text-center">
					<a href="connexion" class="card-text">Vous avez déjà un compte</a>
				</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${not empty utilisateur}">
		<div class="container d-flex justify-content-center mt-5">
			<a href="reservation?idRestaurant=${utilisateur.restaurant.id }" class="btn btn-success btn-lg rounded-pill px-4 mx-2">Réserver</a>
		</div>
	</c:if>
	
	<div class="container d-flex justify-content-center mt-5">
		<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
		  <div class="card-body text-center">
		    <h2 class="card-title">Notre adresse</h2>
		    <p class="card-text">${restaurant.adresse}</p>
		  </div>
		</div>
	</div>
		
	<div class="text-center my-5">
		<h2>Nos horaires</h2>
			<c:forEach items="${restaurant.horaires}" var="horaire" varStatus="status">
					<div>
						<p>${horaire.jour} :
						<c:if test="${horaire.ouverture == null && horaire.fermeture == null}">
							fermé
						</c:if>
						<c:if test="${horaire.ouverture != null}">
							<fmt:parseDate value="${horaire.ouverture}" pattern="yyyy-MM-dd'T'HH:mm" var="ouvertureDate" type="both" />
							<fmt:formatDate value="${ouvertureDate}" pattern="HH:mm" />
							-
						</c:if>
						<c:if test="${horaire.fermeture != null}">
							<fmt:parseDate value="${horaire.fermeture}" pattern="yyyy-MM-dd'T'HH:mm" var="fermetureDate" type="both" />
							<fmt:formatDate value="${fermetureDate}" pattern="HH:mm" />
						</c:if>
						</p>
					</div>
			</c:forEach>
	</div>
	
		<div class="card-body text-center my-3">
			<form action="carte" method="GET">
				<input type="hidden" name="id" value="${carte.id}">
				<input  type="submit" value="Voir la carte" class="btn btn-outline-dark rounded-pill">
			</form>
		</div>
		<div class="card-body text-center my-3">
			<form action="listeRestaurants" method="GET">
				<input type="hidden" name="id" value="${restaurant.id}">	
				<input type="submit" value="Retour à la liste de restaurants" class="btn btn-outline-dark rounded-pill">
			</form>
 		</div>
 	
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>