package Emploi_Temps;

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

@WebServlet("/DeleteEmp")
public class DeleteEmpFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteEmpFinal() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
		
		String id = request.getParameter("id_semestre");
		String titre=request.getParameter("titre");
		
		String url = "jdbc:mysql://localhost:3306/gestionabsence";
		  String utilisateur = "root";
		  String motDePasse = "";
		
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

	  PreparedStatement pst = con.prepareStatement("delete from emploi_temps where id_semestre= ?");
	  pst.setString(1, id);
	 pst.executeUpdate();
	  response.sendRedirect("index4.jsp");
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
