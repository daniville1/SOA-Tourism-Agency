package facade;
import java.util.ArrayList;


public class FacadeHotel implements FacadeInterface {
	private static FacadeHotel instancia = null;
	private static final Object SYNC = new Object();
	
	public static FacadeHotel getInstancia() {
		synchronized(SYNC) {
		  instancia = new FacadeHotel();
		}
		return instancia;
	}

	public String[] getHotelesConHabDisponibles(String fecha, String ciudad) {
		logica.LogicaHotel logicaHotel = (logica.LogicaHotel) logica.LogicaFactory.getInstanceLogica("Hotel");
		String hoteles[];
		DTO.DTOHotel DTOhotel = new DTO.DTOHotel();
		ArrayList<DTO.DTOHotel> DTOHoteles = new ArrayList<DTO.DTOHotel>();
		
		DTOhotel.setFecha(fecha);
		DTOhotel.setCiudad(ciudad);
		
		DTOHoteles = logicaHotel.selectHotel(DTOhotel);
		
		if(DTOHoteles != null) {
			hoteles = new String[DTOHoteles.size()];
			
			for(int i = 0 ; i < DTOHoteles.size(); i++) {
				hoteles[i] = DTOHoteles.get(i).getHotel();
			}
		}
		else {
			hoteles = null;
		}
		
	    return hoteles;
	}
	
	public String getCtdHabDisponibles(String fecha, String hotel, String ciudad) {
		logica.LogicaHotel logicaHotel = (logica.LogicaHotel) logica.LogicaFactory.getInstanceLogica("Hotel");
		DTO.DTOHotel DTOhotel = new DTO.DTOHotel();
		
		DTOhotel.setFecha(fecha);
		DTOhotel.setHotel(hotel);
		DTOhotel.setCiudad(ciudad);
		
	    return logicaHotel.selectHotelHabitacion(DTOhotel);
	}

	public Boolean reservarHabitacion(String fecha, String hotel, String ciudad, String nro_documento_pasajero, String pasajero) {
		logica.LogicaHotel logicaHotel = (logica.LogicaHotel) logica.LogicaFactory.getInstanceLogica("Hotel");
		DTO.DTOHotel DTOhotel = new DTO.DTOHotel();
		
		DTOhotel.setFecha(fecha);
		DTOhotel.setHotel(hotel);
		DTOhotel.setCiudad(ciudad);
		DTOhotel.setNro_documento_pasajero(nro_documento_pasajero);
		DTOhotel.setPasajero(pasajero);
		
	    return logicaHotel.insertReservaHotel(DTOhotel);
	}
	
	public Boolean cancelarReservacion(String fecha, String hotel, String ciudad, String nro_documento_pasajero) {
		logica.LogicaHotel logicaHotel = (logica.LogicaHotel) logica.LogicaFactory.getInstanceLogica("Hotel");
		DTO.DTOHotel DTOhotel = new DTO.DTOHotel();
		
		DTOhotel.setFecha(fecha);
		DTOhotel.setHotel(hotel);
		DTOhotel.setCiudad(ciudad);
		DTOhotel.setNro_documento_pasajero(nro_documento_pasajero);
		
	    return logicaHotel.deleteReservaHotel(DTOhotel);
	}
}