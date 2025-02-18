<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizza Yolo</title>
</head>
<body>
<h1>YOLO</h1>
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
						<td>${restaurant.nom }</td>		
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
</body>
</html>