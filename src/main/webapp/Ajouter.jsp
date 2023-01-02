<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.dbConnection"%>
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

	dbConnection db = new dbConnection();
	Connection cnx = db.init();
	
	List<String> rl = new ArrayList<String>();
	
	PreparedStatement pst = cnx.prepareStatement("select id_classe, nom_classe from classe");
	ResultSet rs = pst.executeQuery();
	String v = "3";
	v = (String) request.getAttribute("v");
	
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
<h1>Ajouter Absence</h1>
<table border="1">
<tr>
<form method="GET" action="Classe" >
       <td>Classe</td>
       <td><select name="id_classe">
       <%
       while(rs.next()){
    	   String result = rs.getString(1);
    	   if(result.equals(v)){
       %>
       <option value="<%=rs.getString(1)%>" selected><%=rs.getString(2)%></option>
       <%
    	   }
    	   else{
    		   %>
    	       <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
    	       <%  
    	   }
       }
       %>
       </select></td>
       <td><input type="submit" value="Chercher liste etudiants"/></td>
		</form>
</tr>
<form method="POST" action="Ajouter" >
<tr>
       <td>Etudiant</td>
       <td><select name="id_etudiant">
       <%if(v != null){
       pst = cnx.prepareStatement("select id_etudiant, prenom_etud, nom_etud from etudiant where id_classe= ?");
       pst.setString(1, v);
       rs = pst.executeQuery();
       while(rs.next()){
       %>
       <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%> <%=rs.getString(2)%></option>
       <%
       }
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