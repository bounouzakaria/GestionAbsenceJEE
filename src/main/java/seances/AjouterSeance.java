package seances;

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
@WebServlet("/AjouterSeance")
public class AjouterSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterSeance() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("LoginSeance")!=null){
			String id_seance = "";
			String date_seance = "";
			String type = "";
			String horaire_deb = "";
			String horaire_fin = "";
			String enseignement_id = "";
			


			String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  date_seance = request.getParameter("date_seance");
				  type = request.getParameter("type");
				  horaire_deb = request.getParameter("horaire_deb");
				  horaire_fin = request.getParameter("horaire_fin");
				  enseignement_id = request.getParameter("enseignement_id");
				  PreparedStatement pst =  ((Connection) con).prepareStatement("insert into seance(date_seance,type,horaire_deb,horaire_fin,enseignement_id) values(?,?,?,?,?)");
					  pst.setString(1, date_seance); 
					  pst.setString(2, type);
					  pst.setString(3, horaire_deb);
					  pst.setString(4, horaire_fin);
					  pst.setString(5, enseignement_id);
					  pst.executeUpdate();
					  response.sendRedirect("IndexSeance.jsp");
					  pst.close();
					  ((Connection) con).close();

			  }catch (Exception e) {
				  System.out.print(e);
			  }
		}
			  else{
			response.sendRedirect("Authentification.jsp");
					}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
