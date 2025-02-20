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
	
	<c:forEach var="restaurant" items="${listeRestaurants }">
		<div class="container d-flex justify-content-center mb-5">
			<div class="card border border-black rounded-0 bg-transparent " style="width: 100%;">
			  <img src="${restaurant.url_image}" class="card-img-top-smaller border-0 rounded-0 max-h-20" alt="Pizza">
			  <div class="card-body text-center my-3">
			    <h4 class="card-text pb-2">${restaurant.nom}</h4>
			    <a href="restaurant?index=${restaurant.id }" class="btn btn-outline-dark rounded-pill">Accéder à la page</a>
			    <a href="reservation?idRestaurant=${restaurant.id }" class="btn btn-success rounded-pill px-4 mx-2">Réserver</a>
		  	</div>
		  	</div>
		 </div>
	</c:forEach>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>