<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">Connexion</h1>
	      </div>
	    </div>
	  </div>
	</div>
	
		<div class="container d-flex justify-content-center mt-5">
		<h2 class="display-4 fw-bold lh-1 pb-3">Connectez-vous</h2>
	</div>	

	<div class="container d-flex justify-content-start mt-3 px-5 px-sm-2">
		<form class="row g-3" action="connexion" method="post">
			<div class="col-md-12">
				<label class="form-label" for="login">Veuillez saisir votre identifiant :</label>
				<input class="form-control" type="text" name="login" id="login" placeholder="Votre identifiant" required>
			</div>
			<div class="col-md-12">
				<label class="form-label" for="password">Veuillez saisir votre mot de passe :</label>
				<input class="form-control" type="password" name="password" id="password" placeholder="Votre mot de passe" required>
			</div>
			<div class="col-12 pt-3">
				<button type="submit" class="w-100 btn btn-success btn-lg rounded-pill">Se connecter</button>
			</div>
		</form>
	</div>
	
	<div class="container d-flex justify-content-center mb-5">
		<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
		  <div class="card-body text-center">
		    <p class="card-text">Vous n'avez pas de compte ?</p>
		    <a href="inscription" class="btn btn-outline-dark rounded-pill">Inscrivez-vous</a>
		  </div>
		</div>
	</div>
	
	<div class="container d-flex justify-content-center mb-5">
		<p class="card-text">${message }</p>
	</div>
	
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>