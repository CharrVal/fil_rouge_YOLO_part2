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
		
	
	<div class="jumbotron-resto px-2">
	  <div class="container">
	    <div class="row align-items-start">
	      <div class="col-12">
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">${restaurant.nom}</h1>
	      </div>
	    </div>
	  </div>
	</div>	
	
	<div class="container d-flex justify-content-center mt-5">
	        <h2 class="display-4 fw-bold lh-1 pb-3">Reserver une table</h2>
	</div>
	
	<c:if test="${!empty erreurs }">
		<div class="container error-container">
			<div class="errors">
				<ul>
					<c:forEach var="msg" items="${erreurs }">
						<li>${msg }</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>

	<div class="container d-flex justify-content-start mt-3 px-5 px-sm-2">
		<form class="row g-3" action="reservationConfirmation" method="post">
			<div class="col-12">
				<label for="selectNbPersonnes" class="form-label">
					Combien de personnes ?<br>
					<span class="fst-italic text-muted">Pour les commandes de plus de 8 personnes, merci de contacter le restaurant.</span>
				</label>
				<select name="nbPersonnes" class="form-select">
				  <option selected>-</option>
				  <option value="1">1</option>
				  <option value="2">2</option>
				  <option value="3">3</option>
				  <option value="4">4</option>
				  <option value="5">5</option>
				  <option value="6">6</option>
				  <option value="7">7</option>
				  <option value="8">8</option>
				</select>
			</div>
			<div class="col-md-6">
				<label for="dateReservation" class="form-label">Date</label> 
				<input type="date" class="form-control" id="dateReservation" name="dateReservation" value="${param.dateReservation}">
			</div>
			<div class="col-md-6">
				<label for="horaireReservation" class="form-label">Heure</label>
				<input type="time" class="form-control" id="horaireReservation" name="horaireReservation" value="${param.horaireReservation}" >
			</div>
			
			<input type="hidden" name="idRestaurant" value="${restaurant.id }">
			
			<div class="col-12 pt-3">
				<button type="submit" class="w-100 btn btn-success btn-lg rounded-pill">Réserver</button>
			</div>

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