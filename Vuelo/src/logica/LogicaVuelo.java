package logica;
import java.util.ArrayList;


public class LogicaVuelo implements LogicaInterface {
	private static LogicaVuelo instancia = null;
	private static final Object SYNC = new Object();
	
	public static LogicaVuelo getInstancia() {
		synchronized(SYNC) {
		  instancia = new LogicaVuelo();
		}
		return instancia;
	}
	
	
	// Metodos RESERVA_VUELO
	public Boolean deleteReservaVuelo(DTO.DTOVuelo DTOvuelo) {
		DAO.DAOVuelo DAOvuelo = (DAO.DAOVuelo) DAO.DAOFactory.getInstanceDAO("Vuelo");
		
		DTOvuelo = selectReservaVuelo(DTOvuelo);
		if(DTOvuelo != null) {
			if(DTOvuelo.getNro_vuelo() != null)
			    return DAOvuelo.deleteReservaVuelo(DTOvuelo);
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public Boolean insertReservaVuelo(DTO.DTOVuelo DTOvuelo) {
		DAO.DAOVuelo DAOvuelo = (DAO.DAOVuelo) DAO.DAOFactory.getInstanceDAO("Vuelo");
	    return DAOvuelo.insertReservaVuelo(DTOvuelo);
	}

	public DTO.DTOVuelo selectReservaVuelo(DTO.DTOVuelo DTOvuelo) {
		DAO.DAOVuelo DAOvuelo = (DAO.DAOVuelo) DAO.DAOFactory.getInstanceDAO("Vuelo");
	    return DAOvuelo.selectReservaVuelo(DTOvuelo);
	}
	//--
	
	
	// Metodos VUELO
	public ArrayList<DTO.DTOVuelo> selectVuelo(DTO.DTOVuelo DTOvuelo) {
		DAO.DAOVuelo DAOvuelo = (DAO.DAOVuelo) DAO.DAOFactory.getInstanceDAO("Vuelo");
	    return DAOvuelo.selectVuelo(DTOvuelo);
	}
	
	public String selectVueloAsiento(DTO.DTOVuelo DTOvuelo) {
		DAO.DAOVuelo DAOvuelo = (DAO.DAOVuelo) DAO.DAOFactory.getInstanceDAO("Vuelo");
	    return DAOvuelo.selectVueloAsiento(DTOvuelo);
	}
	//--
}