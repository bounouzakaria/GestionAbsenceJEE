package classes;

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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

    dbConnection cnx = new dbConnection();
    Connection con = cnx.init();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String login=request.getParameter("login"); //1er argument
		String password=request.getParameter("pwd");//2nd argument

		try {	
			  PreparedStatement pst = con.prepareStatement("select id_user from user where email_user=? and pass_user=?");
			  pst.setString(1, login); 
			  pst.setString(2, password);
			  
			  ResultSet rs=pst.executeQuery();
			  if(rs.next()) {
				  session.setAttribute("login", login);
				  response.sendRedirect("index.jsp");
			  }else {
				  response.sendRedirect("auth.jsp");
			  }
			  rs.close();
			  pst.close();
			  
			  
			  
		  }catch (Exception e) {
			  System.out.print(e);
			  
		  }
		
		 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
