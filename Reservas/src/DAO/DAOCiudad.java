package DAO;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOCiudad extends DAOConexion implements DAOInterface {
	private static DAOCiudad instancia = null;
	private static final Object SYNC = new Object();
	
	public static DAOCiudad getInstancia() {
		synchronized(SYNC) {
		  instancia = new DAOCiudad();
		}
		return instancia;
	}
	
	public Boolean delete(DTO.DTOCiudad DTOciudad) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM ciudad WHERE ciudad = '" + DTOciudad.getCiudad() + "'");
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo eliminar los datos en la tabla CIUDAD.\n" + e);
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
	
	public Boolean insert(DTO.DTOCiudad DTOciudad) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			stmt.execute("INSERT INTO ciudad VALUES ('" + DTOciudad.getCiudad() + "')");
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo insertar los datos en la tabla CIUDAD.\n" + e);
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
	
	public DTO.DTOCiudad select(DTO.DTOCiudad DTOciudad) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ciudad FROM ciudad WHERE ciudad = '" + DTOciudad.getCiudad() + "'");
			if(rs.next()) {
				DTOciudad.setCiudad(rs.getString(1));
			}
			else {
				DTOciudad.setCiudad(null);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla CIUDAD.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOciudad;
	}
	
	public ArrayList<DTO.DTOCiudad> selectCiudades() {
		ArrayList<DTO.DTOCiudad> DTOciudades = new ArrayList<DTO.DTOCiudad>();

		abrirBD();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ciudad FROM ciudad");
			while(rs.next()) {
				DTO.DTOCiudad DTOciudad = new DTO.DTOCiudad();
				DTOciudad.setCiudad(rs.getString(1));
		
				DTOciudades.add(DTOciudad);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla CIUDAD.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOciudades;
	}
	
	 public Boolean update(DTO.DTOCiudad DTOciudadNueva, DTO.DTOCiudad DTOciudadVieja) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			stmt.execute("UPDATE ciudad SET ciudad = '" + DTOciudadNueva.getCiudad() + "' WHERE ciudad = '" + DTOciudadVieja.getCiudad() + "'");
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo actualizar los datos en la tabla CIUDAD.\n" + e);
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
}