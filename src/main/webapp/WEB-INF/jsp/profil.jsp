<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profil</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Icônes FontAwesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <!-- CSS -->
    <link rel="stylesheet" href="css/styleProfil.css">
</head>
<body>

<!-- CONTAINER UNIQUE -->
<div class="main-container">
    <!-- HEADER -->
    <header class="header">
        <a href="#">
            <img src="logo.png" alt="Logo"> <!-- Remplace "logo.png" par ton logo -->
        </a>
        <a href="logout.jsp">
            <i class="fa fa-user-circle logout-icon"></i> <!-- Icône de déconnexion -->
        </a>
    </header>

    <!-- PROFIL -->
    <div class="text-center">
        <h2 class="profile-header">Bonjour ${utilisateur.prenom }</h2>
        <h4 class="mt-3">Informations de profil</h4>
        <hr>
        <div class="profile-info">
            <p><strong>Nom :</strong> ${utilisateur.nom }</p>
            <p><strong>Prénom :</strong> ${utilisateur.prenom}</p>
            <p><strong>Login :</strong> ${utilisateur.login}</p>
            <p><strong>Email :</strong> ${utilisateur.email}</p>
            <p><strong>Téléphone :</strong> ${utilisateur.telephone}</p> 
        </div>

        <div class="d-grid gap-2 mt-4">
			<form action="/deconnexion" method="POST">
    			<button type="submit" class="btn btn-secondary btn-block">Déconnexion</button>
			</form>
			<form action="/modifier" method="POST">
    			<input type="hidden" name="idUtilisateur" value="<c:out value='${iutilisateur.id}'/>">
    			<button type="submit" class="btn btn-secondary btn-block">Modifier</button>
			</form>
			<form action="/supprimer" method="POST">
    			<input type="hidden" name="idUtilisateur" value="<c:out value='${iutilisateur.id}'/>">
    			<button type="submit" class="btn btn-secondary btn-block">Déconnexion</button>
			</form>
		</div>
    </div>

    <!-- FOOTER -->
    <footer class="footer">
        Pizza Yolo © 2025
    </footer>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
