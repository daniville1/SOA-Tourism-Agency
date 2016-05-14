package logica;


public class LogicaFactory {
	public static LogicaInterface getInstanceLogica(String logica) {
		if(logica.equals("Vuelo"))
			return LogicaVuelo.getInstancia();
		return null;
	}
}