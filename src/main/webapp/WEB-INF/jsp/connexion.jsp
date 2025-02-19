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

<jsp:include page="/WEB-INF/fragments/header.jsp">
    	<jsp:param name="title" value="${pageTitle}"/>
	</jsp:include>
	
	<h1>Page de connexion</h1>

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
	

<jsp:include page="/WEB-INF/fragments/footer.jsp">
    	<jsp:param name="title" value="${pageTitle}"/>
	</jsp:include>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>