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
<p> Emploi du temps</p>
<a href="Logout">Logout</a>
</div>
<h1>Emploi du temps</h1>
<table border="1" width="100%" >
       <tr> 
       
       <th> ID</th>
        <th> titre </th>
           <th> Semestre </th>
        
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
			  PreparedStatement pst = con.prepareStatement("select * from emploi_temps");
			ResultSet rs=pst.executeQuery();
			 while(rs.next()){
				 PreparedStatement pst2 = con.prepareStatement("SELECT * from semestre where id_semestre=" + rs.getString(3));
				 ResultSet rs1 = pst2.executeQuery();

				 %>
	
         <%
         while(rs1.next()){
        	 %>
	<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs1.getString(2)%></td> 
		<td><a href="DeleteEmp?id_semestre=<%=rs1.getString(1) %>">Supprimer</a></td>
         <td><a href="UpdateEmp?id_emploi_temps=<%=rs1.getString(1) %>">modifier</a></td>
   </tr>
		<%      	 
         } %>
          	 
		<%
			 }
			pst = con.prepareStatement("select count(*) from emploi_temps");
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
Nombre total d'emploi du temps:<%=number %><br>
<a href="AjouterEmp.jsp">Ajouter Emploi du temps</a>


</body>
</html>