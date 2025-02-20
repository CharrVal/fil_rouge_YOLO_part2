<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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

	<div class="container d-flex justify-content-start mt-5">
	    <h1 class="display-4 fw-bold lh-1 pb-3">Inscription</h1>		
	</div>

	<div class="container d-flex justify-content-center mt-5">
		<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
			<div class="card-body text-center">
				<h2>Créez votre compte</h2>
				<fieldset>
					<form action="inscription" method="POST">
						<div class="mb-3">
							<label for="nom">Nom :</label>
							<input type="text" id="nom" name="nom" placeholder="Votre nom" required>
						</div>
						<div class="mb-3">
							<label for="prenom">Prenom :</label>
							<input type="text" id="prenom" name="prenom" placeholder="Votre prenom" required>
						</div>
						<div class="mb-3">
							<label for="login">Login :</label>
							<input type="text" id="login" name="login" placeholder="Votre login" required>
						</div>
						<div class="mb-3">
							<label for="mdp">Mot de passe</label>
							<input type="password" name="mdp" id="mdp" required>
							<button type="button" onclick="displayPassword()">Afficher/Masquer</button>
						</div>
						<div class="mb-3">	
							<label for="mdp2">Répéter votre mot de passe</label>
							<input type="password" name="mdp2" id="mdp2" required>
							<button type="button" onclick="displayPasswordbis()">Afficher/Masquer</button>
						
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
						<div class="mb-3">
							<label for="email">Email :</label>
							<input type="text" id="email" name="email" placeholder="Votre Email" required>
						</div>
						<div class="mb-3">
							<label for="telephone">Telephone:</label>
							<input type="text" id="telephone" name="telephone" placeholder="Tel : 06 00 00 00 00" required>
						</div>
						<div class="mb-3">
							<input type="submit" value="Confirmer">
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</div>
		
<%@ include file="/WEB-INF/fragments/footer.jspf" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>