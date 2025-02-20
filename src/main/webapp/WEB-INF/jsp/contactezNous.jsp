<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/custom.css">
<title>Pizza YOLO</title>
</head>
<body>

		<%@ include file="/WEB-INF/fragments/header.jspf" %>
		
	<div class="jumbotron-resto px-2" style="background-image: url('${restaurant.url_image}')">
	  <div class="container">
	    <div class="row align-items-start">
	      <div class="col-12">
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">${restaurant.nom}</h1>
	      </div>
	    </div>
	  </div>
	</div>	
	
	<div class="container d-flex justify-content-center mt-5">
	        <h2 class="display-4 fw-bold lh-1 pb-3">Contactez Nous</h2>
	</div>
	<div class="container d-flex justify-content-start mt-3 px-5 px-sm-2">
		<form class="row g-3" action="contactezNous" method="POST">
			<div class="col-md-12">
				<label class="form-label" for="titre">Titre :</label>
				<input class="form-control" type="text" name="titre" id="titre" required>
			</div>
			<div class="col-md-12">
				<label class="form-label" for="message">Votre message :</label>
				<textarea class="form-control" id="message" name="message" rows="5" cols="30" required></textarea>
			</div>
			<div class="col-12 pt-3">
				<input class="w-100 btn btn-success btn-lg rounded-pill" type="submit" value="Envoyer mon message">
			</div>
		</form>
	</div>

		<div class="card-body text-center my-3">
			<form action="listeRestaurants" method="GET">
				<input type="hidden" name="id" value="${restaurant.id}">	
				<input type="submit" value="Retour à la liste de restaurants" class="btn btn-outline-dark rounded-pill">
			</form>
 		</div>

		<%@ include file="/WEB-INF/fragments/footer.jspf" %>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>