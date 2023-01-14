<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
<p> Liste des Classes</p>
<a href="Logout">Logout</a>
</div>
<h1>Liste des Classes</h1>
<table border="1" width="100%" >
       <tr> 
       
       <th> ID</th>
        <th>Nom classe</th>
        <th>Nom Filliere</th>
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
			  PreparedStatement pst = con.prepareStatement("select * from classe");
			ResultSet rs=pst.executeQuery();
			 while(rs.next()){
				 PreparedStatement pst2 = con.prepareStatement("SELECT libelle_fil from filliere where id_filliere= ?");
				 pst2.setString(1, rs.getString(3));
				 ResultSet rs1 = pst2.executeQuery();
				 %>
	<tr> 
		<td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
         <%
         while(rs1.next()){
        	 %>
		<td><%=rs1.getString(1)%></td>  
		<%      	 
         }
         %>
<<<<<<< HEAD
          <td> <a href="Delete?id_classe=<%=rs.getString(1)%>">Supprimer</a></td>
          <td> <a href="Update?id_classe=<%=rs.getString(1)%>">modifier</a></td>
    </tr>	        		 
		<%
=======
          <td> <a href="Delete?user_id=<%=rs.getString(1) %>">Supprimer</a></td>
          <td> <a href="Update?id_prof=<%=rs.getString(1) %>">modifier</a></td>
        
          
          
				
    </tr>
			        
				 
				 <%
>>>>>>> 30431efdcab9730e051cc63e3ecf580041621958
			 }
			pst = con.prepareStatement("select count(*) from classe");
			rs=pst.executeQuery();
			rs.next();
			
			number=rs.getInt(1);
			  rs.close();
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