<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateFiliere" method="POST">
<table>
<tr><td>ID</td><td><input name="id_filliere" value="${id_filliere}" readonly/></td></tr>
<tr><td>Nom_Filiere</td><td><input type="text" name="filiere" value="${filiere}"/></td></tr>
<tr><td><input type="Submit" value="Modifier"/></td></tr>
</table>
</form>


</body>
</html>