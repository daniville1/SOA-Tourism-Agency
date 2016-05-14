package facade;
import java.util.ArrayList;


public class FacadeReservas implements FacadeInterface {
	private static FacadeReservas instancia = null;
	private static final Object SYNC = new Object();
	
	public static FacadeReservas getInstancia() {
		synchronized(SYNC) {
		  instancia = new FacadeReservas();
		}
		return instancia;
	}
	
	public Boolean delete(DTO.DTOReservas DTOreservas) {
		logica.LogicaReservas logicaReservas = (logica.LogicaReservas) logica.LogicaFactory.getInstanceLogica("Reservas");
	    return logicaReservas.delete(DTOreservas);
	}
	
	public String insert(DTO.DTOReservas DTOreservas) {
		logica.LogicaReservas logicaReservas = (logica.LogicaReservas) logica.LogicaFactory.getInstanceLogica("Reservas");
	    return logicaReservas.insert(DTOreservas);
	}
	
	public DTO.DTOReservas select(DTO.DTOReservas DTOreservas) {
		logica.LogicaReservas logicaReservas = (logica.LogicaReservas) logica.LogicaFactory.getInstanceLogica("Reservas");
	    return logicaReservas.select(DTOreservas);
	}
	
	public ArrayList<DTO.DTOReservas> selectReservas() {
		logica.LogicaReservas logicaReservas = (logica.LogicaReservas) logica.LogicaFactory.getInstanceLogica("Reservas");
	    return logicaReservas.selectReservas();
	}
	
	public Boolean update(DTO.DTOReservas DTOreservas) {
		logica.LogicaReservas logicaReservas = (logica.LogicaReservas) logica.LogicaFactory.getInstanceLogica("Reservas");
	    return logicaReservas.update(DTOreservas);
	}
}