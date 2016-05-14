package presentacion;
import java.util.ArrayList;


public class BeanPresentacion {
	private String pagina = null;
	private String msj = "<center><img style='padding: 10px;' src=\"/Reservas/img/cargando.gif\"><br/>Cargando, espere porfavor.<br/><br/></center>";
	private String ciudad = "";
	private String ciudadNueva = "";
	private String nro_reserva = "";
	private String fecha_salida = "";
	private String fecha_regreso = "";
	private String ciudad_origen = "";
	private String ciudad_destino = "";
	private String nro_documento_pasajero = "";
	private String pasajero = "";
	private String nro_vuelo_salida = "";
	private String nro_vuelo_regreso = "";
	private String hotel_reservado = "";
	private String[] hoteles = null;
	private String[] vuelos_salida = null;
	private String[] vuelos_regreso = null;

	// Presentacion
	public void setMsj(String msj) {
		this.msj = msj;
	}

	public String getMsj() {
		return msj;
	}
	
	public String getPagina() {
		return pagina;
	}
	
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
	public String getInicio() {
		fecha_salida = "";
		fecha_regreso = "";
		return "";
	}
	
	public void home() {
		pagina = "presentacion.jsp";
		valoresPorDefecto();
	}
	
	public void ciudadAgregar() {
		pagina = "ciudadAgregar.jsp";
		valoresPorDefecto();
	}
	
	public void ciudadModificar() {
		pagina = "ciudadModificar.jsp";
		valoresPorDefecto();
	}

	public void ciudadEliminar() {
		pagina = "ciudadEliminar.jsp";
		valoresPorDefecto();
	}
	
	public void ciudadTodas() {
		pagina = "ciudadTodas.jsp";
		valoresPorDefecto();
	}
	
	public void reservasAgregar() {
		pagina = "reservasAgregar.jsp";
		valoresPorDefecto();
	}

	public void reservasEliminar() {
		pagina = "reservasEliminar.jsp";
		valoresPorDefecto();
	}

	public void reservasConsultar() {
		pagina = "reservasConsultar.jsp";
		valoresPorDefecto();
	}

	public void reservasTodas() {
		pagina = "reservasTodas.jsp";
		valoresPorDefecto();
	}
	
	public void consultaHotel() {
		pagina = "consultaHotel.jsp";
		valoresPorDefecto();
	}
	
	public void consultaVuelo() {
		pagina = "consultaVuelo.jsp";
		valoresPorDefecto();
	}
	
	public void valoresPorDefecto() {
		cargandoMsj();
		ciudad = "";
		ciudadNueva = "";
		nro_reserva = "";
		fecha_salida = "";
		fecha_regreso = "";
		ciudad_origen = "";
		ciudad_destino = "";
		nro_documento_pasajero = "";
		pasajero = "";
		nro_vuelo_salida = "";
		nro_vuelo_regreso = "";
		hotel_reservado = "";
		hoteles = null;
		vuelos_salida = null;
		vuelos_regreso = null;
	}
	
	public void cargandoMsj() {
		msj = "<center><img style='padding: 10px;' src=\"/Reservas/img/cargando.gif\"><br/>Cargando, espere porfavor.<br/><br/></center>";
	}
	// --
	
	
	// Ciudad
	public void setCiudad(String ciudad) {
		if(ciudad != null)
			this.ciudad = ciudad.toUpperCase();
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudadNueva(String ciudadNueva) {
		if(ciudadNueva != null)
			this.ciudadNueva = ciudadNueva.toUpperCase();
	}

	public String getCiudadNueva() {
		return ciudadNueva;
	}

	public ArrayList<DTO.DTOCiudad> getCiudades() {
		facade.FacadeCiudad facadeCiudad = (facade.FacadeCiudad) facade.FacadeFactory.getInstanceFacade("Ciudad");
		return facadeCiudad.selectCiudades();
	}
	
	public ArrayList<String> getCiudadesString() {
		ArrayList<String> ciudades = new ArrayList<String>();
		ArrayList<DTO.DTOCiudad> DTOciudades = new ArrayList<DTO.DTOCiudad>();
		
		facade.FacadeCiudad facadeCiudad = (facade.FacadeCiudad) facade.FacadeFactory.getInstanceFacade("Ciudad");
		DTOciudades = facadeCiudad.selectCiudades();
		
		if(DTOciudades != null) {
			for(int i = 0 ; i < DTOciudades.size(); i++) {
				ciudades.add(DTOciudades.get(i).getCiudad());
			}
		}
		
		return ciudades;
	}

	public void deleteCiudad() {
		DTO.DTOCiudad DTOciudad = new DTO.DTOCiudad();
		facade.FacadeCiudad facadeCiudad = (facade.FacadeCiudad) facade.FacadeFactory.getInstanceFacade("Ciudad");
		
		if(ciudad == null) {
			msj = "<div class='msjMal'> Ingrese la ciudad porfavor. </div>";
			return;
		}
		if(ciudad.equals("")) {
			msj = "<div class='msjMal'> Ingrese la ciudad porfavor. </div>";
			return;
		}
		DTOciudad.setCiudad(ciudad);
		if (facadeCiudad.delete(DTOciudad)) {
			msj = "<div class='msjBien'> La ciudad " + ciudad + " fue eliminada correctamente. </div>";
		}
		else {
			msj = "<div class='msjMal'> La ciudad " + ciudad + " no fue eliminada. Esto puede deberse a que dicha ciudad tiene reservas o a que no existe en la base de datos. </div>";
		}
	}
	
	public void insertCiudad() {
		DTO.DTOCiudad DTOciudad = new DTO.DTOCiudad();
		facade.FacadeCiudad facadeCiudad = (facade.FacadeCiudad) facade.FacadeFactory.getInstanceFacade("Ciudad");
		
		if(ciudad == null) {
			msj = "<div class='msjMal'> Ingrese la ciudad porfavor. </div>";
			return;
		}
		if(ciudad.equals("")) {
			msj = "<div class='msjMal'> Ingrese la ciudad porfavor. </div>";
			return;
		}
		DTOciudad.setCiudad(ciudad);
		if (facadeCiudad.insert(DTOciudad)) {
			msj = "<div class='msjBien'> La ciudad " + ciudad + " fue agregada correctamente. </div>";
		}
		else {
			msj = "<div class='msjMal'> La ciudad " + ciudad + " no fue agragada. Esto puede deberse a que dicha ciudad ya existe en la base de datos. </div>";
		}
	}
	
	public void selectCiudad() {
		DTO.DTOCiudad DTOciudad = new DTO.DTOCiudad();
		facade.FacadeCiudad facadeCiudad = (facade.FacadeCiudad) facade.FacadeFactory.getInstanceFacade("Ciudad");
		
		if(ciudad == null) {
			msj = "<div class='msjMal'> Ingrese la ciudad porfavor. </div>";
			return;
		}
		if(ciudad.equals("")) {
			msj = "<div class='msjMal'> Ingrese la ciudad porfavor. </div>";
			return;
		}	
		DTOciudad.setCiudad(ciudad);
		DTOciudad = facadeCiudad.select(DTOciudad);
		if (DTOciudad.getCiudad() != null) {
			ciudadNueva = ciudad;
			msj = "<div class='msjBien'> La ciudad " + ciudad + " fue cargada correctamente. </div>";
		}
		else {
			msj = "<div class='msjMal'> La ciudad " + ciudad + " no fue cargada. Esto puede deberse a que dicha ciudad no existe en la base de datos. </div>";
		}
	}
	
	public void updateCiudad() {
		DTO.DTOCiudad DTOciudadNueva = new DTO.DTOCiudad();
		DTO.DTOCiudad DTOciudadVieja = new DTO.DTOCiudad();
		facade.FacadeCiudad facadeCiudad = (facade.FacadeCiudad) facade.FacadeFactory.getInstanceFacade("Ciudad");
		

		if(ciudad == null || ciudadNueva == null) {
			msj = "<div class='msjMal'> Ingrese el nuevo nombre de la ciudad porfavor. </div>";
			return;
		}
		if(ciudad.equals("") && ciudadNueva.equals("")) {
			msj = "<div class='msjMal'> Ingrese el nuevo nombre de la ciudad porfavor. </div>";
			return;
		}
		DTOciudadVieja.setCiudad(ciudad);
		DTOciudadNueva.setCiudad(ciudadNueva);
		if (facadeCiudad.update(DTOciudadNueva, DTOciudadVieja)) {
			msj = "<div class='msjBien'> La ciudad " + ciudad + " fue modificada correctamente, su nuevo nombre es " + ciudadNueva + ". </div>";
		}
		else {
			msj = "<div class='msjMal'> La ciudad " + ciudad + " no fue modificada. </div>";
		}
	}
	//--
	
	
	// Reservas
	public void setNro_reserva(String nro_reserva) {
		this.nro_reserva = nro_reserva;
	}
	
	public String getNro_reserva() {
		return nro_reserva;
	}
	
	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = procesadorFecha(fecha_salida);
	}
	
	public String getFecha_salida() {
		return fecha_salida;
	}
	
	public void setFecha_regreso(String fecha_regreso) {
		this.fecha_regreso = procesadorFecha(fecha_regreso);
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
	
	public ArrayList<DTO.DTOReservas> getReservas() {
		facade.FacadeReservas facadeReservas = (facade.FacadeReservas) facade.FacadeFactory.getInstanceFacade("Reservas");
		return facadeReservas.selectReservas();
	}
	
	public String getHotel_reservado() {
		return hotel_reservado;
	}
	
	public String[] getHoteles() {
		return hoteles;
	}

	public String[] getVuelosSalida() {
		return vuelos_salida;
	}
	
	public String[] getVuelosRegreso() {
		return vuelos_regreso;
	}
	
	public void deleteReservas() {
		ArrayList<String> fechas;
		DTO.DTOReservas DTOreservas = new DTO.DTOReservas();
		facade.FacadeReservas facadeReservas = (facade.FacadeReservas) facade.FacadeFactory.getInstanceFacade("Reservas");
		facade.FacadeWebServiceHotel facadeWebServiceHotel = (facade.FacadeWebServiceHotel) facade.FacadeFactory.getInstanceFacade("WebServiceHotel");
		facade.FacadeWebServiceVuelo facadeWebServiceVuelo = (facade.FacadeWebServiceVuelo) facade.FacadeFactory.getInstanceFacade("WebServiceVuelo");
		

		if(nro_reserva == null) {
			msj = "<div class='msjMal'> Ingrese el número de reserva porfavor. </div>";
			return;
		}
		if(nro_reserva.equals("")) {
			msj = "<div class='msjMal'> Ingrese el número de reserva porfavor. </div>";
			return;
		}
		
		DTOreservas.setNro_reserva(nro_reserva);

		selectReservas();
		if(fecha_salida == null || fecha_regreso == null || nro_vuelo_salida == null || nro_vuelo_regreso == null || ciudad_destino == null || nro_documento_pasajero == null || hotel_reservado == null) {
			msj = "<div class='msjMal'> La reserva " + DTOreservas.getNro_reserva() + " no existe en la base de datos. </div>";
			return;
		}
		if(fecha_salida.equals("") || fecha_regreso.equals("") || nro_vuelo_salida.equals("") || nro_vuelo_regreso.equals("") || ciudad_destino.equals("") || nro_documento_pasajero.equals("") || hotel_reservado.equals("")) {
			msj = "<div class='msjMal'> La reserva " + DTOreservas.getNro_reserva() + " no existe en la base de datos. </div>";
			return;
		}
		
		if (facadeReservas.delete(DTOreservas)) {// Cancelar reservas
			fechas = dameFechasDeReserva(fecha_salida, fecha_regreso);
			facadeWebServiceVuelo.cancelarReservacion(nro_vuelo_salida, nro_documento_pasajero);// Reserva 1
			facadeWebServiceVuelo.cancelarReservacion(nro_vuelo_regreso, nro_documento_pasajero);// Reserva 2
			for(int i = 0; i < fechas.size(); i++) {
				facadeWebServiceHotel.cancelarReservacion(fechas.get(i), hotel_reservado, ciudad_destino, nro_documento_pasajero);// Reserva 3
			}
			msj = "<div class='msjBien'> La reserva " + nro_reserva + " fue eliminada correctamente. </div>";
		}
		else {
			msj = "<div class='msjMal'> La reserva " + nro_reserva + " no fue eliminada. Esto puede deberse a que dicha reserva no existe en la base de datos. </div>";
		}
	}
	
	public void insertReservasPaso1() {
		facade.FacadeWebServiceHotel facadeWebServiceHotel = (facade.FacadeWebServiceHotel) facade.FacadeFactory.getInstanceFacade("WebServiceHotel");
		facade.FacadeWebServiceVuelo facadeWebServiceVuelo = (facade.FacadeWebServiceVuelo) facade.FacadeFactory.getInstanceFacade("WebServiceVuelo");
		
		if(ciudad_destino == null || ciudad_origen == null || fecha_regreso == null || fecha_salida == null) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. </div>";
			return;
		}
		if(ciudad_destino.equals("") || ciudad_origen.equals("") || fecha_regreso.equals("") || fecha_salida.equals("")) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. </div>";
			return;
		}
		if(ciudad_origen.equals(ciudad_destino)) {
			msj = "<div class='msjMal'> La ciudad origen debe ser distinta a la ciudad destino. </div>";
			return;
		}
		if(!esFechaActual(fecha_salida)) {
			msj = "<div class='msjMal'> La fecha ingresada es errónea. La fecha de salida debe ser mayor al dia de hoy. </div>";
			return;
		}
		if(!validarEntreFechas(fecha_salida, fecha_regreso)) {
			msj = "<div class='msjMal'> Las fechas ingresadas son erróneas. La fecha de salida debe ser anterior a la fecha de regreso. </div>";
			return;
		}
		
		hoteles = facadeWebServiceHotel.getHotelesConHabDisponibles(fecha_salida, ciudad_destino);
		
		vuelos_salida = facadeWebServiceVuelo.getNroVuelo(fecha_salida, ciudad_origen, ciudad_destino);
		vuelos_regreso = facadeWebServiceVuelo.getNroVuelo(procesadorFecha(fecha_regreso), ciudad_destino, ciudad_origen);
		
		if(hoteles == null) {
			msj = "<div class='msjRespuesta'> Lo sentimos, no hay disponibilidad de hoteles en la fecha y lugar por usted solicitado. </div>";
			return;
		}
		if(vuelos_salida == null) {
			msj = "<div class='msjRespuesta'> Lo sentimos, no hay disponibilidad de vuelos de ida en la fecha y lugar por usted solicitado. </div>";
			return;
		}
		if(vuelos_regreso == null) {
			msj = "<div class='msjRespuesta'> Lo sentimos, no hay disponibilidad de vuelos de regreso en la fecha y lugar por usted solicitado. </div>";
			return;
		}
		msj = "<div class='msjBien'> Se cargaron correctamente los datos, ahora elige un hotel y los vuelos que deseas. </div>";
	}
	
	public void insertReservasPaso2() {	
		if(ciudad_origen == null || ciudad_destino == null || fecha_salida == null || fecha_regreso == null) {
			msj = "<div class='msjMal'> Complete el paso 1. </div>";
			return;
		}
		if(ciudad_origen.equals("") || ciudad_destino.equals("") || fecha_salida.equals("") || fecha_regreso.equals("")) {
			msj = "<div class='msjMal'> Complete el paso 1. </div>";
			return;
		}
		if(hotel_reservado == null || nro_vuelo_salida == null || nro_vuelo_regreso == null) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. Si no existen datos a elegir, el paso 1 no pudo ser completado. </div>";
			return;
		}
		if(hotel_reservado.equals("") || nro_vuelo_salida.equals("") || nro_vuelo_regreso.equals("")) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. Si no existen datos a elegir, el paso 1 no pudo ser completado. </div>";
			return;
		}
		
		msj = "<div class='msjBien'> Se cargaron correctamente los datos, ahora ingresa tus datos personales para finalizar. </div>";
	}
	
	public void insertReservasPaso3() {
		ArrayList<String> fechas;
		DTO.DTOReservas DTOreservas = new DTO.DTOReservas();
		facade.FacadeReservas facadeReservas = (facade.FacadeReservas) facade.FacadeFactory.getInstanceFacade("Reservas");
		facade.FacadeWebServiceHotel facadeWebServiceHotel = (facade.FacadeWebServiceHotel) facade.FacadeFactory.getInstanceFacade("WebServiceHotel");
		facade.FacadeWebServiceVuelo facadeWebServiceVuelo = (facade.FacadeWebServiceVuelo) facade.FacadeFactory.getInstanceFacade("WebServiceVuelo");
		
		
		if(ciudad_origen == null || ciudad_destino == null || fecha_salida == null || fecha_regreso == null) {
			msj = "<div class='msjMal'> Complete el paso 1. </div>";
			return;
		}
		if(ciudad_origen.equals("") || ciudad_destino.equals("") || fecha_salida.equals("") || fecha_regreso.equals("")) {
			msj = "<div class='msjMal'> Complete el paso 1. </div>";
			return;
		}
		if(hotel_reservado == null || nro_vuelo_salida == null || nro_vuelo_regreso == null) {
			msj = "<div class='msjMal'> Complete el paso 2. </div>";
			return;
		}
		if(hotel_reservado.equals("") || nro_vuelo_salida.equals("") || nro_vuelo_regreso.equals("")) {
			msj = "<div class='msjMal'> Complete el paso 2. </div>";
			return;
		}
		if(nro_documento_pasajero == null || pasajero == null) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. </div>";
			return;
		}
		if(nro_documento_pasajero.equals("") || pasajero.equals("")) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. </div>";
			return;
		}
		if(!isInteger(nro_documento_pasajero)) {
			msj = "<div class='msjMal'> El campo \"número de documento\" solo acepta números. </div>";
			return;
		}
		
		if(!facadeWebServiceVuelo.reservarAsiento(nro_vuelo_salida, nro_documento_pasajero, pasajero)) {
			msj = "<div class='msjMal'> La reserva no se realizó. Esto se debe a la falta de disponibilidad en el vuelo de ida que eligió. </div>";
			return;
		}
		
		if(!facadeWebServiceVuelo.reservarAsiento(nro_vuelo_regreso, nro_documento_pasajero, pasajero)){ // Cancelar reservas
			msj = "<div class='msjMal'> La reserva no se realizó. Esto se debe a la falta de disponibilidad en el vuelo de regreso que eligió. </div>";
			facadeWebServiceVuelo.cancelarReservacion(nro_vuelo_salida, nro_documento_pasajero);// Reserva 1
			return;
		}
		
		fechas = dameFechasDeReserva(fecha_salida, fecha_regreso);
		if(fechas != null) {
			for(int i = 0; i < fechas.size(); i++) {
				if(!facadeWebServiceHotel.reservarHabitacion(fechas.get(i), hotel_reservado, ciudad_destino, nro_documento_pasajero, pasajero)) { // Cancelar reservas
					facadeWebServiceVuelo.cancelarReservacion(nro_vuelo_salida, nro_documento_pasajero);// Reserva 1
					facadeWebServiceVuelo.cancelarReservacion(nro_vuelo_regreso, nro_documento_pasajero);// Reserva 2
					for(i -= 1; i >= 0; i--)
						facadeWebServiceHotel.cancelarReservacion(fechas.get(i), hotel_reservado, ciudad_destino, nro_documento_pasajero);// Reserva 3 
					msj = "<div class='msjMal'> La reserva no se realizó. Esto se debe a la falta de disponibilidad en el hotel que eligió. </div>";
					return;
				}
			}
		}
		else {
			msj = "<div class='msjMal'> No se puede realizar reservas entre años. </div>";
			return;
		}
		
		DTOreservas.setFecha_salida(fecha_salida);
		DTOreservas.setFecha_regreso(fecha_regreso);
		DTOreservas.setCiudad_origen(ciudad_origen);
		DTOreservas.setCiudad_destino(ciudad_destino);
		DTOreservas.setNro_documento_pasajero(nro_documento_pasajero);
		DTOreservas.setPasajero(pasajero);
		DTOreservas.setNro_vuelo_salida(nro_vuelo_salida);
		DTOreservas.setNro_vuelo_regreso(nro_vuelo_regreso);
		DTOreservas.setHotel_reservado(hotel_reservado);
		
		
		nro_reserva = facadeReservas.insert(DTOreservas);
		if(nro_reserva != null) {
			msj = "<div class='msjBien'> La reserva se realizó satisfactoriamente. Su número de reserva es " + nro_reserva + ", por favor guarde este número. </div>";
		}
		else {// Cancelar reservas
			facadeWebServiceVuelo.cancelarReservacion(nro_vuelo_salida, nro_documento_pasajero);// Reserva 1
			facadeWebServiceVuelo.cancelarReservacion(nro_vuelo_regreso, nro_documento_pasajero);// Reserva 2
			for(int i = 0; i < fechas.size(); i++)
				facadeWebServiceHotel.cancelarReservacion(fechas.get(i), hotel_reservado, ciudad_destino, nro_documento_pasajero);// Reserva 3
			msj = "<div class='msjMal'> La reserva no se realizó. Esto puede deberse a la falta de disponibilidad en el hotel o vuelos que eligió. </div>";
			return;
		}
	}
	
	public void selectReservas() {
		DTO.DTOReservas DTOreservas = new DTO.DTOReservas();
		facade.FacadeReservas facadeReservas = (facade.FacadeReservas) facade.FacadeFactory.getInstanceFacade("Reservas");
		
		if(nro_reserva == null) {
			msj = "<div class='msjMal'> Ingrese el número de reserva porfavor. </div>";
			return;
		}
		if(nro_reserva.equals("")) {
			msj = "<div class='msjMal'> Ingrese el número de reserva porfavor. </div>";
			return;
		}
			
		DTOreservas.setNro_reserva(nro_reserva);
		DTOreservas = facadeReservas.select(DTOreservas);
		if (DTOreservas.getNro_reserva() != null) {
			nro_reserva = DTOreservas.getNro_reserva();
			fecha_salida = DTOreservas.getFecha_salida();
			fecha_regreso = DTOreservas.getFecha_regreso();
			ciudad_origen = DTOreservas.getCiudad_origen();
			ciudad_destino = DTOreservas.getCiudad_destino();
			nro_documento_pasajero = DTOreservas.getNro_documento_pasajero();
			pasajero = DTOreservas.getPasajero();
			nro_vuelo_salida = DTOreservas.getNro_vuelo_salida();
			nro_vuelo_regreso = DTOreservas.getNro_vuelo_regreso();
			hotel_reservado = DTOreservas.getHotel_reservado();
			msj = "<div class='msjBien'> La reserva " + nro_reserva + " fue cargada correctamente. </div>";
		}
		else {
			nro_reserva = "";
			fecha_salida = "";
			fecha_regreso = "";
			ciudad_origen = "";
			ciudad_destino = "";
			nro_documento_pasajero = "";
			pasajero = "";
			nro_vuelo_salida = "";
			nro_vuelo_regreso = "";
			hotel_reservado = "";
			msj = "<div class='msjMal'> La reserva no fue cargada. Esto puede deberse a que dicha reserva no existe en la base de datos. </div>";
		}
	}
	//--
	
	
	// Consultas externas
	public void selectConsultaHotel() {
		String ctd_habitaciones_disponibles;
		facade.FacadeWebServiceHotel facadeWebServiceHotel = (facade.FacadeWebServiceHotel) facade.FacadeFactory.getInstanceFacade("WebServiceHotel");
		
		if(hotel_reservado == null || fecha_salida == null || ciudad_origen == null) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. </div>";
			return;
		}
		if(hotel_reservado.equals("") || fecha_salida.equals("") || ciudad_origen.equals("")) {
			msj = "<div class='msjMal'> Ingrese los datos porfavor. </div>";
			return;
		}
		
		ctd_habitaciones_disponibles = facadeWebServiceHotel.getCtdHabDisponibles(fecha_salida, hotel_reservado, ciudad_origen);
		
		if(ctd_habitaciones_disponibles == null) {
			msj = "<div class='msjMal'> La consulta no se realizo. Esto se puede deber a que el hotel en esa fecha y ciudad no esta cargado. </div>";
			return;
		}
		msj = "<div class='msjBien'> La cantidad de hablitaciones disponibles del hotel " + hotel_reservado + " es: <b>" + ctd_habitaciones_disponibles + "</b></div>";
	}

	public void selectConsultaVuelo() {
		String ctd_asientos_disponibles;
		facade.FacadeWebServiceVuelo facadeWebServiceVuelo = (facade.FacadeWebServiceVuelo) facade.FacadeFactory.getInstanceFacade("WebServiceVuelo");
		
		if(nro_vuelo_salida == null) {
			msj = "<div class='msjMal'> Ingrese el número de vuelo porfavor. </div>";
			return;
		}
		if(nro_vuelo_salida.equals("")) {
			msj = "<div class='msjMal'> Ingrese el número de vuelo porfavor. </div>";
			return;
		}
		
		ctd_asientos_disponibles = facadeWebServiceVuelo.getNroAsientosDisponibles(nro_vuelo_salida);
		
		if(ctd_asientos_disponibles == null) {
			msj = "<div class='msjMal'> La consulta no se realizo. Esto se puede deber a que el número de vuelo no exite. </div>";
			return;
		}
		msj = "<div class='msjBien'> La cantidad de asientos disponibles del vuelo " + nro_vuelo_salida + " es: <b>" + ctd_asientos_disponibles + "</b></div>";
	}
	//--
	
	
	// Utilidades
	private ArrayList<String> dameFechasDeReserva(String fechaSalida, String fechaRegreso) {
		String diaSalida, mesSalida, anoSalida, diaRegreso, mesRegreso, anoRegreso;
		ArrayList<String> fechas = new ArrayList<String>();
		int[] cntDiaPorMes = {0, 31, 28, 31, 30, 31, 30, 30, 31, 30, 31, 30, 31};
		
		// Cargo fechas de salida
		anoSalida = "" + fechaSalida.charAt(0) + fechaSalida.charAt(1) + fechaSalida.charAt(2) + fechaSalida.charAt(3);
		mesSalida = "" + fechaSalida.charAt(5);
		if(fechaSalida.charAt(6) != '-') {
			mesSalida += fechaSalida.charAt(6);
			diaSalida = "" + fechaSalida.charAt(8) + fechaSalida.charAt(9);
		}
		else {
			mesSalida = "0" + mesSalida;
			diaSalida = "" + fechaSalida.charAt(7) + fechaSalida.charAt(8);
		}
		//--
		
		// Cargo fechas de regreso
	    anoRegreso = "" + fechaRegreso.charAt(0) + fechaRegreso.charAt(1) + fechaRegreso.charAt(2) + fechaRegreso.charAt(3);
		mesRegreso = "" + fechaRegreso.charAt(5);
		if(fechaRegreso.charAt(6) != '-') {
			mesRegreso += fechaRegreso.charAt(6);
			diaRegreso = "" + fechaRegreso.charAt(8) + fechaRegreso.charAt(9);
		}
		else {
			mesRegreso = "0" + mesRegreso;
			diaRegreso = "" + fechaRegreso.charAt(7) + fechaRegreso.charAt(8);
		}
		//--
		
		for(int ano = Integer.parseInt(anoSalida); ano <= Integer.parseInt(anoRegreso) ; ano++) {
			if(Integer.parseInt(anoSalida) == Integer.parseInt(anoRegreso)) {
				for(int mes = Integer.parseInt(mesSalida); mes <= Integer.parseInt(mesRegreso) ; mes++) {
					if(Integer.parseInt(mesSalida) == Integer.parseInt(mesRegreso)) {
						for(int dia = Integer.parseInt(diaSalida); dia <= Integer.parseInt(diaRegreso) ; dia++) {
							fechas.add("" + ano + "-" + mes + "-" + dia);
						}
					}
					else {
						for(int dia = Integer.parseInt(diaSalida); dia <= cntDiaPorMes[Integer.parseInt(mesSalida)] ; dia++) {
							fechas.add("" + ano + "-" + mes + "-" + dia);
						}
						diaSalida = "1";
						mesSalida = "" + (Integer.parseInt(mesSalida) + 1);
					}
				}
			}
			else {
				return null;
			}
		}
		
		return fechas;
	}
	
	private String procesadorFecha(String fecha) {
		String dia, mes, ano;
		
		if(fecha != null) {
			if(fecha.length() != 0) {
				if(fecha.length() > 11) {
					mes = "" + fecha.charAt(4) + fecha.charAt(5) + fecha.charAt(6);
					if(mes.equals("Jan"))
						mes = "1";
					if(mes.equals("Feb"))
						mes = "2";
					if(mes.equals("Mar"))
						mes = "3";
					if(mes.equals("Apr"))
						mes = "4";
					if(mes.equals("May"))
						mes = "5";
					if(mes.equals("Jun"))
						mes = "6";
					if(mes.equals("Jul"))
						mes = "7";
					if(mes.equals("Aug"))
						mes = "8";
					if(mes.equals("Sep"))
						mes = "9";
					if(mes.equals("Oct"))
						mes = "10";
					if(mes.equals("Nov"))
						mes = "11";
					if(mes.equals("Dec"))
						mes = "12";		
					dia = "" + fecha.charAt(8) + fecha.charAt(9);
					ano = "" + fecha.charAt(24) + fecha.charAt(25) + fecha.charAt(26) + fecha.charAt(27);
					
					return (ano + "-" + mes + "-" + dia);
				}
				else
					return fecha;
			}
		}
		return null;
	}
	
	public Boolean esFechaActual(String fecha) {
		String diaActual, mesActual, anoActual;
		String dia, mes, ano;
		Integer feActual;
		Integer fe;
		
		// Cargo fecha actual
		java.util.Calendar fecha_actual = java.util.Calendar.getInstance();
		diaActual = "" + fecha_actual.get(java.util.Calendar.DATE);
		if(diaActual.length() == 1)
			diaActual = "0" + diaActual;
		mesActual = "" + (fecha_actual.get(java.util.Calendar.MONTH) + 1);
		if(mesActual.length() == 1)
			mesActual = "0" + mesActual;
		anoActual = "" + fecha_actual.get(java.util.Calendar.YEAR);
		feActual = Integer.parseInt("" + anoActual + "" + mesActual + "" + diaActual);
		//--
		
		// Cargo fecha
		ano = "" + fecha.charAt(0) + fecha.charAt(1) + fecha.charAt(2) + fecha.charAt(3);
		mes = "" + fecha.charAt(5);
		if(fecha.charAt(6) != '-') {
			mes += fecha.charAt(6);
			dia = "" + fecha.charAt(8) + fecha.charAt(9);
		}
		else {
			mes = "0" + mes;
			dia = "" + fecha.charAt(7) + fecha.charAt(8);
		}
		fe = Integer.parseInt("" + ano + "" + mes + "" + dia);
		//--
		
		// Verifico las fechas (la fecha actual tiene que ser menor que la fecha pasada por argumento)
		if(feActual < fe)
			return true;
		return false;
	}
	
	public Boolean validarEntreFechas(String fechaSalida, String fechaRegreso) {
		String diaSalida, mesSalida, anoSalida, diaRegreso, mesRegreso, anoRegreso;
		Integer feSalida, feRegreso;
			
		// Cargo fechas de salida
		anoSalida = "" + fechaSalida.charAt(0) + fechaSalida.charAt(1) + fechaSalida.charAt(2) + fechaSalida.charAt(3);
		mesSalida = "" + fechaSalida.charAt(5);
		if(fechaSalida.charAt(6) != '-') {
			mesSalida += fechaSalida.charAt(6);
			diaSalida = "" + fechaSalida.charAt(8) + fechaSalida.charAt(9);
		}
		else {
			mesSalida = "0" + mesSalida;
			diaSalida = "" + fechaSalida.charAt(7) + fechaSalida.charAt(8);
		}
		feSalida = Integer.parseInt("" + anoSalida + "" + mesSalida + "" + diaSalida);
		//--
		
		// Cargo fechas de regreso
	    anoRegreso = "" + fechaRegreso.charAt(0) + fechaRegreso.charAt(1) + fechaRegreso.charAt(2) + fechaRegreso.charAt(3);
		mesRegreso = "" + fechaRegreso.charAt(5);
		if(fechaRegreso.charAt(6) != '-') {
			mesRegreso += fechaRegreso.charAt(6);
			diaRegreso = "" + fechaRegreso.charAt(8) + fechaRegreso.charAt(9);
		}
		else {
			mesRegreso = "0" + mesRegreso;
			diaRegreso = "" + fechaRegreso.charAt(7) + fechaRegreso.charAt(8);
		}
		feRegreso = Integer.parseInt("" + anoRegreso + "" + mesRegreso + "" + diaRegreso);
		//--
		
		// Verifico las fechas (fecha salida debe ser menos que fecha regreso)
		if(feSalida < feRegreso)
			return true;
		return false;
	}
	
	private boolean isInteger(String numero) {
		if(numero != null) {
			try {
				Integer.parseInt(numero);
				return true;
			}
			catch(Exception e) {
				return false;
			}
		}
		return false;
	}
	//--
}