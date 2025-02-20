<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
  	
  	<div class="jumbotron px-2">
	  <div class="container">
	    <div class="row align-items-start">
	      <div class="col-12">
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">Bienvenue chez<br>Pizza&nbsp;YOLO</h1>
	        <a class="btn btn-success btn-lg rounded-pill" href="listeRestaurants" role="button">Nos restaurants</a>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<c:if test="${empty utilisateur}">
	    <div class="container d-flex justify-content-center mt-5">
			<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
			  <div class="card-body text-center">
			    <h5 class="card-title">Créez votre compte</h5>
			    <p class="card-text">Réservez dans tous nos restaurants, recevez des offres spéciales, contactez nos équipes... N'attendez plus pour vous inscrire !</p>
			    <a href="inscription" class="btn btn-success btn-lg rounded-pill px-4">Je m'inscris</a>
			  </div>
			</div>
		</div>
		
		<div class="container d-flex justify-content-center mb-5">
			<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
			  <div class="card-body text-center">
			    <p class="card-text">Vous avez déjà un compte ?</p>
			    <a href="connexion" class="btn btn-outline-dark rounded-pill">Je me connecte</a>
			  </div>
			</div>
		</div>
	</c:if>
	
	
	<c:if test="${not empty utilisateur.restaurant}">
		<div class="container d-flex justify-content-center my-5">
			<div class="card border border-black rounded-0 bg-transparent" style="width: 100%;">
				<div class="card-header">Votre restaurant favori</div>
				<a href="restaurant?index=${utilisateur.restaurant.id }" class="d-block"><img src="${utilisateur.restaurant.url_image}" class="card-img-top-smaller border-0 rounded-0 max-h-20 w-100" alt="Pizza"></a>		
		  	<div class="card-body text-center my-3">
		    	<h4 class="card-text pb-2">${utilisateur.restaurant.nom}</h4>
		    	<a href="restaurant?index=${utilisateur.restaurant.id }" class="btn btn-outline-dark rounded-pill">Accéder à la page</a>
		    	<a href="reservation?idRestaurant=${utilisateur.restaurant.id }" class="btn btn-success rounded-pill px-4 mx-2">Réserver</a>
			</div>
			</div>
		</div>
	</c:if>
	
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>