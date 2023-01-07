<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="Professeurs.dbConnection"%>
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
	
	PreparedStatement pst = cnx.prepareStatement("select id_filliere, libelle_fil from filliere");
	ResultSet rs = pst.executeQuery();



%>


<form action="Update" method="POST">
<table>
<tr><td>ID</td><td><input name="id_classe" value="${id_classe}" readonly/></td></tr>
<tr><td>Nom</td><td><input type="text" name="nom" value="${nom}"/></td></tr>
<tr><td>Filliere</td>
<td><select name="id_filliere">
       <%
       while(rs.next()){
       %>
       <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
       <%
       }
       %>
       </select></td><tr>
       <td><input type="Submit" value="Modifier"/></td></tr>
</table>
</form>

</body>
</html>