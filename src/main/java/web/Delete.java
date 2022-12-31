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

    dbConnection cnx = new dbConnection();
    Connection con = cnx.init();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")!=null){
			String id_prof=request.getParameter("id_prof");
			String user_id=request.getParameter("user_id");
			
			
			
			  try {
				  
				  PreparedStatement pst = con.prepareStatement("delete from professeur where user_id = ?");
				  pst.setString(1, user_id);
				  response.sendRedirect("index.jsp");
				  pst = con.prepareStatement("select Max(id_user) from user");
				  ResultSet rs = pst.executeQuery();
				  
				  while(rs.next()) {

					  
					  pst = con.prepareStatement("delete from professeur where user_id=?");
					  pst.setString(1, user_id);
					  pst.executeUpdate();
					  response.sendRedirect("index.jsp");
					  pst.close();
					  con.close();
				  }
				  
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
