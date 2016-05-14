package logica;
import java.util.ArrayList;


public class LogicaHotel implements LogicaInterface {
	private static LogicaHotel instancia = null;
	private static final Object SYNC = new Object();
	
	public static LogicaHotel getInstancia() {
		synchronized(SYNC) {
		  instancia = new LogicaHotel();
		}
		return instancia;
	}
	
	
	// Metodos RESERVA_HOTEL
	public Boolean deleteReservaHotel(DTO.DTOHotel DTOhotel) {
		DAO.DAOHotel DAOhotel = (DAO.DAOHotel) DAO.DAOFactory.getInstanceDAO("Hotel");
		
		DTOhotel = selectReservaHotel(DTOhotel);
		if(DTOhotel != null) {
			if(DTOhotel.getHotel() != null)
			    return DAOhotel.deleteReservaHotel(DTOhotel);
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	public Boolean insertReservaHotel(DTO.DTOHotel DTOhotel) {
		DAO.DAOHotel DAOhotel = (DAO.DAOHotel) DAO.DAOFactory.getInstanceDAO("Hotel");
	    return DAOhotel.insertReservaHotel(DTOhotel);
	}

	public DTO.DTOHotel selectReservaHotel(DTO.DTOHotel DTOhotel) {
		DAO.DAOHotel DAOhotel = (DAO.DAOHotel) DAO.DAOFactory.getInstanceDAO("Hotel");
	    return DAOhotel.selectReservaHotel(DTOhotel);
	}
	//--
	
	
	// Metodos HOTEL
	public ArrayList<DTO.DTOHotel> selectHotel(DTO.DTOHotel DTOhotel) {
		DAO.DAOHotel DAOhotel = (DAO.DAOHotel) DAO.DAOFactory.getInstanceDAO("Hotel");
	    return DAOhotel.selectHotel(DTOhotel);
	}
	
	public String selectHotelHabitacion(DTO.DTOHotel DTOhotel) {
		DAO.DAOHotel DAOhotel = (DAO.DAOHotel) DAO.DAOFactory.getInstanceDAO("Hotel");
	    return DAOhotel.selectHotelHabitacion(DTOhotel);
	}
	//--
}