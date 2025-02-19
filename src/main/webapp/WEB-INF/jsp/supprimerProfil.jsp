<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Etes-vous sûr de vouloir supprimer votre profil ?</p>
	<form action="supprimer" method="post">
		<input type="hidden" name="idUtilisateur">
		<button type="submit">Oui</button>
</body>
</html>