<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript">
	let v = 4;
</script>
<div>
<p> Liste d'absence</p>
<a href="Logout">Logout</a>
</div>
<h1>Liste d'absence</h1>
<table border="1" width="100%" >
<tr><td>Selectionner Classe</td>
       <form action="Classe">
       <td>
       	<select name="classe" onchange="{(e)=>v = e.target.value}">
<%
       String url = "jdbc:mysql://localhost:3306/gestionabsence?characterEncoding=utf8";
		  String utilisateur = "root";
		  String motDePasse = "";
		  int number=0;
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
			  PreparedStatement pst = con.prepareStatement("select id_classe, nom_classe from classe");
			  ResultSet rs=pst.executeQuery();
			  while(rs.next()){
			%>
			<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
		<%} %>
       	</select>
       </td>
       <td><input type="submit" value="Chercher"/></td>
       </form>
       </tr>
       <tr> 
       <th>ID</th>
        <th>Absence</th>
        <th>Seance</th>
        <th>Etudiant</th>
        <th>Classe</th>
       </tr>
       <%	String v = (String) request.getAttribute("v");
       		if(v != null){
       			System.out.println(v);
       		pst = con.prepareStatement("select * from absence");
		   	rs=pst.executeQuery();
		 	 while(rs.next()){
		 		if(rs.getString(5).equals(v)){
		 		 PreparedStatement rs2 = con.prepareStatement("select nom_classe from classe where id_classe= ?");
		 		 rs2.setString(1, rs.getString(5));
		 		 ResultSet r = rs2.executeQuery();
		 		 while(r.next()){
				 %>
	<tr> 
		<td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(4)%></td>
        <td><%=r.getString(1)%></td>
    </tr>	        		 
		<%
		
		 		 }
       }
		 	 }		 	
       		}
       		else {
           		PreparedStatement pst3 = con.prepareStatement("select * from absence");
    		   	ResultSet rs3=pst3.executeQuery();
    		 	 while(rs3.next()){
    		 		 PreparedStatement rs4= con.prepareStatement("select nom_classe from classe where id_classe= ?");
    		 		 rs4.setString(1, rs3.getString(5));
    		 		 ResultSet r5 = rs4.executeQuery();
    		 		 while(r5.next()){
    				 %>
    	<tr> 
    		<td><%=rs3.getString(1)%></td>
            <td><%=rs3.getString(2)%></td>
            <td><%=rs3.getString(3)%></td>
            <td><%=rs3.getString(4)%></td>
            <td><%=r5.getString(1)%></td>
        </tr>
        <%
       } 
       		}
       		}
			pst = con.prepareStatement("select count(*) from absence");
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
Nombre total d'absences:<%=number%><br>
<a href="Ajouter.jsp">Ajouter Absence</a>


</body>
</html>