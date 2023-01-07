package seances;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class dbConnection {
	
	Connection db;
	
	public dbConnection() {
	}
	
	public Connection init() {
		if(this.db == null) {
			this.db = dbConnection.Cnx();
		}
		return this.db;
	}
	public static Connection Cnx()
	{
		  String url = "jdbc:mysql://localhost:3306/gestionabsence?characterEncoding=utf8";
		  String utilisateur = "root";
		  String motDePasse = "";
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection cnx = DriverManager.getConnection( url, utilisateur, motDePasse );
			  return cnx;
			  
		  }catch (Exception e) {
			  
			  JOptionPane.showMessageDialog(null, e);
			  return null;
			  
		  }
		
	}

}