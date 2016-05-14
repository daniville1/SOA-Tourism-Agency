package logica;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;
import DAO.WebServiceVueloStub;


public class LogicaWebServiceVuelo implements LogicaInterface {
	private static LogicaWebServiceVuelo instancia = null;
	private static final Object SYNC = new Object();
	
	public static LogicaWebServiceVuelo getInstancia() {
		synchronized(SYNC) {
		  instancia = new LogicaWebServiceVuelo();
		}
		return instancia;
	}
	
	public String[] getNroVuelo(String fecha, String ciudadOrigen, String ciudadDestino) {
		WebServiceVueloStub stub;
		
		try {
			stub = new WebServiceVueloStub("http://localhost:8080/axis2/services/WebServiceVuelo");
			
			WebServiceVueloStub.GetNroVuelo getNroVuelos = new WebServiceVueloStub.GetNroVuelo();

			getNroVuelos.setFecha(fecha);
			getNroVuelos.setCiudadOrigen(ciudadOrigen);
			getNroVuelos.setCiudadDestino(ciudadDestino);
			
			WebServiceVueloStub.GetNroVueloResponse respuesta = stub.getNroVuelo(getNroVuelos);
			
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
	
	public String getNroAsientosDisponibles(String nroVuelo) {
		WebServiceVueloStub stub;
		
		try {
			stub = new WebServiceVueloStub("http://localhost:8080/axis2/services/WebServiceVuelo");
			
			WebServiceVueloStub.GetNroAsientosDisponibles pedido = new WebServiceVueloStub.GetNroAsientosDisponibles();

			pedido.setNroVuelo(nroVuelo);
			
			WebServiceVueloStub.GetNroAsientosDisponiblesResponse respuesta = stub.getNroAsientosDisponibles(pedido);
			
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

	public Boolean reservarAsiento(String nroVuelo, String nroDocPasajero, String pasajero) {
		WebServiceVueloStub stub;
		
		try {
			stub = new WebServiceVueloStub("http://localhost:8080/axis2/services/WebServiceVuelo");
			
			WebServiceVueloStub.ReservarAsiento reservarAsiento = new WebServiceVueloStub.ReservarAsiento();

			reservarAsiento.setNroVuelo(nroVuelo);
			reservarAsiento.setNroDocPasajero(nroDocPasajero);
			reservarAsiento.setPasajero(pasajero);
			
			WebServiceVueloStub.ReservarAsientoResponse respuesta = stub.reservarAsiento(reservarAsiento);
			
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
	
	public Boolean cancelarReservacion(String nroVuelo, String nroDocPasajero) {
		WebServiceVueloStub stub;
		
		try {
			stub = new WebServiceVueloStub("http://localhost:8080/axis2/services/WebServiceVuelo");
			
			WebServiceVueloStub.CancelarReservacion cancelarReservacion = new WebServiceVueloStub.CancelarReservacion();

			cancelarReservacion.setNroVuelo(nroVuelo);
			cancelarReservacion.setNroDocPasajero(nroDocPasajero);
			
			WebServiceVueloStub.CancelarReservacionResponse respuesta = stub.cancelarReservacion(cancelarReservacion);
			
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