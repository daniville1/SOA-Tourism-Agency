package facade;


public class FacadeWebServiceHotel implements FacadeInterface {
	private static FacadeWebServiceHotel instancia = null;
	private static final Object SYNC = new Object();
	
	public static FacadeWebServiceHotel getInstancia() {
		synchronized(SYNC) {
		  instancia = new FacadeWebServiceHotel();
		}
		return instancia;
	}

	public String[] getHotelesConHabDisponibles(String fecha, String ciudad) {
		logica.LogicaWebServiceHotel logicaWebServiceHotel = (logica.LogicaWebServiceHotel) logica.LogicaFactory.getInstanceLogica("WebServiceHotel");
		return logicaWebServiceHotel.getHotelesConHabDisponibles(fecha, ciudad);
	}
	
	public String getCtdHabDisponibles(String fecha, String hotel,  String ciudad) {
		logica.LogicaWebServiceHotel logicaWebServiceHotel = (logica.LogicaWebServiceHotel) logica.LogicaFactory.getInstanceLogica("WebServiceHotel");
		return logicaWebServiceHotel.getHotelesConHabDisponibles(fecha, hotel, ciudad);
	}

	public Boolean reservarHabitacion(String fecha, String hotel, String ciudad, String nro_documento_pasajero, String pasajero) {
		logica.LogicaWebServiceHotel logicaWebServiceHotel = (logica.LogicaWebServiceHotel) logica.LogicaFactory.getInstanceLogica("WebServiceHotel");
		return logicaWebServiceHotel.reservarHabitacion(fecha, hotel, ciudad, nro_documento_pasajero, pasajero);
	}
	
	public Boolean cancelarReservacion(String fecha, String hotel, String ciudad, String nro_documento_pasajero) {
		logica.LogicaWebServiceHotel logicaWebServiceHotel = (logica.LogicaWebServiceHotel) logica.LogicaFactory.getInstanceLogica("WebServiceHotel");
		return logicaWebServiceHotel.cancelarReservacion(fecha, hotel, ciudad, nro_documento_pasajero);
	}
}
