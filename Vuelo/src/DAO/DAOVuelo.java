package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOVuelo extends DAOConexion implements DAOInterface {
	private static DAOVuelo instancia = null;
	private static final Object SYNC = new Object();
	
	public static DAOVuelo getInstancia() {
		synchronized(SYNC) {
		  instancia = new DAOVuelo();
		}
		return instancia;
	}
	
	
	// Metodos tabla RESERVA_VUELO
	public Boolean deleteReservaVuelo(DTO.DTOVuelo DTOvuelo) {
		int ctd_asientos_ocupados = 0;
		abrirBD();
		
		try {
			// Deshabilito Auto-entrega
			conn.setAutoCommit(false);
			//--
			
			// Cambiando nivel de aislamiento de transación (por defecto en 4 "TRANSACTION_REPEATABLE_READ")
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			//--
			
			stmt = conn.createStatement();
			
			stmt.execute("DELETE FROM reserva_vuelo WHERE nro_vuelo = '" + DTOvuelo.getNro_vuelo() + "' AND nro_documento_pasajero = '" + DTOvuelo.getNro_documento_pasajero() + "'");
			rs = stmt.executeQuery("SELECT ctd_asientos_ocupados FROM vuelo WHERE nro_vuelo = '" + DTOvuelo.getNro_vuelo() + "'");
			if(rs.next()) {
				ctd_asientos_ocupados = rs.getInt(1) - 1;
			}
			stmt.execute("UPDATE vuelo SET ctd_asientos_ocupados = '" + (ctd_asientos_ocupados) + "' WHERE nro_vuelo = '" + DTOvuelo.getNro_vuelo() + "'");

			// Entregar la Transación
			conn.commit();
			//--
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo eliminar los datos en la tabla RESERVA_VUELO.\n" + e);
			
			// Finalizar la Transación
			try {
				conn.rollback();
			}
			catch (SQLException e1) {
				System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_VUELO.\n" + e1);
			}
			//--
			
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
	
	public Boolean insertReservaVuelo(DTO.DTOVuelo DTOvuelo) {
		int ctd_asientos = 0;
		int ctd_asientos_ocupados = 0;
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
			rs = stmt.executeQuery("SELECT ctd_asientos, ctd_asientos_ocupados FROM vuelo WHERE nro_vuelo = '" + DTOvuelo.getNro_vuelo() + "'");
			if(rs.next()) {
				ctd_asientos = rs.getInt(1);
				ctd_asientos_ocupados = rs.getInt(2);
			}
			else {
				System.out.println("Error: no se pudo insertar los datos en la tabla RESERVA_VUELO.\n" + "No se pudo leer la tabla VUELO para verificar disponibilidad.");
				
				// Finalizar la Transación
				try {
					conn.rollback();
				}
				catch (SQLException e) {
					System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_VUELO.\n" + e);
				}
				//--
				
				cerrarBD();
				return false;
			}
			if(ctd_asientos == ctd_asientos_ocupados) {
				System.out.println("Error: no se pudo insertar los datos en la tabla RESERVA_VUELO.\n" + "No hay disponibilidad.");
				
				// Finalizar la Transación
				try {
					conn.rollback();
				}
				catch (SQLException e) {
					System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_VUELO.\n" + e);
				}
				//--
				
				cerrarBD();
				return false;
			}
			//--
			
			// Insertando y actualizando datos
			ctd_asientos_ocupados++;
			stmt.execute("INSERT INTO reserva_vuelo VALUES ('" + DTOvuelo.getNro_vuelo() + "', '" + DTOvuelo.getNro_documento_pasajero() + "', '" + DTOvuelo.getPasajero() + "')");
			stmt.execute("UPDATE vuelo SET ctd_asientos_ocupados = '" + (ctd_asientos_ocupados) + "' WHERE nro_vuelo = '" + DTOvuelo.getNro_vuelo() + "'");
			//--
			
			// Entregar la Transación
			conn.commit();
			//--
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo insertar los datos en la tabla RESERVA_VUELO.\n" + e);
			
			// Finalizar la Transación
			try {
				conn.rollback();
			}
			catch (SQLException e1) {
				System.out.println("Error: no se pudo realizar rollback en la tabla RESERVA_VUELO.\n" + e1);
			}
			//--
			
			cerrarBD();
			return false;
		}
		cerrarBD();
		return true;
	}
	
	public DTO.DTOVuelo selectReservaVuelo(DTO.DTOVuelo DTOvuelo) {
		abrirBD();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT nro_vuelo FROM reserva_vuelo WHERE nro_vuelo = '" + DTOvuelo.getNro_vuelo() + "' AND nro_documento_pasajero = '" + DTOvuelo.getNro_documento_pasajero() + "'");
			if(rs.next()) {
				DTOvuelo.setNro_vuelo(rs.getString(1));
			}
			else {
				DTOvuelo.setNro_vuelo(null);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla RESERVA_VUELO.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOvuelo;
	}
	//--
	
	
	// Metodos tabla VUELO
	public ArrayList<DTO.DTOVuelo> selectVuelo(DTO.DTOVuelo DTOvuelo) {
		ArrayList<DTO.DTOVuelo> DTOvuelos = new ArrayList<DTO.DTOVuelo>();

		abrirBD();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM vuelo WHERE fecha_salida = '" + DTOvuelo.getFecha_salida() + "' AND ciudad_origen = '" + DTOvuelo.getCiudad_origen() + "' AND ciudad_destino = '" + DTOvuelo.getCiudad_destino() + "' AND ctd_asientos != ctd_asientos_ocupados");
			while(rs.next()) {
		        DTO.DTOVuelo DTOVueloCargado = new DTO.DTOVuelo();
		        DTOVueloCargado.setNro_vuelo(rs.getString(1));
		        DTOVueloCargado.setFecha_salida(rs.getString(2));
		        DTOVueloCargado.setFecha_arribo(rs.getString(3));
		        DTOVueloCargado.setCiudad_origen(rs.getString(4));
		        DTOVueloCargado.setCiudad_destino(rs.getString(5));
		        DTOVueloCargado.setCtd_asientos(rs.getString(6));
		        DTOVueloCargado.setCtd_asientos_ocupados(rs.getString(7));
		
		        DTOvuelos.add(DTOVueloCargado);
			}
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla VUELO.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return DTOvuelos;
	}
	
	public String selectVueloAsiento(DTO.DTOVuelo DTOvuelo) {
		int ctd_asientos = 0;
		int ctd_asientos_ocupados = 0;

		abrirBD();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ctd_asientos, ctd_asientos_ocupados FROM vuelo WHERE nro_vuelo = '" + DTOvuelo.getNro_vuelo() + "'");
			if(rs.next()) {
				ctd_asientos = rs.getInt(1);
				ctd_asientos_ocupados = rs.getInt(2);
			}
			else {
				cerrarBD();
				return null;
			}	
		}
		catch(SQLException e) {
			System.out.println("Error: no se pudo consultar los datos en la tabla VUELO.\n" + e);
			cerrarBD();
			return null;
		}
		cerrarBD();
		return "" + (ctd_asientos - ctd_asientos_ocupados);
	}
	//--
}