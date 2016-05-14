package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DAOConexion {
	protected Connection conn;
	protected Statement stmt;
	protected ResultSet rs;
	
	public Connection abrirBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel","root","admin");
		}
		catch(Exception e) {
			System.out.println("Error: no se puede conectar con la base de datos.\n" + e);
		}
		return conn;
	}
	
	public void cerrarBD() {
		try {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
		}
		catch(Exception e) {
			System.out.println("Error: no se puede cerrar la conexion con la base de datos.\n" + e);
		}
	}
}