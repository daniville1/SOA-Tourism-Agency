package logica;
import java.util.ArrayList;


public class LogicaCiudad implements LogicaInterface {
	private static LogicaCiudad instancia = null;
	private static final Object SYNC = new Object();
	
	public static LogicaCiudad getInstancia() {
		synchronized(SYNC) {
		  instancia = new LogicaCiudad();
		}
		return instancia;
	}
	
	public Boolean delete(DTO.DTOCiudad DTOciudad) {
		DAO.DAOCiudad DAOciudad = (DAO.DAOCiudad) DAO.DAOFactory.getInstanceDAO("Ciudad");
		
		DTOciudad = select(DTOciudad);
		if(DTOciudad != null) {
			if(DTOciudad.getCiudad() != null)
			    return DAOciudad.delete(DTOciudad);
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public Boolean insert(DTO.DTOCiudad DTOciudad) {
		DAO.DAOCiudad DAOciudad = (DAO.DAOCiudad) DAO.DAOFactory.getInstanceDAO("Ciudad");
	    return DAOciudad.insert(DTOciudad);
	}

	public DTO.DTOCiudad select(DTO.DTOCiudad DTOciudad) {
		DAO.DAOCiudad DAOciudad = (DAO.DAOCiudad) DAO.DAOFactory.getInstanceDAO("Ciudad");
	    return DAOciudad.select(DTOciudad);
	}
	
	public ArrayList<DTO.DTOCiudad> selectCiudades() {
		DAO.DAOCiudad DAOciudad = (DAO.DAOCiudad) DAO.DAOFactory.getInstanceDAO("Ciudad");
	    return DAOciudad.selectCiudades();
	}
	
	public Boolean update(DTO.DTOCiudad DTOciudadNueva, DTO.DTOCiudad DTOciudadVieja) {
		DAO.DAOCiudad DAOciudad = (DAO.DAOCiudad) DAO.DAOFactory.getInstanceDAO("Ciudad");
		
		
		DTOciudadVieja = select(DTOciudadVieja);
		if(DTOciudadVieja != null) {
			if(DTOciudadVieja.getCiudad() != null)
			    return DAOciudad.update(DTOciudadNueva, DTOciudadVieja);
			else
				return false;
		}
		else {
			return false;
		}
	}
}