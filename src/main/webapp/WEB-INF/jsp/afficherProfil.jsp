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
	
	<div class="jumbotron-resto px-2">
	  <div class="container">
	    <div class="row align-items-start">
	      <div class="col-12">
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">Bonjour ${utilisateur.prenom}!</h1>
	      </div>
	    </div>
	  </div>
	</div>	


	<div class="container d-flex justify-content-center mt-5">
	     <h2 class="display-4 fw-bold lh-1 pb-3">Bienvenue sur votre profil</h2>
	</div>
	
	<div class="container mt-3 px-5 px-sm-2">
    	<div class="row justify-content-center">
        	<div class="col-md-8">
           		<ul class="list-group list-group-flush rounded rounded shadow">
	                <li class="list-group-item border-0"><strong>Nom :</strong> 
	                ${sessionScope.utilisateur.nom}</li>
	                <li class="list-group-item border-0"><strong>Prénom :</strong> 
	                ${sessionScope.utilisateur.prenom}</li>
	                <li class="list-group-item border-0"><strong>Identifiant :</strong> 
	                ${sessionScope.utilisateur.login}</li>
	                <li class="list-group-item border-0"><strong>E-mail :</strong> 
	                ${sessionScope.utilisateur.email}</li>
	                <li class="list-group-item border-0"><strong>Téléphone :</strong> 
	                ${sessionScope.utilisateur.telephone}</li>
	                <li class="list-group-item border-0">
	                	<div class="d-flex justify-content-between">
	                		<div>
	                			<strong>Votre restaurant favori :</strong>
	                			<span class="ms-1">${utilisateur.restaurant.nom}</span>
	                		</div> 
	                		<form action="supprimerfavori" method="post">
    							<input type="hidden" name="idRestaurant" value="${utilisateur.restaurant.id}" />
    							<button type="submit" class="btn btn-link text-danger p-0 text-decoration-none">❌</button>
							</form>
						</div>
	                </li>
	            </ul>
	        </div>
	    </div>
	</div>

	<div class="container d-flex justify-content-center">
		<div class="col-md-12 mt-3 text-center">
			<form action="modifier" method="get">
				<input type="hidden" name="modUtilisateur"/>
				<button type="submit"class="btn btn-outline-dark rounded-pill">Modifier</button>
			</form>
		</div>
	</div>
	
	<div class="container d-flex justify-content-center mb-2">
		<div class="col-md-12 mt-3 text-center">
			<form action="deconnexion" method="get">
				<button type="submit" class="btn btn-success rounded-pill px-4 mx-2">Déconnexion</button>
			</form>
		</div>
	</div>

	<div class="container d-flex justify-content-center">
		<div class="col-md-12 mt-3 text-center">
			<form action="supprimer" method="get">
				<input type="hidden" name="idUtilisateur"/>
				<button type="submit" class="btn btn-danger rounded-pill">Supprimer</button>
			</form>
		</div>
	</div>
		
	

	<%@ include file="/WEB-INF/fragments/footer.jspf"%>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
	</script>
</body>
</html>