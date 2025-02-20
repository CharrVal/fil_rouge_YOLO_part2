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

	<%@ include file="/WEB-INF/fragments/header.jspf"%>
        		
	<div class="container d-flex justify-content-center mt-5">
	     <h2 class="display-4 fw-bold lh-1 pb-3">Supprimez votre profil</h2>
	</div>
	
	<div class="card text-center mb-3" style="width: 18rem; margin: auto;">
		<div class="card-body" style="color: #B10000; border: 2px solid #B10000; padding: 5px;">
			<h5 class="card-title">Attention</h5>
			<p class="card-text">Voulez-vous vraiment supprimer votre compte?</p>
		</div>
	</div>
	
	<div class="container d-flex justify-content-center">
		<div class="col-md-12 mt-3 text-center">
			<form action="supprimer" method="post">
				<button type="submit" class="btn btn-outline-dark rounded-pill">Confirmer la suppression</button>
			</form>
		</div>
	</div>
	
	<div class="container d-flex justify-content-center mb-2">
		<div class="col-md-12 mt-3 text-center">
			<form action="profil" method="get">
				<button type="submit" class="btn btn-success rounded-pill px-4 mx-2">Retour à votre profil</button>
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


