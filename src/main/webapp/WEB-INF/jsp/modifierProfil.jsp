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










	<div class="container d-flex justify-content-start mt-5">
		<form class="row g-3" action="modifier" method="post">
			<div class="col-md-6">
				<label for="inputNom" class="form-label">Nom</label> <input
					type="text" class="form-control" id="inputNom" name="inputNom"
					value="<c:out value='${sessionScope.utilisateur.nom}'/>" required>
			</div>
			<div class="col-md-6">
				<label for="inputPrenom" class="form-label">Prénom</label> <input
					type="text" class="form-control" id="inputPrenom"
					name="inputPrenom"
					value="<c:out value='${sessionScope.utilisateur.prenom}'/>"
					required>
			</div>
			<div class="col-12">
				<label for="inputEmail" class="form-label">E-mail</label> <input
					type="email" class="form-control" id="inputEmail" name="inputEmail"
					value="<c:out value='${sessionScope.utilisateur.email}'/>" required>
			</div>
			<div class="col-12">
				<label for="inputTel" class="form-label">Téléphone</label> <input
					type="text" class="form-control" id="inputTel" name="inputTel"
					value="<c:out value='${sessionScope.utilisateur.telephone}'/>"
					required>
			</div>
			<div class="col-md-6">
				<label for="inputLogin" class="form-label">Identifiant</label> <input
					type="text" class="form-control" id="inputLogin" name="inputLogin"
					value="<c:out value='${sessionScope.utilisateur.login}'/>" required>
			</div>
			<div class="col-md-6">
				<label for="inputMp" class="form-label">Mot de Passe</label> <input
					type="password" class="form-control" id="inputMp" name="inputMp"
					value="<c:out value='${sessionScope.utilisateur.password}'/>"
					required>
			</div>
			<div class="container d-flex justify-content-center mb-2">
				<div class="col-md-12 mt-3 text-center">
					<button type="submit" class="btn btn-success rounded-pill px-4 mx-2">Modifier</button>
				</div>
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


















