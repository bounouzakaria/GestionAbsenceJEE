<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page language="java" %>
<%@ page import = "java.sql. *"%>

<%
String login="";
if(session.getAttribute("login")!=null){
	login=session.getAttribute("login").toString();
}else{
	response.sendRedirect("authFinal.jsp");
			}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="indexFinal.jsp">Page professeur</a><br>
<a href="index2.jsp">Page module</a><br>
<a href="index3.jsp">Page Filiere</a><br>
<a href="IndexSeance.jsp">Page Seances</a><br>
<a href="indexClasse.jsp">Page Classes</a>

</body>
</html>