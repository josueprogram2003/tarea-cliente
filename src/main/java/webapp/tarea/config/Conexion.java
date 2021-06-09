package webapp.tarea.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private static final String URL="jdbc:mysql://localhost:3306/bdprueba?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER="root";
	private static final String PASS="root";
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static Connection cx = null;
	
	public static Connection getConexion() {
		try {
			Class.forName(DRIVER);
			if(cx==null) {
				cx = DriverManager.getConnection(URL, USER, PASS);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		
		return cx;
	}
	public void desconectar() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
