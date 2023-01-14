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
		
		String id = request.getParameter("user_id");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String mail=request.getParameter("email");
		String password=request.getParameter("pass");
		String telephone=request.getParameter("tel");

		String url = "jdbc:mysql://localhost:3306/gestionabsence";
		  String utilisateur = "root";
		  String motDePasse = "";
		
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection( url, utilisateur, motDePasse );

	  PreparedStatement pst = con.prepareStatement("delete from professeur where user_id = ?");
	  pst.setString(1, id);
	 pst.executeUpdate();
	  pst = con.prepareStatement("delete from user where id_user = ?");
	  pst.setString(1, id);
	  pst.executeUpdate();
	  response.sendRedirect("index.jsp");
	  pst.close();
	  con.close();
		  }
		  catch(Exception e) {
		  }
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
