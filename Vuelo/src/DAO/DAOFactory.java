package DAO;


public class DAOFactory {
	public static DAOInterface getInstanceDAO(String DAO) {
		if(DAO.equals("Vuelo"))
			return DAOVuelo.getInstancia();
		return null;
	}
}
