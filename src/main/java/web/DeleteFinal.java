<<<<<<< HEAD
package web;
=======
package module;
>>>>>>> crud-Prof

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
=======
<<<<<<<< HEAD:src/main/java/module/AjouterModuleFinal.java

@WebServlet("/AjouterModule")
public class AjouterModuleFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjouterModuleFinal() {
       
    }

<<<<<<< HEAD:src/main/java/module/AjouterModuleFinal.java

=======
    dbConnection cnx = new dbConnection();
    Connection con = cnx.init();
>>>>>>> crud-module:src/main/java/web/Delete.java
========
>>>>>>> crud-Prof
/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class DeleteFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

<<<<<<< HEAD
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
		
		String id = request.getParameter("user_id");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String mail=request.getParameter("email");
		String password=request.getParameter("pass");
		String telephone=request.getParameter("tel");

		String url = "jdbc:mysql://localhost:3306/gestionabsence";
		  String utilisateur = "root";
		  String motDePasse = "";
		
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

	  PreparedStatement pst = con.prepareStatement("delete from professeur where user_id = ?");
	  pst.setString(1, id);
	 pst.executeUpdate();
	  pst = con.prepareStatement("delete from user where id_user = ?");
	  pst.setString(1, id);
	  pst.executeUpdate();
	  response.sendRedirect("index.jsp");
	  pst.close();
	  con.close();
		  }
		  catch(Exception e) {
		  }
	}
			
			
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
=======
    dbConnection cnx = new dbConnection();
    Connection con = cnx.init();
>>>>>>>> crud-Prof:src/main/java/web/DeleteFinal.java
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			
			String id_filliere = "";
			String libelle = "";
			String id_semestre = "";
			
			
			
<<<<<<<< HEAD:src/main/java/module/AjouterModuleFinal.java
			  try {
<<<<<<< HEAD:src/main/java/module/AjouterModuleFinal.java
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  libelle = request.getParameter("libelle");
				  id_filliere = request.getParameter("fil");
				  id_semestre = request.getParameter("sem");
					  PreparedStatement pst = con.prepareStatement("insert into module(libelle,sem_id,fil_id) values(?,?,?)");
					  pst.setString(1, libelle); 
					  pst.setString(2, id_semestre);
					  pst.setString(3, id_filliere);
=======
========
			
			  try {
>>>>>>>> crud-Prof:src/main/java/web/DeleteFinal.java
				  
				  PreparedStatement pst = con.prepareStatement("delete from professeur where user_id = ?");
				  pst.setString(1, user_id);
				  response.sendRedirect("indexFinal.jsp");
				  pst = con.prepareStatement("select Max(id_user) from user");
				  ResultSet rs = pst.executeQuery();
				  
				  while(rs.next()) {

					  
					  pst = con.prepareStatement("delete from professeur where user_id=?");
					  pst.setString(1, user_id);
>>>>>>> crud-module:src/main/java/web/Delete.java
					  pst.executeUpdate();
<<<<<<<< HEAD:src/main/java/module/AjouterModuleFinal.java
					  response.sendRedirect("index2.jsp");
					  pst.close();
					  con.close();
========
					  response.sendRedirect("indexFinal.jsp");
					  	}
>>>>>>>> crud-Prof:src/main/java/web/DeleteFinal.java
				  
			  }catch (Exception e) {
				  System.out.print(e);
			  }
<<<<<<<< HEAD:src/main/java/module/AjouterModuleFinal.java
		}
			  else{
			response.sendRedirect("auth.jsp");
========
			
			
			
		}else{
			response.sendRedirect("authFinal.jsp");
>>>>>>>> crud-Prof:src/main/java/web/DeleteFinal.java
					}

	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		

}
}
>>>>>>> crud-Prof
