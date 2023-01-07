package classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class UpdateClasse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateClasse() {
        super();
        // TODO Auto-generated constructor stub
    }

    dbConnection cnx = new dbConnection();
    Connection con = cnx.init();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			  try {
				String id = request.getParameter("id_classe");
				String id_fil = request.getParameter("id_fil");
			
				String nom = null, nom_fil = null;
				PreparedStatement pst1 = con.prepareStatement("SELECT * FROM classe where id_classe=?");
				pst1.setInt(1, Integer.parseInt(id));
					ResultSet rs = pst1.executeQuery();				
					while(rs.next()) {
					nom = rs.getString(2);
				}
				request.setAttribute("id_classe", id);
				request.setAttribute("nom", nom);
				request.getRequestDispatcher("UpdatePage.jsp").forward(request, response);
			  }catch (Exception e) {
				  System.out.print(e);
				  
			  }
		}else{
			response.sendRedirect("auth.jsp");
					}
	
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String id = request.getParameter("id_classe");
			String nom=request.getParameter("nom");
			String filliere=request.getParameter("id_filliere");
			  try {
		  PreparedStatement pst = con.prepareStatement("UPDATE classe SET nom_classe = ?, filliere_id = ? where id_classe= ?");
		  pst.setString(1, nom); 
		  pst.setString(2, filliere);
		  pst.setString(3, id);
		  pst.executeUpdate();
		  response.sendRedirect("index.jsp");
		  pst.close();
		  }
			  catch(Exception e) {
			  }
		}
}
