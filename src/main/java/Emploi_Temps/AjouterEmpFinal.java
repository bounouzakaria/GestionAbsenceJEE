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

@WebServlet("/AjouterEmp")
public class AjouterEmpFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjouterEmpFinal() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			
		String titre = "";
		String id_semestre = "";
		
		
		  String url = "jdbc:mysql://localhost:3306/gestionabsence";
		  String utilisateur = "root";
		  String motDePasse = "";
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
			  titre = request.getParameter("titre");
			  id_semestre = request.getParameter("sem");
				  PreparedStatement pst = con.prepareStatement("insert into emploi_temps(titre,id_semestre) values(?,?)");
				  pst.setString(1, titre); 
				  pst.setString(2, id_semestre);
				  pst.executeUpdate();
				  response.sendRedirect("index4.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
