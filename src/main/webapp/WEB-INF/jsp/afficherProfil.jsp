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
    <!-- Icônes FontAwesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<title>Pizza YOLO</title>
</head>
<body>

	<jsp:include page="/WEB-INF/fragments/header.jsp">
    	<jsp:param name="title" value="${pageTitle}"/>
	</jsp:include>


	
	<!-- Pour coller un compostant depuis
	https://getbootstrap.com/docs/5.3/components/
	coller le code du composant à l'intérieur du container suivant : -->
	
	<div class="container d-flex justify-content-center mt-5">
		<div class="text-center">
			 <h1 class="display-4 fw-bold lh-1 text-white pb-3">Informations de profil</h1>
       		<h2 class="profile-header">Bonjour ${utilisateur.prenom }</h2>
        	<h4 class="mt-3">Informations de profil</h4>
        	<hr>
        	<div class="profile-info">
            	<p><strong>Nom :</strong> ${sessionScope.utilisateur.nom }</p>
            	<p><strong>Prénom :</strong> ${sessionScope.utilisateur.prenom}</p>
            	<p><strong>Login :</strong> ${sessionScope.utilisateur.login}</p>
            	<p><strong>Email :</strong> ${utilisateur.email}</p>
            	<p><strong>Téléphone :</strong> ${sessionScope.utilisateur.telephone}</p> 
       	 	</div>

        	<div class="d-grid gap-2 mt-4">
				<form action="/deconnexion" method="POST">
    				<button type="submit" class="btn btn-secondary btn-block">Déconnexion</button>
				</form>
				<form action="modifier" method="get">
    				<input type="hidden" name="modUtilisateur" />
    				<button type="submit" class="btn btn-secondary btn-block">Modifier</button>
				</form>
				<form action="supprimer" method="POST">
    				<input type="hidden" name="idUtilisateur" />
    				<button type="submit" class="btn btn-secondary btn-block">Supprimer</button>
				</form>
			</div>
		</div>
		<!-- code du composant ici-->	
		</div>
	
	<!-- Puis ajouter les classes de styles au composant, par exemple :
	border-0 rounded-0 bg-transparent -->
	
	
	
	

	<div class="container d-flex justify-content-center mb-5">
		<div class="card border border-black rounded-0 bg-transparent" style="width: 100%;">
		<div class="card-header">
		    Votre restaurant favori
		  </div>
		  <img src="images/jumbotron-bg.jpg" class="card-img-top-smaller border-0 rounded-0 max-h-20" alt="Pizza">
		
		  <div class="card-body text-center my-3">
		    <h4 class="card-text pb-2">Pizza YOLO Chambéry</h4>
		    <a href="restaurant" class="btn btn-outline-dark rounded-pill">Accéder à la page</a>
		    <a href="reservation" class="btn btn-success rounded-pill px-4 mx-2">Réserver</a>
		  </div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/fragments/footer.jsp">
    	<jsp:param name="title" value="${pageTitle}"/>
	</jsp:include>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>











