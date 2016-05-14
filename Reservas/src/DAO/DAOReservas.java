package DAO;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOReservas extends DAOConexion implements DAOInterface {
	private static DAOReservas instancia = null;
	private static final Object SYNC = new Object();
	
	public static DAOReservas getInstancia() {
		synchronized(SYNC) {
		  instancia = new DAOReservas();
		}
		return instancia;
	}
	
	
	public Boolean delete(DTO.DTOReservas DTOreservas) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM reservas WHERE nro_reserva = '" + DTOreservas.getNro_reserva() + "'");
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo eliminar los datos en la tabla RESERVAS.\n" + e);
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
	
	@SuppressWarnings("static-access")
	public String insert(DTO.DTOReservas DTOreservas) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			stmt.execute("INSERT INTO reservas VALUES (" + DTOreservas.getNro_reserva() + ", '" + DTOreservas.getFecha_salida() + "', '" + DTOreservas.getFecha_regreso() + "', '" + DTOreservas.getCiudad_origen() + "', '" + DTOreservas.getCiudad_destino() + "', " + DTOreservas.getNro_documento_pasajero() + ", '" + DTOreservas.getPasajero() + "', " + DTOreservas.getNro_vuelo_salida() + ", " + DTOreservas.getNro_vuelo_regreso() + ", '" + DTOreservas.getHotel_reservado() + "')", stmt.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
		    if(rs.next()) {
		    	DTOreservas.setNro_reserva(rs.getString(1));			    
		    }
		    else {
			    System.out.println("Error: no se pudo insertar los datos en la tabla RESERVAS porque no se genero el ultimo Indice.\n");
			    cerrarBD();
			    return null;
		    }
			
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo insertar los datos en la tabla RESERVAS.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOreservas.getNro_reserva();
	}
	
	public DTO.DTOReservas select(DTO.DTOReservas DTOreservas) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM reservas WHERE nro_reserva = '" + DTOreservas.getNro_reserva() + "'");
			if(rs.next()) {
				DTOreservas.setNro_reserva(rs.getString(1));
				DTOreservas.setFecha_salida(rs.getString(2));
				DTOreservas.setFecha_regreso(rs.getString(3));
				DTOreservas.setCiudad_origen(rs.getString(4));
				DTOreservas.setCiudad_destino(rs.getString(5));
				DTOreservas.setNro_documento_pasajero(rs.getString(6));
				DTOreservas.setPasajero(rs.getString(7));
				DTOreservas.setNro_vuelo_salida(rs.getString(8));
				DTOreservas.setNro_vuelo_regreso(rs.getString(9));
				DTOreservas.setHotel_reservado(rs.getString(10));
			}
			else {
				DTOreservas.setNro_reserva(null);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla RESERVAS.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOreservas;
	}
	
	public ArrayList<DTO.DTOReservas> selectReservas() {
		ArrayList<DTO.DTOReservas> DTOtodasReservas = new ArrayList<DTO.DTOReservas>();

		abrirBD();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM reservas");
			while(rs.next()) {
		        DTO.DTOReservas DTOreservas = new DTO.DTOReservas();
				DTOreservas.setNro_reserva(rs.getString(1));
				DTOreservas.setFecha_salida(rs.getString(2));
				DTOreservas.setFecha_regreso(rs.getString(3));
				DTOreservas.setCiudad_origen(rs.getString(4));
				DTOreservas.setCiudad_destino(rs.getString(5));
				DTOreservas.setNro_documento_pasajero(rs.getString(6));
				DTOreservas.setPasajero(rs.getString(7));
				DTOreservas.setNro_vuelo_salida(rs.getString(8));
				DTOreservas.setNro_vuelo_regreso(rs.getString(9));
				DTOreservas.setHotel_reservado(rs.getString(10));
		
				DTOtodasReservas.add(DTOreservas);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla RESERVAS.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOtodasReservas;
	}
	
	 public Boolean update(DTO.DTOReservas DTOreservas) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			stmt.execute("UPDATE reservas SET (fecha_salida = '" + DTOreservas.getFecha_salida() + "', fecha_regreso = '" + DTOreservas.getFecha_regreso() + "', ciudad_origen = '" + DTOreservas.getCiudad_origen() + "', ciudad_destino = '" + DTOreservas.getCiudad_destino() + "', nro_documento_pasajero = " + DTOreservas.getNro_documento_pasajero() + ", pasajero = '" + DTOreservas.getPasajero() + "', nro_vuelo_salida = " + DTOreservas.getNro_vuelo_salida() + ", nro_vuelo_regreso = " + DTOreservas.getNro_vuelo_regreso() + ", hotel_reservado = '" + DTOreservas.getHotel_reservado() + "') WHERE nro_reserva = '" + DTOreservas.getNro_reserva() + "'");
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo actualizar los datos en la tabla RESERVAS.\n" + e);
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
}