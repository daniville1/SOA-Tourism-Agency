package DAO;


public class DAOFactory {
	public static DAOInterface getInstanceDAO(String DAO) {
		if(DAO.equals("Hotel"))
			return DAOHotel.getInstancia();
		return null;
	}
}
