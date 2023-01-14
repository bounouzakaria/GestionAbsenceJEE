package web;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class AjouterFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

    dbConnection con = new dbConnection();
    Connection cnx = con.init();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			String nom_classe= request.getParameter("nom_classe");
			String id_filliere=request.getParameter("id_filliere");
			
			  try {

				  PreparedStatement pst = cnx.prepareStatement("insert into classe(nom_classe, filliere_id) values(?, ?)");
					  pst.setString(1, nom_classe); 
					  pst.setString(2, id_filliere);
					  pst.executeUpdate();
<<<<<<< HEAD
					  response.sendRedirect("index.jsp");
					  pst.close();
<<<<<<< HEAD:src/main/java/web/Ajouter.java
			  	}
			  catch (Exception e) {
=======
					  cnx.close();
=======
					  response.sendRedirect("indexFinal.jsp");
>>>>>>> crud-Prof
				  }
				  
			  }catch (Exception e) {
>>>>>>> 30431efdcab9730e051cc63e3ecf580041621958:src/main/java/web/AjouterFinal.java
				  System.out.print(e);
				  
			  }
			
			
			
		}else{
			response.sendRedirect("authFinal.jsp");
					}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
