package web;

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

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			  String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
					String id = request.getParameter("id_etud");
					String email1 = request.getParameter("email_user");
					int id_1 = 0;
					String nom = null, prenom= null, email= null, classe= null, pass= null;
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				PreparedStatement pst1 = con.prepareStatement("SELECT * FROM etudiant where id_etudiant=?");
				pst1.setInt(1, Integer.parseInt(id));
				ResultSet rs = pst1.executeQuery();				
				while(rs.next()) {
					nom = rs.getString(3);
					prenom = rs.getString(2);
					classe = rs.getString(5);
					pst1 = con.prepareStatement("SELECT * FROM user where email_user=?");
					pst1.setString(1, rs.getString(4));
					ResultSet rs1 = pst1.executeQuery();
					while(rs1.next()) {
						email = rs.getString(2);
						pass = rs.getString(3);
					}
				}
				request.setAttribute("email1", email);
				request.setAttribute("id", id);
				request.setAttribute("nom", nom);
				request.setAttribute("prenom", prenom);
				request.setAttribute("email", email);
				request.setAttribute("pass", pass);
				request.getRequestDispatcher("UpdatePage.jsp").forward(request, response);
			  }catch (Exception e) {
				  System.out.print(e);
				  
			  }
		}else{
			response.sendRedirect("auth.jsp");
					}
	
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String id = request.getParameter("user_id");
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String mail=request.getParameter("email");
			String mail1=request.getParameter("email1");
			String password=request.getParameter("pass");
			String id_classe=request.getParameter("id_classe");


			String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

		  PreparedStatement pst = con.prepareStatement("UPDATE etudiant SET nom_etud= ?, prenom_etud= ?, email_etud= ?, id_classe= ? where id_etudiant= ?");
		  pst.setString(1, nom); 
		  pst.setString(2, prenom);
		  pst.setString(3, mail); 
		  pst.setString(4, id_classe);
		  pst.setString(5, id);
		  
		  pst.executeUpdate();
		  pst = con.prepareStatement("UPDATE user SET email_user = ?, pass_user = ? where email_user = ?");
		  pst.setString(1, mail);
		  pst.setString(2, password);
		  pst.setString(3, mail1);
		  pst.executeUpdate();
		  response.sendRedirect("index.jsp");
		  pst.close();
		  con.close();
			  }
			  catch(Exception e) {
			  }
		}
}
