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
<title>Insert title here</title>
</head>
<body>
<div>
<a href="Logout">Logout</a>
</div>
<h1>Ajouter Module</h1>
<form method="POST" action="AjouterModule" >
<table border="1">

<tr>
       <td>Libelle</td>
       <td><input type="text" name="libelle" required></td>

</tr>

<tr>
       <td>Nom_Filiere</td>
       <td><input type="text" name="filiere" required></td>

</tr>
<tr>
       <td>Nom_Semestre</td>
       <td><input type="text" name="semestre" required></td>

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