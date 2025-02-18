<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
</head>
<body>
	<fieldset>
		<table>
			<thead>
				<tr>
					<th>Profil</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><p>Profil de ${utilisateur.prenom } ${utilisateur.nom }</p></td>
					<td>
						<div class="button-group">
							<form action="deconnexion" method="GET">
								<input type="hidden" name="id" value="${utilisateur.id }">
								<input type="submit" value="Modifier le profil">
							</form>
							<form action="modifierProfil" method="GET">
								<input type="hidden" name="id" value="${utilisateur.id }">
								<input type="submit" value="Modifier le profil">
							</form>
							<form action="supprimerProfil" method="GET">
								<input type="hidden" name="id" value="${utilisateur.id }">
								<input type="submit" value="Supprimer le profil">
							</form>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</fieldset>

</body>
</html>