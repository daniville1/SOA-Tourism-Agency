package DTO;


public class DTOHotel {
	private String hotel;
	private String fecha;
	private String ctd_habitaciones;
	private String ctd_habitaciones_ocupadas;
	private String ciudad;
	private String nro_documento_pasajero;
	private String pasajero;
	
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
	public String getHotel() {
		return hotel;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setCtd_habitaciones(String ctd_habitaciones) {
		this.ctd_habitaciones = ctd_habitaciones;
	}
	
	public String getCtd_habitaciones() {
		return ctd_habitaciones;
	}

	public void setCtd_habitaciones_ocupadas(String ctd_habitaciones_ocupadas) {
		this.ctd_habitaciones_ocupadas = ctd_habitaciones_ocupadas;
	}

	public String getCtd_habitaciones_ocupadas() {
		return ctd_habitaciones_ocupadas;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setNro_documento_pasajero(String nro_documento_pasajero) {
		this.nro_documento_pasajero = nro_documento_pasajero;
	}

	public String getNro_documento_pasajero() {
		return nro_documento_pasajero;
	}

	public void setPasajero(String pasajero) {
		this.pasajero = pasajero;
	}

	public String getPasajero() {
		return pasajero;
	}
}