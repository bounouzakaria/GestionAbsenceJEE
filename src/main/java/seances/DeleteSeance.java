package seances;



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

import classes.dbConnection;

/**
 * Servlet implementation class DeleteModule
 */
@WebServlet("/DeleteSeance")
public class DeleteSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteSeance() {
        super();

    }
    dbConnection con = new dbConnection();
    Connection cnx = con.init();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){

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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}