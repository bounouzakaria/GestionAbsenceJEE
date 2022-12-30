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
<tr><td>ID</td><td><input name="fil_id" value="${id_1}" readonly/></td></tr>
<tr><td>libelle</td><td><input type="text" name="libelle" value="${libelle}"/></td></tr>
<tr><td>Semestre</td><td><input type="text" name="filiere" value=" ${filiere}"/></td></tr>
<tr><td>Filiere</td><td><input type="text" name="semestre" value="${semestre}"/></td></tr>

<tr><td><input type="Submit" value="Modifier"/></td></tr>
</table>
</form>

</body>
</html>