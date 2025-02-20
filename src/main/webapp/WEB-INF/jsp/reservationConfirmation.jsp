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
	        <h2 class="display-4 fw-bold lh-1 pb-3">Réservation reçue</h2>
	</div>
	
	<div class="container d-flex justify-content-center mt-5">
		<p>Merci pour votre réservation !</p>
	</div>
	
	<div class="container d-flex justify-content-center mt-2">
		<p>Vous recevrez un email de confirmation quand notre équipe aura validé votre réservation.</p>
	</div>
	


	<!-- Pour coller un compostant depuis
	https://getbootstrap.com/docs/5.3/components/
	coller le code du composant à l'intérieur du container suivant : -->

	<div class="container d-flex justify-content-center mt-5">
		<!-- code du composant ici-->
	</div>

	<!-- Puis ajouter les classes de styles au composant, par exemple :
	border-0 rounded-0 bg-transparent -->


		<%@ include file="/WEB-INF/fragments/footer.jspf" %>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>