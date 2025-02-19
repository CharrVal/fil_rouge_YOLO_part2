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
		<fieldset>
			<table>
				<thead>
					<tr>
						<th>Numéro du restaurant</th>
						<th>Nom du restaurant</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><p>Restaurant n° ${restaurant.id }</p></td>
						<td><a href="restaurant?index=${restaurant.id }">${restaurant.nom } </a></td>		
						<td>
							<div class="button-group">
								<form action="listeRestaurants" method="GET">
									<input type="hidden" name="id" value="${restaurant.id }">	
									<input type="submit" value="Afficher les détails">
								</form>
 
								<form action="affichageCarteRestaurant" method="GET">
									<input type="hidden" name="id" value="${Carte.id }">	
									<input type="submit" value="Afficher la carte">
								</form>
 
								<form action="reserverTableRestaurant" method="GET">
									<input type="hidden" name="id" value="${reservation.id }">	
									<input type="submit" value="Réserver une table">
								</form>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</c:forEach>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>