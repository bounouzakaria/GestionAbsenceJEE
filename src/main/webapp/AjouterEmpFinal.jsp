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
	  PreparedStatement pst = con.prepareStatement("select id_semestre, nom_semestre from semestre");
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
<h1>Ajouter Emploi du temps</h1>
<form method="POST" action="AjouterEmp" >
<table border="1">

<tr>
       <td>Titre</td>
       <td><input type="year" id="id_t" name="titre"
       value="2022"
       min="2018" max="2030">
</td>

</tr>

<tr>
       <td>Nom_Semestre</td>
       <td><select name="sem" id="id_semestre">
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