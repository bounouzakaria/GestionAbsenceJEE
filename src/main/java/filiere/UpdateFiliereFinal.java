package filiere;

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


@WebServlet("/UpdateFiliere")
public class UpdateFiliereFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFiliereFinal() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			  String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
					String id = request.getParameter("id_filliere");
					
					String filiere = null;
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				PreparedStatement pst1 = con.prepareStatement("SELECT * FROM filliere where id_filliere=?");
				pst1.setInt(1, Integer.parseInt(id));
				ResultSet rs = pst1.executeQuery();				
				while(rs.next()) {
					filiere = rs.getString(2);
				}
				request.setAttribute("id_filliere", id);
				request.setAttribute("filiere", filiere);
				request.getRequestDispatcher("UpdateFiliere.jsp").forward(request, response);
			  }catch (Exception e) {
				  System.out.print(e);
				  
			  }
		}else{
			response.sendRedirect("auth.jsp");
					}
	
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String id = request.getParameter("id_filliere");
			String libelle=request.getParameter("filiere");
			String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

		  PreparedStatement pst = con.prepareStatement("UPDATE filliere SET libelle_fil = ? where id_filliere=? ");
		  pst.setString(1, libelle); 
		  pst.setString(2, id);
		  pst.executeUpdate();
		  response.sendRedirect("index3.jsp");
		  pst.close();
		  con.close();
			  }
			  catch(Exception e) {
			  }
		}

}
