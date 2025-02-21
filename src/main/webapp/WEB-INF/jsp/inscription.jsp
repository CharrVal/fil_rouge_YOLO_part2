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

	<%@ include file="/WEB-INF/fragments/header.jspf"%>

	<div class="jumbotron-resto px-2">
		<div class="container">
			<div class="row align-items-start">
				<div class="col-12">
					<h1 class="display-4 fw-bold lh-1 text-white pb-3">Inscription</h1>
				</div>
			</div>
		</div>
	</div>

	<div class="container d-flex justify-content-center mt-5">
		<h2 class="display-4 fw-bold lh-1 pb-3">Créez votre compte</h2>
	</div>

	<div class="container d-flex justify-content-start mt-3 px-5 px-sm-2">

		<form class="row g-3" action="inscription" method="POST">
			<div class="col-md-12">
				<label class="form-label" for="nom">Nom</label> <input type="text"
					class="form-control ${not empty erreur['nom'] ? 'is-invalid' : '' }"
					id="nom" name="nom" placeholder="Votre nom" required>
				<div class="invalid-feedback">${erreur['nom']}</div>
			</div>
			<div class="col-md-12">
				<label class="form-label" for="prenom">Prénom</label> <input
					class="form-control ${not empty erreur['prenom'] ? 'is-invalid' : '' }"
					type="text" id="prenom" name="prenom" placeholder="Votre prénom"
					required>
				<div class="invalid-feedback">${erreur['prenom']}</div>
			</div>
			<div class="col-md-12">
				<label class="form-label" for="login">Identifiant</label> <input
					class="form-control ${not empty erreur['login'] ? 'is-invalid' : '' }"
					type="text" id="login" name="login" placeholder="Votre identifiant"
					required>
				<div class="invalid-feedback">${erreur['login']}</div>
			</div>
			<div class="col-md-6">
				<label class="form-label" for="mdp">Mot de passe</label> <input
					class="form-control ${not empty erreur['password'] ? 'is-invalid' : '' }"
					type="password" name="mdp" id="mdp"
					placeholder="Votre mot de passe" required>
				<div class="invalid-feedback">${erreur['password']}</div>
				<button class="btn btn-outline-dark rounded-pill mt-2" type="button"
					onclick="displayPassword()">Afficher/Masquer</button>
			</div>
			<div class="col-md-6">
				<label class="form-label" for="mdp2">Répéter votre mot de
					passe</label> <input class="form-control" type="password" name="mdp2"
					id="mdp2" placeholder="Répétez votre mot de passe" required>
				<button class="btn btn-outline-dark rounded-pill mt-2" type="button"
					onclick="displayPasswordbis()">Afficher/Masquer</button>

				<script>
					function displayPassword() {
						var passwordField = document.getElementById("mdp");
						if (passwordField.type === "password") {
							passwordField.type = "text";
						} else {
							passwordField.type = "password";
						}
					}
				</script>

				<script>
					function displayPasswordbis() {
						var passwordField2 = document.getElementById("mdp2");
						if (passwordField2.type === "password") {
							passwordField2.type = "text";
						} else {
							passwordField2.type = "password";
						}
					}
				</script>
			</div>
			<div class="col-md-12">
				<label class="form-label" for="email">E-mail</label> <input
					class="form-control ${not empty erreur['email'] ? 'is-invalid' : '' }"
					type="text" id="email" name="email" placeholder="Votre e-mail"
					required>
				<div class="invalid-feedback">${erreur['email']}</div>

			</div>
			<div class="col-md-12">
				<label class="form-label" for="telephone">Téléphone</label> <input
					class="form-control ${not empty erreur['telephone'] ? 'is-invalid' : '' }"
					type="text" id="telephone" name="telephone"
					placeholder="Votre numéro de téléphone 0612164545" required>
				<div class="invalid-feedback">${erreur['telephone']}</div>
			</div>
			<div class="col-12 pt-3">
				<button type="submit"
					class="w-100 btn btn-success btn-lg rounded-pill">Confirmer</button>
			</div>

		</form>



	</div>

	<%@ include file="/WEB-INF/fragments/footer.jspf"%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>