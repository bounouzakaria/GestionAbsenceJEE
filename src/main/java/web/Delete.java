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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

    dbConnection con = new dbConnection();
    Connection cnx = con.init();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			String id_classe = request.getParameter("id_classe");		
			  try {
				  PreparedStatement pst = cnx.prepareStatement("delete from classe where id_classe = ?");
				  pst.setString(1, id_classe);
				  response.sendRedirect("index.jsp");
				  int rs = pst.executeUpdate();
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
