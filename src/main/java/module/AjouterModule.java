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


@WebServlet("/AjouterModule")
public class AjouterModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjouterModule() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			
			String id_filliere = "";
			String libelle = "";
			String id_semestre = "";
			
			
			  String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  libelle = request.getParameter("libelle");
				  id_filliere = request.getParameter("fil");
				  id_semestre = request.getParameter("sem");
					  PreparedStatement pst = con.prepareStatement("insert into module(libelle,sem_id,fil_id) values(?,?,?)");
					  pst.setString(1, libelle); 
					  pst.setString(2, id_semestre);
					  pst.setString(3, id_filliere);
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
