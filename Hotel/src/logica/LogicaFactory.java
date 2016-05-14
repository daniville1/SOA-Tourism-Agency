package logica;


public class LogicaFactory {
	public static LogicaInterface getInstanceLogica(String logica) {
		if(logica.equals("Hotel"))
			return LogicaHotel.getInstancia();
		return null;
	}
}