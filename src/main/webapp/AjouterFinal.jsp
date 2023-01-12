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
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">
    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>
<body>
<div>
</div>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Ajouter un Professeur</h2>
<form method="POST" action="Ajouter" >
           <div class="row row-space">
               <div class="col-2">
                   <div class="input-group">
                       <label class="label">Nom</label>
                       <input class="input--style-4" name="nom" type="text">
                   </div>
               </div>
               <div class="col-2">
                   <div class="input-group">
                       <label class="label">Prenom</label>
                       <input class="input--style-4" name="prenom" type="text">
                   </div>
               </div>
           </div>
               <div class="col">
                   <label class="label">Telephone</label>
                   <input class="input--style-4" name="tel" type="text">
               </div>
           <div class="row row-space">
               <div class="col-2">
                   <div class="input-group">
                       <label class="label">Email</label>
                       <input class="input--style-4" type="email" name="email">
                   </div>
               </div>
               <div class="col-2">
                   <div class="input-group">
                       <label class="label">Mot de Passe</label>
                       <input class="input--style-4" type="password" name="pass">
                   </div>
               </div>
           </div>
           <div class="p-t-15">
               <button class="btn btn--radius-2 btn--blue" type="submit">Enregistrer</button>
            </div>
</form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>
</body>
</html>