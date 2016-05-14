package facade;
import java.util.ArrayList;


public class FacadeVuelo implements FacadeInterface {
	private static FacadeVuelo instancia = null;
	private static final Object SYNC = new Object();
	
	public static FacadeVuelo getInstancia() {
		synchronized(SYNC) {
		  instancia = new FacadeVuelo();
		}
		return instancia;
	}
	
	public String[] getNroVuelo(String fecha, String ciudadOrigen, String ciudadDestino) {
		logica.LogicaVuelo logicaVuelo = (logica.LogicaVuelo) logica.LogicaFactory.getInstanceLogica("Vuelo");
		String[] vuelos;
		DTO.DTOVuelo DTOvuelo = new DTO.DTOVuelo();
		ArrayList<DTO.DTOVuelo> DTOvuelos = new ArrayList<DTO.DTOVuelo>();
		
		DTOvuelo.setFecha_salida(fecha);
		DTOvuelo.setCiudad_origen(ciudadOrigen);
		DTOvuelo.setCiudad_destino(ciudadDestino);
		
		DTOvuelos = logicaVuelo.selectVuelo(DTOvuelo);
		
		if(DTOvuelos != null) {
			vuelos = new String[DTOvuelos.size()];
			
			for(int i = 0 ; i < DTOvuelos.size(); i++)
				vuelos[i] = DTOvuelos.get(i).getNro_vuelo();
		}
		else {
			vuelos = null;
		}
		
	    return vuelos;
	}
	
	public String getNroAsientosDisponibles(String nroVuelo) {
		logica.LogicaVuelo logicaVuelo = (logica.LogicaVuelo) logica.LogicaFactory.getInstanceLogica("Vuelo");
		DTO.DTOVuelo DTOvuelo = new DTO.DTOVuelo();

		DTOvuelo.setNro_vuelo(nroVuelo);
		
	    return logicaVuelo.selectVueloAsiento(DTOvuelo);
	}

	public Boolean reservarAsiento(String nroVuelo, String nroDocPasajero, String pasajero) {
		logica.LogicaVuelo logicaVuelo = (logica.LogicaVuelo) logica.LogicaFactory.getInstanceLogica("Vuelo");
		DTO.DTOVuelo DTOvuelo = new DTO.DTOVuelo();

		DTOvuelo.setNro_vuelo(nroVuelo);
		DTOvuelo.setNro_documento_pasajero(nroDocPasajero);
		DTOvuelo.setPasajero(pasajero);
		
	    return logicaVuelo.insertReservaVuelo(DTOvuelo);
	}
	
	public Boolean cancelarReservacion(String nroVuelo, String nroDocPasajero) {
		logica.LogicaVuelo logicaVuelo = (logica.LogicaVuelo) logica.LogicaFactory.getInstanceLogica("Vuelo");
		DTO.DTOVuelo DTOvuelo = new DTO.DTOVuelo();
		
		DTOvuelo.setNro_vuelo(nroVuelo);
		DTOvuelo.setNro_documento_pasajero(nroDocPasajero);
		
	    return logicaVuelo.deleteReservaVuelo(DTOvuelo);
	}
}