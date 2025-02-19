<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
<h1>Inscription</h1>
</header>
	<h2>Créez votre compte</h2>
	<fieldset>
		<form action="inscription" method="POST">
			<label for="nom">Nom :</label>
			<input type="text" id="nom" name="nom" placeholder="Votre nom" required>
			
			<label for="prenom">Prenom :</label>
			<input type="text" id="prenom" name="prenom" placeholder="Votre prenom" required>
			
			<label for="login">Login :</label>
			<input type="text" id="login" name="login" placeholder="Votre login" required>
			
			<label for="mdp">Mot de passe</label>
			<input type="password" name="mdp" id="mdp" required>
			<button type="button" onclick="displayPassword()">Afficher/Masquer</button>
				
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
			
			<label for="email">Email :</label>
			<input type="text" id="email" name="email" placeholder="Votre Email" required>
			
			<label for="telephone">Telephone:</label>
			<input type="text" id="telephone" name="telephone" placeholder="Tel : 06 00 00 00 00" required>
			
			<input type="submit" value="Confirmer">
		</form>
	</fieldset>
<footer>
</footer>
</body>
</html>