package facade;


public class FacadeWebServiceVuelo implements FacadeInterface {
	private static FacadeWebServiceVuelo instancia = null;
	private static final Object SYNC = new Object();
	
	public static FacadeWebServiceVuelo getInstancia() {
		synchronized(SYNC) {
		  instancia = new FacadeWebServiceVuelo();
		}
		return instancia;
	}

	public String[] getNroVuelo(String fecha, String ciudadOrigen, String ciudadDestino) {
		logica.LogicaWebServiceVuelo logicaWebServiceVuelo = (logica.LogicaWebServiceVuelo) logica.LogicaFactory.getInstanceLogica("WebServiceVuelo");
		return logicaWebServiceVuelo.getNroVuelo(fecha, ciudadOrigen, ciudadDestino);
	}
	
	public String getNroAsientosDisponibles(String nroVuelo) {
		logica.LogicaWebServiceVuelo logicaWebServiceVuelo = (logica.LogicaWebServiceVuelo) logica.LogicaFactory.getInstanceLogica("WebServiceVuelo");
		return logicaWebServiceVuelo.getNroAsientosDisponibles(nroVuelo);
	}

	public Boolean reservarAsiento(String nroVuelo, String nroDocPasajero, String pasajero) {
		logica.LogicaWebServiceVuelo logicaWebServiceVuelo = (logica.LogicaWebServiceVuelo) logica.LogicaFactory.getInstanceLogica("WebServiceVuelo");
		return logicaWebServiceVuelo.reservarAsiento(nroVuelo, nroDocPasajero, pasajero);
	}
	
	public Boolean cancelarReservacion(String nroVuelo, String nroDocPasajero) {
		logica.LogicaWebServiceVuelo logicaWebServiceVuelo = (logica.LogicaWebServiceVuelo) logica.LogicaFactory.getInstanceLogica("WebServiceVuelo");
		return logicaWebServiceVuelo.cancelarReservacion(nroVuelo, nroDocPasajero);
	}
}
