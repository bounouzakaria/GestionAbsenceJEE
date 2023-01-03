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
<form action="UpdateEmp" method="POST">
<table>
<tr><td>ID</td><td><input name="id_emploi_temps" value="${id_emploi_temps}" readonly/></td></tr>
<tr><td>Titre</td><td><input type="year" id="id_t" name="titre" value="${titre}"
       min="2018-01-01" max="2030-12-31">
</td></tr>
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

<tr><td><input type="Submit" value="Modifier"/></td></tr>
</table>
</form>

</body>
</html>