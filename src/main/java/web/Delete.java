package web;

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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			String email_user=request.getParameter("email_user");
			
			
			  String url = "jdbc:mysql://localhost:3306/gestionabsence";
			  String utilisateur = "root";
			  String motDePasse = "";
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );
				  PreparedStatement pst = con.prepareStatement("delete from user where email_user=?");
				  pst.setString(1, email_user);
				  pst.executeUpdate();
					  pst = con.prepareStatement("delete from etudiant where email_etud=?");
					  pst.setString(1, email_user);
					  pst.executeUpdate();
					  response.sendRedirect("index.jsp");
					  pst.close();				  
			  }catch (Exception e) {
				  System.out.print(e);
				  
			  }
			
			
			
		}else{
			response.sendRedirect("auth.jsp");
					}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
