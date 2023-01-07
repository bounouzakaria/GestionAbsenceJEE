<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Professeurs.dbConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" %>
<%@ page import = "java.sql. *"%>
    <%
String login="";
if(session.getAttribute("login")!=null){
	login=session.getAttribute("login").toString();
}else{
	response.sendRedirect("authFinal.jsp");
			}

	dbConnection db = new dbConnection();
	Connection cnx = db.init();
	
	List<String> rl = new ArrayList<String>();
	
	PreparedStatement pst = cnx.prepareStatement("select id_filliere, libelle_fil from filliere");
	ResultSet rs = pst.executeQuery();
	
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
<h1>Ajouter Classe</h1>
<form method="POST" action="Ajouter" >
<table border="1">
<tr>
       <td>Nom</td>
       <td><input type="text" name="nom_classe" required></td>

</tr>
<tr>
       <td>Filliere</td>
       <td><select name="id_filliere">
       <%
       while(rs.next()){
       %>
       <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
       <%
       }
       %>
       </select></td>
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