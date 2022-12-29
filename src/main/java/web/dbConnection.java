package web;
import javax.swing.*;
import java.sql.*;

public class dbConnection {
	Connection con=null;
public static Connection Cnx()
{
	
	 String url = "jdbc:mysql://localhost:3306/gestionabsence?characterEncoding=utf8";
	 String utilisateur = "root";
	 String motDePasse = "";
	
	try {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection( url,utilisateur,motDePasse );
		  return con;
		  
		  
	  }catch (Exception e) {
		 JOptionPane.showMessageDialog(null, e);
		  return null;
	  }
	
}
}

