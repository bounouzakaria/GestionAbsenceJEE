 <%@ page language="java" %>
<%@ page import = "java.sql. *"%>
<%
String login="";
if(session.getAttribute("LoginSeance")!=null){
	login=session.getAttribute("LoginSeance").toString();
}else{
	response.sendRedirect("auth.jsp");
			}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<p> Liste des modules</p>
<a href="Logout">Logout</a>
</div>
<h1>Liste des modules</h1>
<table border="1" width="100%" >
       <tr> 
       
       <th> ID</th>
        <th> Date Seance </th>
         <th>Type</th>
         <th>Heure Debut</th>
         <th>Heure Fin</th>
         <th>ID Ensegnement</th>
         
         
                    <th>Action</th>
           <th>Action2</th>
       
       </tr>
       <%
       String url = "jdbc:mysql://localhost:3306/gestionabsence?characterEncoding=utf8";
		  String utilisateur = "root";
		  String motDePasse = "";
		  int number=0;
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
			  PreparedStatement pst = con.prepareStatement("select * from seance");
			  
			ResultSet rs=pst.executeQuery();
			 while(rs.next()){
				 
				 PreparedStatement pst2 = con.prepareStatement("SELECT date_seance from seance where id_seance= ?");
				 pst2.setString(1,rs.getString(4));
				 PreparedStatement pst3 = con.prepareStatement("SELECT nom_enseignemtn from enseignement where id_enseignement= ?");
				 pst3.setString(1, rs.getString(3));
				 ResultSet rs1 = pst2.executeQuery();
				 
				 ResultSet rs2 = pst3.executeQuery();
				 while(rs1.next() && rs2.next()){
				 %>

         <%
         while(rs1.next() && rs2.next()){
        	 %>

	<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs1.getString(2)%></td> 
		<td><%=rs2.getString(2)%></td> 
		<td><a href="DeleteSeance?id_seance=<%=rs.getString(1) %>">Supprimer</a></td>
         <td><a href="UpdateSeance?id_seance=<%=rs.getString(1) %>">modifier</a></td>
   </tr>
		<%      	 
         } %>

		<td><%=rs1.getString(1)%></td> 
		<td><%=rs2.getString(1)%></td> 
		<td><a href="DeleteSeance?id_seance=<%=rs.getString(1) %>">Supprimer</a></td>
         <td><a href="UpdateSeance?id_seance=<%=rs.getString(1) %>">modifier</a></td>
   </tr>  	 
		<%
				 }
			 }
			pst = con.prepareStatement("select count(*) from seance");
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
Nombre total de modules :<%=number %><br>
<a href="AjouterSeance.jsp">Ajouter Seances</a>
