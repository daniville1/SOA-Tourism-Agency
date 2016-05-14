package DTO;


public class DTOReservas {
	private String nro_reserva;
	private String fecha_salida;
	private String fecha_regreso;
	private String ciudad_origen;
	private String ciudad_destino;
	private String nro_documento_pasajero;
	private String pasajero;
	private String nro_vuelo_salida;
	private String nro_vuelo_regreso;
	private String hotel_reservado;
	
	public void setNro_reserva(String nro_reserva) {
		this.nro_reserva = nro_reserva;
	}
	
	public String getNro_reserva() {
		return nro_reserva;
	}
	
	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	
	public String getFecha_salida() {
		return fecha_salida;
	}
	
	public void setFecha_regreso(String fecha_regreso) {
		this.fecha_regreso = fecha_regreso;
	}
	
	public String getFecha_regreso() {
		return fecha_regreso;
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
	
	public void setNro_vuelo_salida(String nro_vuelo_salida) {
		this.nro_vuelo_salida = nro_vuelo_salida;
	}
	
	public String getNro_vuelo_salida() {
		return nro_vuelo_salida;
	}
	
	public void setNro_vuelo_regreso(String nro_vuelo_regreso) {
		this.nro_vuelo_regreso = nro_vuelo_regreso;
	}
	
	public String getNro_vuelo_regreso() {
		return nro_vuelo_regreso;
	}
	
	public void setHotel_reservado(String hotel_reservado) {
		this.hotel_reservado = hotel_reservado;
	}
	
	public String getHotel_reservado() {
		return hotel_reservado;
	}
}
