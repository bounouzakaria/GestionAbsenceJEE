package filiere;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteFiliere
 */
@WebServlet("/DeleteFiliere")
public class DeleteFiliereFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFiliereFinal() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
		
		String id = request.getParameter("id_filliere");
		String filiere=request.getParameter("filiere");
		
		String url = "jdbc:mysql://localhost:3306/gestionabsence";
		  String utilisateur = "root";
		  String motDePasse = "";
		
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

	  PreparedStatement pst = con.prepareStatement("delete from filliere where id_filliere= ?");
	  pst.setString(1, id);
	 pst.executeUpdate();
	  response.sendRedirect("index3.jsp");
	  pst.close();
	  con.close();
		  }
		  catch(Exception e) {
		  }
	}
			
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
