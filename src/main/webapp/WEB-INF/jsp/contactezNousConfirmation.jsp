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
	
	
	<% if ((Boolean)request.getAttribute("emailSent")) { %>
		<div class="container d-flex justify-content-center mt-5">
	        <h2 class="display-4 fw-bold lh-1 pb-3">Message reçu</h2>
		</div>
        <div class="container d-flex justify-content-center ">
            <p>Merci pour votre message !</p>
        </div>
        <div class="container d-flex justify-content-center mt-2">
			<p>Notre équipe vous répondra dans les meilleurs délais.</p>
		</div>
		<div class="container d-flex justify-content-center">
			    <a href="restaurant?index=${restaurant.id }" class="btn btn-success rounded-pill px-4 mx-2">Revenir à la page du restaurant</a>
        </div>
    <% } else { %>
   		 <div class="container d-flex justify-content-center mt-5">
	        <h2 class="display-4 fw-bold lh-1 pb-3">Oups</h2>
		</div>
        <div class="container d-flex justify-content-center alert alert-danger">
            L'envoi de votre message a rencontré un problème. Merci d'essayer à nouveau.
        </div>
        <div class="container d-flex justify-content-center">
			    <a href="contactezNous?idRestaurant=${restaurant.id }" class="btn btn-success rounded-pill px-4 mx-2">Revenir à la page contact</a>
        </div>
    <% } %>

	
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