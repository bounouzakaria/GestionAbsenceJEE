<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="web.dbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<%
	dbConnection db = new dbConnection();
	Connection cnx = db.init();
	
	List<String> rl = new ArrayList<String>();
	
	PreparedStatement pst = cnx.prepareStatement("select id_classe, nom_classe from classe");
	ResultSet rs = pst.executeQuery();
	


%>

<form action="Update" method="POST">
<table>
<td><input name="email1" readonly value="${email1}" type="hidden"></td>
<tr><td>ID</td><td><input name="user_id" value="${id}" readonly/></td></tr>
<tr><td>Nom</td><td><input type="text" name="nom" value="${nom}"/></td></tr>
<tr><td>Prenom</td><td><input type="text" name="prenom" value="${prenom}"/></td></tr>
<tr><td>Email</td><td><input type="text" name="email" value="${email}"/></td></tr>
<tr><td>Mot de passe</td><td><input type="text" name="pass" value="${pass}"/></td></tr>
<tr><td>Classe</td>
<td><select name="id_classe">
       <%
       while(rs.next()){
       %>
       <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
       <%
       }
       %>
       </select></td><tr>

<tr><td><input type="Submit" value="Modifier"/></td></tr>
</table>
</form>

</body>
</html>