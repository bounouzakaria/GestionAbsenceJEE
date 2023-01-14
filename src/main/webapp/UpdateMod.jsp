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
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<form action="UpdateModule" method="POST">
<table>
<tr>
       <td>Libelle</td>
       <td><input type="text" name="libelle" required></td>

</tr>
<tr>
       <td>Nom_Filiere</td>
       <td>
       <select name="fil" id="id_fil" value="${libelle }/">
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

<tr><td><input type="Submit" value="Modifier"/></td></tr>
</table>
</form>

</body>
</html>