package facade;
import java.util.ArrayList;


public class FacadeCiudad implements FacadeInterface {
	private static FacadeCiudad instancia = null;
	private static final Object SYNC = new Object();
	
	public static FacadeCiudad getInstancia() {
		synchronized(SYNC) {
		  instancia = new FacadeCiudad();
		}
		return instancia;
	}
	
	public Boolean delete(DTO.DTOCiudad DTOciudad) {
		logica.LogicaCiudad logicaCiudad = (logica.LogicaCiudad) logica.LogicaFactory.getInstanceLogica("Ciudad");
	    return logicaCiudad.delete(DTOciudad);
	}
	
	public Boolean insert(DTO.DTOCiudad DTOciudad) {
		logica.LogicaCiudad logicaCiudad = (logica.LogicaCiudad) logica.LogicaFactory.getInstanceLogica("Ciudad");
	    return logicaCiudad.insert(DTOciudad);
	}
	
	public DTO.DTOCiudad select(DTO.DTOCiudad DTOciudad) {
		logica.LogicaCiudad logicaCiudad = (logica.LogicaCiudad) logica.LogicaFactory.getInstanceLogica("Ciudad");
	    return logicaCiudad.select(DTOciudad);
	}
	
	public ArrayList<DTO.DTOCiudad> selectCiudades() {
		logica.LogicaCiudad logicaCiudad = (logica.LogicaCiudad) logica.LogicaFactory.getInstanceLogica("Ciudad");
	    return logicaCiudad.selectCiudades();
	}
	
	public Boolean update(DTO.DTOCiudad DTOciudadNueva, DTO.DTOCiudad DTOciudadVieja) {
		logica.LogicaCiudad logicaCiudad = (logica.LogicaCiudad) logica.LogicaFactory.getInstanceLogica("Ciudad");
	    return logicaCiudad.update(DTOciudadNueva, DTOciudadVieja);
	}
}