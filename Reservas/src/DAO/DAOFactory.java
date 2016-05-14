package DAO;


public class DAOFactory {
	public static DAOInterface getInstanceDAO(String DAO) {
		if(DAO.equals("Ciudad"))
			return DAOCiudad.getInstancia();
		if(DAO.equals("Reservas"))
			return DAOReservas.getInstancia();
		return null;
	}
}
