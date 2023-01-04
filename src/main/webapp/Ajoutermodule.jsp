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


String url = "jdbc:mysql://localhost:3306/gestionabsence";
String utilisateur = "root";
String motDePasse = "";
int number=0;
try {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
	  PreparedStatement pst = con.prepareStatement("select id_filliere, libelle_fil from filliere");
	ResultSet rs=pst.executeQuery();
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
       <td>
       <select name="fil" id="id_fil">
       <%
  	 while(rs.next()){
		%>
		  <option value="<%= rs.getString(1)%>"><%= rs.getString(2)%></option>
		<%
  	 }
       %>
		</select>
       </td>

</tr>
<tr>
       <td>Nom_Semestre</td>
       <td><select name="sem" id="id_sem">
       <%
       	pst = con.prepareStatement("select id_semestre, nom_semestre from semestre order by nom_semestre");
   		rs = pst.executeQuery();
  	 while(rs.next()){
		%>
		  <option value="<%= rs.getString(1)%>"><%= rs.getString(2)%></option>
		<%
  	 }
}
       catch(Exception e){
    	   
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