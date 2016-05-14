package facade;


public class FacadeFactory {
	public static FacadeInterface getInstanceFacade(String facade) {
		if(facade.equals("Vuelo"))
			return FacadeVuelo.getInstancia();
		return null;
	}
}