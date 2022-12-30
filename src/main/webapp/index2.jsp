
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
        <th> LIBELLE </th>
         <th>Nom_filiere</th>
         <th>Nom_semestre</th>
         
         
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
			  PreparedStatement pst = con.prepareStatement("select * from module");
			ResultSet rs=pst.executeQuery();
			 while(rs.next()){
				 PreparedStatement pst2 = con.prepareStatement("SELECT * from filliere where id_filliere=" + rs.getString(4));
				 ResultSet rs1 = pst2.executeQuery();
				 PreparedStatement pst3 = con.prepareStatement("SELECT * from semestre where id_semestre=" + rs.getString(3));
				 ResultSet rs2 = pst3.executeQuery();
				 %>
	
         <%
         while(rs1.next() && rs2.next()){
        	 %>
	<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs1.getString(2)%></td> 
		<td><%=rs2.getString(2)%></td> 
		<td><a href="DeleteModule?id_semestre=<%=rs1.getString(1) %>">Supprimer</a></td>
         <td><a href="UpdateModule?id_module=<%=rs2.getString(1) %>">modifier</a></td>
   </tr>
		<%      	 
         } %>
          	 
		<%
			 }
			pst = con.prepareStatement("select count(*) from module");
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
<a href="Ajoutermodule.jsp">Ajouter Modules</a>


</body>
</html>