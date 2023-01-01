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
<title>Page d'accueil</title>


</head>
<body>
<div>
<p> Liste des Etudiants</p>
<a href="Logout">Logout</a>
</div>
<h1>Liste des Etudiants</h1>
<table border="1" width="100%" >
       <tr> 
       
       <th> ID</th>
        <th>Prenom </th>
        <th>Nom </th>
         <th>Classe</th>
         <th>Email</th>
         <th>Password</th>
           <th>Action</th>
           <th>Action2</th>
       
       </tr>
       <%
       String url = "jdbc:mysql://localhost:3306/gestionabsence";
		  String utilisateur = "root";
		  String motDePasse = "";
		  int number=0;
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
			  PreparedStatement pst = con.prepareStatement("select * from etudiant");
			ResultSet rs=pst.executeQuery();
			 while(rs.next()){
				 PreparedStatement pst2 = con.prepareStatement("SELECT * from user where email_user=?");
				 pst2.setString(1, rs.getString(4));
				 ResultSet rs1 = pst2.executeQuery();
				 %>
	<tr> 
		<td><%=rs.getString(1)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(2)%></td>
        <%
        	pst = con.prepareStatement("select nom_classe from classe where id_classe=?");
        	pst.setString(1, rs.getString(5));
        	ResultSet rs3= pst.executeQuery();
        	while (rs3.next()){
        %>
        <td><%=rs3.getString(1) %></td>
         <%
        	}
         while(rs1.next()){
        	 %>
		<td><%=rs1.getString(2)%></td>
		<td><%=rs1.getString(3)%></td>  
		<%      	 
         }
         %>
         <!--  Voici l'erreur -->
          <td> <a href="Delete?email_user=<%=rs.getString(4)%>">Supprimer</a></td>
          <td> <a href="Update?id_etud=<%=rs.getString(1)%>&email_user=<%=rs.getString(4)%>">modifier</a></td>
        		
    </tr>	        		 
		<%
			 }
			pst = con.prepareStatement("select count(*) from etudiant");
			rs=pst.executeQuery();
			rs.next();
			
			number=rs.getInt(1);
			  rs.close();
			  con.close();
			  pst.close();
			  
		  }catch (Exception e) {
			  System.out.print(e);
		  }
       %>
</table>
Nombre total de classes :<%=number %><br>
<a href="Ajouter.jsp">Ajouter Classe</a>


</body>
</html>