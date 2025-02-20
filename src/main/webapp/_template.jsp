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
  	
  	<div class="jumbotron px-2">
	  <div class="container">
	    <div class="row align-items-start">
	      <div class="col-12">
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">Titre sur<br>une image</h1>
	        <a class="btn btn-success btn-lg rounded-pill" href="listeRestaurants" role="button">Bouton</a>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	<div class="container d-flex justify-content-start mt-5">
	    <h1 class="display-4 fw-bold lh-1 pb-3">Titre seul</h1>		
	</div>
	
	
	
	<!-- Pour coller un compostant depuis
	https://getbootstrap.com/docs/5.3/components/
	coller le code du composant à l'intérieur du container suivant : -->
	
	<div class="container d-flex justify-content-center mt-5">
		<!-- code du composant ici-->	
	</div>
	
	<!-- Puis ajouter les classes de styles au composant, par exemple :
	border-0 rounded-0 bg-transparent -->
	
	<div class="container d-flex justify-content-center mt-5">
			<div class="accordion border-0 rounded-0 bg-transparent" id="accordionExample">
			  <div class="accordion-item">
			    <h2 class="accordion-header">
			      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			        Accordion Item #1
			      </button>
			    </h2>
			    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
			      <div class="accordion-body">
			        <strong>This is the first item's accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
			      </div>
			    </div>
			  </div>
			  <div class="accordion-item">
			    <h2 class="accordion-header">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
			        Accordion Item #2
			      </button>
			    </h2>
			    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
			      <div class="accordion-body">
			        <strong>This is the second item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
			      </div>
			    </div>
			  </div>
			  <div class="accordion-item">
			    <h2 class="accordion-header">
			      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
			        Accordion Item #3
			      </button>
			    </h2>
			    <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
			      <div class="accordion-body">
			        <strong>This is the third item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
			      </div>
			    </div>
			  </div>
			</div>
	</div>
	
	
	<div class="container d-flex justify-content-center mt-5">
		<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
		  <div class="card-body text-center">
		    <h5 class="card-title">Créez votre compte</h5>
		    <p class="card-text">Réservez dans tous nos restaurants, recevez des offres spéciales, contactez nos équipes... N'attendez plus pour vous inscrire !</p>
		    <a href="inscription" class="btn btn-success btn-lg rounded-pill px-4">Je m'inscris</a>
		  </div>
		</div>
	</div>
	
	<div class="container d-flex justify-content-center mb-5">
		<div class="card border-0 rounded-0 bg-transparent" style="width: 100%;">
		  <div class="card-body text-center">
		    <p class="card-text">Vous avez déjà un compte ?</p>
		    <a href="connexion" class="btn btn-outline-dark rounded-pill">Je me connecte</a>
		  </div>
		</div>
	</div>
	
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
	
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>