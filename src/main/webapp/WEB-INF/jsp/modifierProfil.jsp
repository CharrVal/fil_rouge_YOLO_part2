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

	<jsp:include page="/WEB-INF/fragments/header.jsp">
		<jsp:param name="title" value="${pageTitle}" />
	</jsp:include>



	<div class="container d-flex justify-content-start mt-5">
		<form class="row g-3" action="modifier" method="post">
			<div class="col-md-6">
				<label for="inputNom" class="form-label">Nom</label>
				<input type="text" class="form-control" id="inputNom" value="<c:out value='${sessionScope.utilisateur.nom}'/>" required>
			</div>
			<div class="col-md-6">
				<label for="inputPrenom" class="form-label">Prénom</label> 
				<input type="text" class="form-control" id="inputPrenom" value="<c:out value='${sessionScope.utilisateur.prenom}'/>"required>
				
			</div>
			<div class="col-12">
				<label for="inputEmail" class="form-label">email</label>
				<input type="email" class="form-control" id="inputEmail" value="<c:out value='${sessionScope.utilisateur.email}'/>"required>
			</div>
			<div class="col-12">
				<label for="inputTel" class="form-label">Téléphone</label> <input
					type="text" class="form-control" id="inputTel" value="<c:out value='${sessionScope.utilisateur.telephone}'/>"required>
			</div>
			<div class="col-md-6">
				<label for="inputLogin" class="form-label">Login</label> <input
					type="text" class="form-control" id="inputLogin"value="<c:out value='${sessionScope.utilisateur.login}'/>"required>
			</div>
						<div class="col-md-6">
				<label for="inputMp" class="form-label">Mot de Passe</label> 
				<input type="password" class="form-control" id="inputMp" name="inputMp" value="<c:out value='${sessionScope.utilisateur.password}'/>"required>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Modifier</button>
			</div>


		</form>
	</div>



	<!-- Pour coller un compostant depuis
	https://getbootstrap.com/docs/5.3/components/
	coller le code du composant à l'intérieur du container suivant : -->

	<div class="container d-flex justify-content-center mt-5">
		<!-- code du composant ici-->
	</div>

	<!-- Puis ajouter les classes de styles au composant, par exemple :
	border-0 rounded-0 bg-transparent -->




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

	<jsp:include page="/WEB-INF/fragments/footer.jsp">
		<jsp:param name="title" value="${pageTitle}" />
	</jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>


















