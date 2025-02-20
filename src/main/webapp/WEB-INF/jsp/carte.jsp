<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	
	<div class="shade">
		<div class="blackboard">
			<div class="text-center my-5">
				<c:set var="categoriesAffichees" value="" />
				 
				<c:forEach items="${carte.plats}" var="plat">
				    <c:if test="${not fn:contains(categoriesAffichees, plat.categorie.libelle)}">
				        <h2>${plat.categorie.libelle}</h2>
				        
				        <c:set var="categoriesAffichees" value="${categoriesAffichees},${plat.categorie.libelle}" />
				
				        <c:forEach items="${carte.plats}" var="p">
				            <c:if test="${p.categorie.libelle == plat.categorie.libelle}">
				                <div class="plat">
								    <span class="nom-plat">${p.nom}</span>
								    <span class="ligne-point"></span>
								    <span class="prix-plat">${p.prix} €</span>
								</div>
								<p class="description-plat">${p.description}</p>
				            </c:if>
				        </c:forEach>
				    </c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	
		<div class="card-body text-center my-3">
			<form action="reservation" method="GET">
				<input type="hidden" name="id" value="${reservation.id}">
				<input  type="submit" value="Réservez" class="btn btn-outline-dark rounded-pill">
			</form>
		</div>
		<div class="card-body text-center my-3">
			<form action="listeRestaurants" method="GET">
				<input type="hidden" name="id" value="${restaurant.id}">	
				<input type="submit" value="Retour à la liste de restaurants" class="btn btn-outline-dark rounded-pill">
			</form>
 		</div>
	
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>