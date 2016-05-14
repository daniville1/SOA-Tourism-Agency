package logica;


public class LogicaFactory {
	public static LogicaInterface getInstanceLogica(String logica) {
		if(logica.equals("Ciudad"))
			return LogicaCiudad.getInstancia();
		if(logica.equals("Reservas"))
			return LogicaReservas.getInstancia();
		if(logica.equals("WebServiceHotel"))
			return LogicaWebServiceHotel.getInstancia();
		if(logica.equals("WebServiceVuelo"))
			return LogicaWebServiceVuelo.getInstancia();
		return null;
	}
}