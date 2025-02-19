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
	        <h1 class="display-4 fw-bold lh-1 text-white pb-3">${restaurant.nom}</h1>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="container d-flex justify-content-start mt-5">
	    <h1 class="display-4 fw-bold lh-1 pb-3">${carte.nom}</h1>		
	</div>
	
	<c:forEach items="${carte.plats}" var="plat" varStatus="status">
		<h2>${plat.categorie.libelle}</h2>
		<p>${plat.nom}.......${plat.prix}</p>
		<p>${plat.description}</p>
	</c:forEach>
	
	<div>
		<form action="inscription" method="GET">	
			<input type="submit" value="Inscrivez-vous pour réserver">
		</form>
	</div>
	<div>
		<a href="connexion">Vous avez déjà un compte</a>
	</div>
	<div>
		<form action="restaurant" method="GET">
			<input type="hidden" name="index" value="${restaurant.id }">	
			<input type="submit" value="Retour au détail du restaurant">
		</form>
 	</div>
	
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>