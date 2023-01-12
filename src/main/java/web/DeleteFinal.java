<<<<<<< HEAD
package web;
=======
package module;
>>>>>>> ea599b86d3a96289d127b633da732df12bcf035f

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


========
>>>>>>> ea599b86d3a96289d127b633da732df12bcf035f
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
>>>>>>>> ea599b86d3a96289d127b633da732df12bcf035f:src/main/java/web/DeleteFinal.java
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			
			String id_filliere = "";
			String libelle = "";
			String id_semestre = "";
			
			
			
			  try {
<<<<<<<< HEAD:src/main/java/module/AjouterModuleFinal.java
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  libelle = request.getParameter("libelle");
				  id_filliere = request.getParameter("fil");
				  id_semestre = request.getParameter("sem");
					  PreparedStatement pst = con.prepareStatement("insert into module(libelle,sem_id,fil_id) values(?,?,?)");
					  pst.setString(1, libelle); 
					  pst.setString(2, id_semestre);
					  pst.setString(3, id_filliere);
========
				  
				  PreparedStatement pst = con.prepareStatement("delete from professeur where user_id = ?");
				  pst.setString(1, user_id);
				  response.sendRedirect("index.jsp");
				  pst = con.prepareStatement("select Max(id_user) from user");
				  ResultSet rs = pst.executeQuery();
				  
				  while(rs.next()) {

					  
					  pst = con.prepareStatement("delete from professeur where user_id=?");
					  pst.setString(1, user_id);
>>>>>>>> ea599b86d3a96289d127b633da732df12bcf035f:src/main/java/web/DeleteFinal.java
					  pst.executeUpdate();
					  response.sendRedirect("index2.jsp");
					  pst.close();
					  con.close();
				  
			  }catch (Exception e) {
				  System.out.print(e);
			  }
		}
			  else{
			response.sendRedirect("auth.jsp");
					}

	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		

}
}
>>>>>>> ea599b86d3a96289d127b633da732df12bcf035f
