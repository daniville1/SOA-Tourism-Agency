package DTO;


public class DTOVuelo {
	private String nro_vuelo;
	private String fecha_salida;
	private String fecha_arribo;
	private String ciudad_origen;
	private String ciudad_destino;
	private String ctd_asientos;
	private String ctd_asientos_ocupados;
	private String nro_documento_pasajero;
	private String pasajero;

	
	public void setNro_vuelo(String nro_vuelo) {
		this.nro_vuelo = nro_vuelo;
	}
	
	public String getNro_vuelo() {
		return nro_vuelo;
	}

	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_arribo(String fecha_arribo) {
		this.fecha_arribo = fecha_arribo;
	}

	public String getFecha_arribo() {
		return fecha_arribo;
	}

	public void setCiudad_origen(String ciudad_origen) {
		this.ciudad_origen = ciudad_origen;
	}

	public String getCiudad_origen() {
		return ciudad_origen;
	}

	public void setCiudad_destino(String ciudad_destino) {
		this.ciudad_destino = ciudad_destino;
	}

	public String getCiudad_destino() {
		return ciudad_destino;
	}

	public void setCtd_asientos(String ctd_asientos) {
		this.ctd_asientos = ctd_asientos;
	}

	public String getCtd_asientos() {
		return ctd_asientos;
	}

	public void setCtd_asientos_ocupados(String ctd_asientos_ocupados) {
		this.ctd_asientos_ocupados = ctd_asientos_ocupados;
	}

	public String getCtd_asientos_ocupados() {
		return ctd_asientos_ocupados;
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