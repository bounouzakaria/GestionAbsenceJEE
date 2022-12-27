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
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String telephone=request.getParameter("telephone");
			String email = request.getParameter("email");
			String pass = request.getParameter("pwd");
			int user_id = 0;
			
			
			
			  String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  System.out.println(email + " " + pass);
				  PreparedStatement pst = con.prepareStatement("insert into user(email_user, pass_user) values (?, ?)");
				  pst.setString(1, email);
				  pst.setString(2, pass);
				  pst.executeUpdate();
				  
				  pst = con.prepareStatement("select Max(id_user) from user");
				  ResultSet rs = pst.executeQuery();
				  while(rs.next()) {
					  user_id = rs.getInt(1);
					  pst = con.prepareStatement("insert into professeur(nom_prof,prenom_prof,telephone_prof,user_id) values(?,?,?,?)");
					  pst.setString(1, nom); 
					  pst.setString(2, prenom);
					  pst.setString(3, telephone); 
					  pst.setInt(4, user_id);
					  pst.executeUpdate();
					  response.sendRedirect("index.jsp");
					  pst.close();
					  con.close();
				  }
				  
			  }catch (Exception e) {
				  System.out.print(e);
				  
			  }
			
			
			
		}else{
			response.sendRedirect("auth.jsp");
					}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
