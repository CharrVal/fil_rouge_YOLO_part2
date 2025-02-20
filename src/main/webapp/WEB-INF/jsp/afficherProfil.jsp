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
<!-- Icônes FontAwesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<title>Pizza YOLO</title>
</head>
<body>

	<%@ include file="/WEB-INF/fragments/header.jspf"%>




	<div class="card"
		style="width: 18rem; margin: auto; background-color: #bfc9ca;">
		<div class="card-body">
			<h5 class="card-title">Bonjour ${utilisateur.prenom}!</h5>
			<p class="card-text">Bienvenue sur votre profil.</p>
		</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item"><strong>Nom :</strong>
				${sessionScope.utilisateur.nom }</li>
			<li class="list-group-item"><strong>Prénom :</strong>
				${sessionScope.utilisateur.prenom}</li>
			<li class="list-group-item"><strong>Login :</strong>
				${sessionScope.utilisateur.login}</li>
			<li class="list-group-item"><strong>Email :</strong>
				${utilisateur.email}</li>
			<li class="list-group-item"><strong>Téléphone :</strong>
				${sessionScope.utilisateur.telephone}</li>
		</ul>
		<div class="d-grid gap-2 col-6 mx-auto">
			<form action="deconnexion" method="get">
				<button type="submit" class="btn btn-success btn-sm ">Déconnexion</button>
			</form>
			<form action="modifier" method="get">
				<input type="hidden" name="modUtilisateur" />
				<button type="submit" class="btn btn-success btn-sm ">Modifier</button>
			</form>
			<form action="supprimer" method="get">
				<input type="hidden" name="idUtilisateur" />
				<button type="submit" class="btn btn-success btn-sm ">Supprimer</button>
			</form>
		</div>
	</div>


	<div class="container d-flex justify-content-center mb-5">
		<div class="card border border-black rounded-0 bg-transparent"
			style="width: 100%;">
			<div class="card-header">Votre restaurant favori</div>
			<img src="images/jumbotron-bg.jpg"
				class="card-img-top-smaller border-0 rounded-0 max-h-20" alt="Pizza">

			<div class="card-body text-center my-3">
				<h4 class="card-text pb-2">Pizza YOLO Chambéry</h4>
				<a href="restaurant" class="btn btn-outline-dark rounded-pill">Accéder
					à la page</a> <a href="reservation"
					class="btn btn-success rounded-pill px-4 mx-2">Réserver</a>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/fragments/footer.jspf"%>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>











