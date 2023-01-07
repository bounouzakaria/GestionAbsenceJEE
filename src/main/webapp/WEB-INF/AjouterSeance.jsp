<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" %>
<%@ page import = "java.sql. *"%>
    <%
String login="";
if(session.getAttribute("login")!=null){
	login=session.getAttribute("login").toString();
}else{
	response.sendRedirect("auth.jsp");
			}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Seance</title>
</head>
<body>
<div>
<a href="Logout">Logout</a>
</div>
<h1>Ajouter Seance</h1>
<form method="POST" action="AjouterSeance" >
<table border="1">
<tr>
       <td>Date de Seance</td>
       <td><input type="text" name="Date de Seance" required></td>

</tr>
<tr>
       <td>type seance</td>
       <td><input type="text" name="type seance" required></td>

</tr>

<tr>
       <td>Heure Debut</td>
       <td><input type="text" name="Heure Debut" required></td>

</tr>
<tr>
       <td>Heure Fin</td>
       <td><input type="text" name="Heure Fin" required></td>

</tr>
<tr>
       <td>id ensegnement</td>
       <td><input type="password" name="id ensegnement" required></td>

</tr>
<tr>
       <td>Envoyer</td>
       <td><input type="submit" value="Enregistrer" required></td>
        <td><input type="reset" value="Retablir" required></td>

</tr>
</table>
</form>

</body>
</html>