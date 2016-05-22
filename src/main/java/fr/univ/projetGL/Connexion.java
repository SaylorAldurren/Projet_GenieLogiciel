package fr.univ.projetGL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {

	private static String url = "jdbc:oracle:thin:@ufrsciencestech.u-bourgogne.fr:25561:ensb2015";
	private static String id_mdp = "km542090";
	private static Connection conn;
	
	public static Connection GetInstance() {
	    if (conn == null) {
		    try {
		        Class.forName ("oracle.jdbc.OracleDriver");
		        conn = DriverManager.getConnection(url, id_mdp, id_mdp);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	    }
	    return conn;
	}
	
}
