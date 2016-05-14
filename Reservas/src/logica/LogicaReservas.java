package logica;
import java.util.ArrayList;


public class LogicaReservas implements LogicaInterface {
	private static LogicaReservas instancia = null;
	private static final Object SYNC = new Object();
	
	public static LogicaReservas getInstancia() {
		synchronized(SYNC) {
		  instancia = new LogicaReservas();
		}
		return instancia;
	}
	
	public Boolean delete(DTO.DTOReservas DTOreservas) {
		DAO.DAOReservas DAOreservas = (DAO.DAOReservas) DAO.DAOFactory.getInstanceDAO("Reservas");
		
		DTOreservas = select(DTOreservas);
		if(DTOreservas != null) {
			if(DTOreservas.getNro_reserva() != null)
			    return DAOreservas.delete(DTOreservas);
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public String insert(DTO.DTOReservas DTOreservas) {
		DAO.DAOReservas DAOreservas = (DAO.DAOReservas) DAO.DAOFactory.getInstanceDAO("Reservas");
	    return DAOreservas.insert(DTOreservas);
	}

	public DTO.DTOReservas select(DTO.DTOReservas DTOreservas) {
		DAO.DAOReservas DAOreservas = (DAO.DAOReservas) DAO.DAOFactory.getInstanceDAO("Reservas");
	    return DAOreservas.select(DTOreservas);
	}
	
	public ArrayList<DTO.DTOReservas> selectReservas() {
		DAO.DAOReservas DAOreservas = (DAO.DAOReservas) DAO.DAOFactory.getInstanceDAO("Reservas");
	    return DAOreservas.selectReservas();
	}
	
	public Boolean update(DTO.DTOReservas DTOreservas) {
		DAO.DAOReservas DAOreservas = (DAO.DAOReservas) DAO.DAOFactory.getInstanceDAO("Reservas");
		
		DTOreservas = select(DTOreservas);
		if(DTOreservas != null) {
			if(DTOreservas.getNro_reserva() != null)
			    return DAOreservas.update(DTOreservas);
			else
				return false;
		}
		else {
			return false;
		}
	}
}