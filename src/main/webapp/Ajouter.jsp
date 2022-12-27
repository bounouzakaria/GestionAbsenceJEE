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
<h1>Ajouter Professeur</h1>
<form method="POST" action="Ajouter" >
<table border="1">
<tr>
       <td>Nom</td>
       <td><input type="text" name="nom" required></td>

</tr>
<tr>
       <td>Prenom</td>
       <td><input type="text" name="prenom" required></td>

</tr>

<tr>
       <td>Telephone</td>
       <td><input type="text" name="telephone" required></td>

</tr>
<tr>
       <td>email</td>
       <td><input type="text" name="email" required></td>

</tr>
<tr>
       <td>Mot de passe</td>
       <td><input type="password" name="pwd" required></td>

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