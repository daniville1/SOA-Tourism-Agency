package facade;


public class FacadeFactory {
	public static FacadeInterface getInstanceFacade(String facade) {
		if(facade.equals("Ciudad"))
			return FacadeCiudad.getInstancia();
		if(facade.equals("Reservas"))
			return FacadeReservas.getInstancia();
		if(facade.equals("WebServiceHotel"))
			return FacadeWebServiceHotel.getInstancia();
		if(facade.equals("WebServiceVuelo"))
			return FacadeWebServiceVuelo.getInstancia();
		return null;
	}
}