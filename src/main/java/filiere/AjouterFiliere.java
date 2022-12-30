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

/**
 * Servlet implementation class AjouterFiliere
 */
@WebServlet("/AjouterFiliere")
public class AjouterFiliere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjouterFiliere() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			String filiere=request.getParameter("filiere");

			String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  PreparedStatement pst = con.prepareStatement("insert into filliere(libelle_fil) values (?)");
				  pst.setString(1,filiere);
				  pst.executeUpdate();
				  response.sendRedirect("index3.jsp");
					  pst.close();
					  con.close();
				  }
				  
			  catch (Exception e) {
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
