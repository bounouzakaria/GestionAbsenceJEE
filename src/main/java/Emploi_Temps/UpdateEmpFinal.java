package Emploi_Temps;

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

@WebServlet("/UpdateEmp")
public class UpdateEmpFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateEmpFinal() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			  String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
					String id = request.getParameter("id_emploi_temps");
					
					String titre = null;
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				PreparedStatement pst1 = con.prepareStatement("SELECT * FROM emploi_temps where id_emploi_temps=?");
				pst1.setInt(1, Integer.parseInt(id));
				ResultSet rs = pst1.executeQuery();				
				while(rs.next()) {
					titre = rs.getString(2);
				}
				request.setAttribute("id_emploi_temps", id);
				request.setAttribute("titre", titre);
				request.getRequestDispatcher("UpdateEmp.jsp").forward(request, response);
			  }catch (Exception e) {
				  System.out.print(e);
				  
			  }
		}else{
			response.sendRedirect("auth.jsp");
					}
	
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String id = request.getParameter("id_emploi_temps");
			String titre=request.getParameter("titre");
			String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

		  PreparedStatement pst = con.prepareStatement("UPDATE emploi_temps SET titre = ? where id_emploi_temps=? ");
		  pst.setString(1, titre); 
		  pst.setString(2, id);
		  pst.executeUpdate();
		  response.sendRedirect("index4.jsp");
		  pst.close();
		  con.close();
			  }
			  catch(Exception e) {
			  }
		}
}
