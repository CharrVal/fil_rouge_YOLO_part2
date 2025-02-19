<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${restaurant.nom}</h1>
		<div>
			<form action="inscription" method="GET">	
				<input type="submit" value="Inscrivez-vous pour réserver">
			</form>
		</div>
		
		<h2>Nos horaires</h2>
			<p>horaire : ${restaurant.horaire}</p>
</body>
</html>