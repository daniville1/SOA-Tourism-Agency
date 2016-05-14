package logica;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;
import DAO.WebServiceHotelStub;


public class LogicaWebServiceHotel implements LogicaInterface {
	private static LogicaWebServiceHotel instancia = null;
	private static final Object SYNC = new Object();
	
	public static LogicaWebServiceHotel getInstancia() {
		synchronized(SYNC) {
		  instancia = new LogicaWebServiceHotel();
		}
		return instancia;
	}
	
	public String[] getHotelesConHabDisponibles(String fecha, String ciudad) {
		WebServiceHotelStub stub;
		
		try {
			stub = new WebServiceHotelStub("http://localhost:8080/axis2/services/WebServiceHotel");
			
			WebServiceHotelStub.GetHotelesConHabDisponibles getHoteles = new WebServiceHotelStub.GetHotelesConHabDisponibles();

			getHoteles.setFecha(fecha);
			getHoteles.setCiudad(ciudad);
			
			WebServiceHotelStub.GetHotelesConHabDisponiblesResponse respuesta = stub.getHotelesConHabDisponibles(getHoteles);
			
			return respuesta.get_return();
		}
		catch (AxisFault e) {
			e.printStackTrace();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getHotelesConHabDisponibles(String fecha,  String hotel, String ciudad) {
		WebServiceHotelStub stub;
		
		try {
			stub = new WebServiceHotelStub("http://localhost:8080/axis2/services/WebServiceHotel");
			
			WebServiceHotelStub.GetCtdHabDisponibles pedido = new WebServiceHotelStub.GetCtdHabDisponibles();

			pedido.setFecha(fecha);
			pedido.setHotel(hotel);
			pedido.setCiudad(ciudad);
			
			WebServiceHotelStub.GetCtdHabDisponiblesResponse respuesta = stub.getCtdHabDisponibles(pedido);
			
			return respuesta.get_return();
		}
		catch (AxisFault e) {
			e.printStackTrace();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean reservarHabitacion(String fecha, String hotel, String ciudad, String nro_documento_pasajero, String pasajero) {
		WebServiceHotelStub stub;
		
		try {
			stub = new WebServiceHotelStub("http://localhost:8080/axis2/services/WebServiceHotel");
			
			WebServiceHotelStub.ReservarHabitacion reservarHabitacion = new WebServiceHotelStub.ReservarHabitacion();

			reservarHabitacion.setFecha(fecha);
			reservarHabitacion.setHotel(hotel);
			reservarHabitacion.setCiudad(ciudad);
			reservarHabitacion.setNro_documento_pasajero(nro_documento_pasajero);
			reservarHabitacion.setPasajero(pasajero);
			
			WebServiceHotelStub.ReservarHabitacionResponse respuesta = stub.reservarHabitacion(reservarHabitacion);
			
			return respuesta.get_return();
		}
		catch (AxisFault e) {
			e.printStackTrace();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean cancelarReservacion(String fecha, String hotel, String ciudad, String nro_documento_pasajero) {
		WebServiceHotelStub stub;
		
		try {
			stub = new WebServiceHotelStub("http://localhost:8080/axis2/services/WebServiceHotel");
			
			WebServiceHotelStub.CancelarReservacion cancelarReservacion = new WebServiceHotelStub.CancelarReservacion();

			cancelarReservacion.setFecha(fecha);
			cancelarReservacion.setHotel(hotel);
			cancelarReservacion.setCiudad(ciudad);
			cancelarReservacion.setNro_documento_pasajero(nro_documento_pasajero);
			
			WebServiceHotelStub.CancelarReservacionResponse respuesta = stub.cancelarReservacion(cancelarReservacion);
			
			return respuesta.get_return();
		}
		catch (AxisFault e) {
			e.printStackTrace();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}