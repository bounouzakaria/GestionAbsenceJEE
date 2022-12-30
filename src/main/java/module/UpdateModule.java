package module;

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

@WebServlet("/UpdateModule")
public class UpdateModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateModule() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			  String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
					String id = request.getParameter("id_module");
					int id_1 = 0;
					String libelle = null, filiere= null, semestre= null;
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				PreparedStatement pst1 = con.prepareStatement("SELECT * FROM module where id_module=?");
				pst1.setInt(1, Integer.parseInt(id));
				ResultSet rs = pst1.executeQuery();				
				while(rs.next()) {
					libelle = rs.getString(2);
					id_1 = rs.getInt(5);
					pst1 = con.prepareStatement("SELECT * FROM filliere where id_filliere=?");
					pst1.setInt(1, id_1);
					pst1 = con.prepareStatement("SELECT * FROM semestre where id_semestre=?");
					pst1.setInt(1, id_1);
					ResultSet rs1 = pst1.executeQuery();
					while(rs1.next()) {
						filiere = rs.getString(2);
						semestre = rs.getString(2);
					}
				}
				request.setAttribute("id_1", id_1);
				request.setAttribute("libelle", libelle);
				request.setAttribute("filiere", filiere);
				request.setAttribute("semestre",semestre);
				request.getRequestDispatcher("UpdateMod.jsp").forward(request, response);
			  }catch (Exception e) {
				  System.out.print(e);
				  
			  }
		}else{
			response.sendRedirect("auth.jsp");
					}
	
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String id = request.getParameter("id_module");
			String libelle=request.getParameter("libelle");
			String filiere=request.getParameter("filiere");
			String semestre=request.getParameter("semestre");
			

			String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

		  PreparedStatement pst = con.prepareStatement("UPDATE module SET libelle = ? where fil_id = ? and sem_id = ?");
		  pst.setString(1, libelle); 
		  pst.setString(2, id);
		  pst.executeUpdate();
		  pst = con.prepareStatement("UPDATE filliere SET libelle_fil = ? where id_filliere = ?");
		  pst.setString(1, filiere);
		  pst = con.prepareStatement("UPDATE semestre SET nom_semestre = ? where id_semestre = ?");
		  pst.setString(1, semestre);
		  pst.setString(3, id);
		  pst.executeUpdate();
		  response.sendRedirect("index2.jsp");
		  pst.close();
		  con.close();
			  }
			  catch(Exception e) {
			  }
		}

}
