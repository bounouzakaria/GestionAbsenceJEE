<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<form action="Update" method="POST">
<table>
<tr><td>ID</td><td><input name="user_id" value="${id_1}" readonly/></td></tr>
<tr><td>Nom</td><td><input type="text" name="nom" value="${nom}"/></td></tr>
<tr><td>Prenom</td><td><input type="text" name="prenom" value=" ${prenom}"/></td></tr>
<tr><td>Tel</td><td><input type="text" name="tel" value="${tel}"/></td></tr>
<tr><td>Email</td><td><input type="text" name="email" value="${email}"/></td></tr>
<tr><td>Mot de passe</td><td><input type="text" name="pass" value="${pass}"/></td></tr>
<tr><td><input type="Submit" value="Modifier"/></td></tr>
</table>
</form>

</body>
</html>