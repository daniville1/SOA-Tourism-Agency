package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOHotel extends DAOConexion implements DAOInterface {
	private static DAOHotel instancia = null;
	private static final Object SYNC = new Object();
	
	public static DAOHotel getInstancia() {
		synchronized(SYNC) {
		  instancia = new DAOHotel();
		}
		return instancia;
	}
	
	
	// Metodos tabla RESERVA_HOTEL
	public Boolean deleteReservaHotel(DTO.DTOHotel DTOhotel) {
		int ctd_habitaciones_ocupadas = 0;
		abrirBD();
		
		try {
			// Deshabilito Auto-entrega
			conn.setAutoCommit(false);
			//--
			
			// Cambiando nivel de aislamiento de transación (por defecto en 4 "TRANSACTION_REPEATABLE_READ")
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			//--
			
			stmt = conn.createStatement();
			
			stmt.execute("DELETE FROM reserva_hotel WHERE hotel = '" + DTOhotel.getHotel() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND nro_documento_pasajero = '" + DTOhotel.getNro_documento_pasajero() + "' AND ciudad = '" + DTOhotel.getCiudad() + "'");
			rs = stmt.executeQuery("SELECT ctd_habitaciones_ocupadas FROM hotel WHERE hotel = '" + DTOhotel.getHotel() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND ciudad = '" + DTOhotel.getCiudad() + "'");
			if(rs.next()) {
				ctd_habitaciones_ocupadas = rs.getInt(1) - 1;
			}
			stmt.execute("UPDATE hotel SET ctd_habitaciones_ocupadas = '" + ctd_habitaciones_ocupadas + "' WHERE hotel = '" + DTOhotel.getHotel() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND ciudad = '" + DTOhotel.getCiudad() + "'");
			
			// Entregar la Transación
			conn.commit();
			//--
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo eliminar los datos en la tabla RESERVA_HOTEL.\n" + e);
			
			// Finalizar la Transación
			try {
				conn.rollback();
			}
			catch (SQLException e1) {
				System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_HOTEL.\n" + e1);
			}
			//--
			
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
	
	public Boolean insertReservaHotel(DTO.DTOHotel DTOhotel) {
		int ctd_habitaciones = 0;
		int ctd_habitaciones_ocupadas = 0;
		abrirBD();
		
		try {
			// Deshabilito Auto-entrega
			conn.setAutoCommit(false);
			//--
			
			// Cambiando nivel de aislamiento de transación (por defecto en 4 "TRANSACTION_REPEATABLE_READ")
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			//--
			
			stmt = conn.createStatement();
			
			// Verificacion de disponibilidad de habitaciones
			rs = stmt.executeQuery("SELECT ctd_habitaciones, ctd_habitaciones_ocupadas FROM hotel WHERE hotel = '" + DTOhotel.getHotel() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND ciudad = '" + DTOhotel.getCiudad() + "'");
			if(rs.next()) {
				ctd_habitaciones = rs.getInt(1);
				ctd_habitaciones_ocupadas = rs.getInt(2);
			}
			else {
				System.out.println("Error: no se pudo insertar los datos en la tabla RESERVA_HOTEL.\n" + "No se pudo leer la tabla HOTEL para verificar disponibilidad.");
				
				// Finalizar la Transación
				try {
					conn.rollback();
				}
				catch (SQLException e) {
					System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_HOTEL.\n" + e);
				}
				//--
				
				cerrarBD();
				return false;
			}
			if(ctd_habitaciones == ctd_habitaciones_ocupadas) {
				System.out.println("Error: no se pudo insertar los datos en la tabla RESERVA_HOTEL.\n" + "No hay disponibilidad.");
				
				// Finalizar la Transación
				try {
					conn.rollback();
				}
				catch (SQLException e) {
					System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_HOTEL.\n" + e);
				}
				//--
				
				cerrarBD();
				return false;
			}
			//--
			
			// Insertando y actualizando datos
			ctd_habitaciones_ocupadas++;
			stmt.execute("INSERT INTO reserva_hotel VALUES ('" + DTOhotel.getHotel() + "', '" + DTOhotel.getFecha() + "', '" + DTOhotel.getNro_documento_pasajero() + "', '" + DTOhotel.getPasajero() + "', '" + DTOhotel.getCiudad() + "')");
			stmt.execute("UPDATE hotel SET ctd_habitaciones_ocupadas = '" + (ctd_habitaciones_ocupadas) + "' WHERE hotel = '" + DTOhotel.getHotel() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND ciudad = '" + DTOhotel.getCiudad() + "'");
			//--
			
			// Entregar la Transación
			conn.commit();
			//--
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo insertar los datos en la tabla RESERVA_HOTEL.\n" + e);
			
			// Finalizar la Transación
			try {
				conn.rollback();
			}
			catch (SQLException e1) {
				System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_HOTEL.\n" + e1);
			}
			//--
			
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
	
	public DTO.DTOHotel selectReservaHotel(DTO.DTOHotel DTOhotel) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT hotel FROM reserva_hotel WHERE hotel = '" + DTOhotel.getHotel() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND nro_documento_pasajero = '" + DTOhotel.getNro_documento_pasajero() + "' AND ciudad = '" + DTOhotel.getCiudad() + "'");
			if(rs.next()) {
				DTOhotel.setHotel(rs.getString(1));
			}
			else {
				DTOhotel.setHotel(null);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla RESERVA_HOTEL.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOhotel;
	}
	//--
	
	
	// Metodos tabla HOTEL
	public ArrayList<DTO.DTOHotel> selectHotel(DTO.DTOHotel DTOhotel) {
		ArrayList<DTO.DTOHotel> DTOhoteles = new ArrayList<DTO.DTOHotel>();

		abrirBD();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM hotel WHERE ciudad = '" + DTOhotel.getCiudad() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND ctd_habitaciones != ctd_habitaciones_ocupadas");
			while(rs.next()) {
		        DTO.DTOHotel DTOhotelCargado = new DTO.DTOHotel();
		        DTOhotelCargado.setHotel(rs.getString(1));
		        DTOhotelCargado.setFecha(rs.getString(2));
		        DTOhotelCargado.setCtd_habitaciones(rs.getString(3));
		        DTOhotelCargado.setCtd_habitaciones_ocupadas(rs.getString(4));
		        DTOhotelCargado.setCiudad(rs.getString(5));
		
				DTOhoteles.add(DTOhotelCargado);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla HOTEL.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOhoteles;
	}
	
	public String selectHotelHabitacion(DTO.DTOHotel DTOhotel) {
		int ctd_habitaciones = 0;
		int ctd_habitaciones_ocupadas = 0;
		
		abrirBD();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ctd_habitaciones, ctd_habitaciones_ocupadas FROM hotel WHERE hotel = '" + DTOhotel.getHotel() + "' AND fecha = '" + DTOhotel.getFecha() + "' AND ciudad = '" + DTOhotel.getCiudad() + "'");
			if(rs.next()) {
				ctd_habitaciones = rs.getInt(1);
				ctd_habitaciones_ocupadas = rs.getInt(2);
			}
			else {
				cerrarBD();
				return null;
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla HOTEL.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return "" + (ctd_habitaciones - ctd_habitaciones_ocupadas);
	}
	//--
}