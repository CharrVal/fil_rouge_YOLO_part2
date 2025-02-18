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
	<h1>Page de connexion</h1>
</header>
		<fieldset>
		<form action="connexion" method="post">
			<label for="login">Veuillez saisir l'identifiant :</label>
			<input type="text" name="login" id="login" required>
			<br>
			<label for="password">Veuillez saisir votre mot de passe :</label>
			<input type="password" name="password" id="password" required>
			<input type="submit" value="Se connecter">
		</form>
		<form action="inscription" method="GET">
			<input type="submit" value="S'inscrire">
		</form>
		<p>${message }</p>
	</fieldset>
	<footer>
	</footer>
</body>
</html>