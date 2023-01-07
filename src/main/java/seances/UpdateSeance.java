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

@WebServlet("/UpdateSeance")
public class UpdateSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public UpdateSeance() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			 
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  String id_seance = request.getParameter("id_seance");
					int enseignement_id = 0;
					
					String date_seance=null ,type = null, horaire_deb=null,horaire_fin =null; 
					
					
					
				  
				PreparedStatement pst1 = ((Connection) con).prepareStatement("SELECT * FROM Seance where id_seance=?");
				pst1.setInt(1, Integer.parseInt(id_seance));
				ResultSet rs = pst1.executeQuery();				
				while(rs.next()) {
					date_seance = rs.getString(1);
					enseignement_id = rs.getInt(5);
					pst1 = ((Connection) con).prepareStatement("SELECT nom_enseignemtn from enseignement where id_enseignement= ?");
					pst1.setInt(1, enseignement_id);
					
					ResultSet rs1 = pst1.executeQuery();
					while(rs1.next()) {
						type = rs.getString(2);
						horaire_deb = rs.getString(3);
						horaire_fin=rs.getString(4);
					}
				}
				request.setAttribute("enseignement_id", enseignement_id);
				request.setAttribute("date_seance", date_seance);
				request.setAttribute("type", type);
				request.setAttribute("horaire_deb",horaire_deb);
				request.setAttribute("horaire_fin",horaire_fin);
				request.getRequestDispatcher("UpdateSeance.jsp").forward(request, response);
			  }catch (Exception e) {
				  System.out.print(e);

			  }
		}else{
			response.sendRedirect("IndexSeance.jsp");
					}

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id_seance = request.getParameter("id_seance");
		String date_seance = request.getParameter("date_seance");
		String type = request.getParameter("type");
		String horaire_deb = request.getParameter("horaire_deb");
		String horaire_fin = request.getParameter("horaire_fin");
		String enseignement_id = request.getParameter("enseignement_id");


			

		  try {
				 

			  PreparedStatement pst = ((Connection) con).prepareStatement("delete from seance where id_seance = ? ");
			  pst.setString(1, id_seance);
			 pst.executeUpdate();
			  pst = ((Connection) con).prepareStatement("delete from ensei where id_semestre = ?");
			  pst.setString(1, enseignement_id);
			  pst.executeUpdate();
			 
			  response.sendRedirect("IndexSeance.jsp");
			  pst.close();
			  ((Connection) con).close();
				  }
				  catch(Exception e) {
				  }
			}

}