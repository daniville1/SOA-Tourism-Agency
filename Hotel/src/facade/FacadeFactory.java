package facade;


public class FacadeFactory {
	public static FacadeInterface getInstanceFacade(String facade) {
		if(facade.equals("Hotel"))
			return FacadeHotel.getInstancia();
		return null;
	}
}