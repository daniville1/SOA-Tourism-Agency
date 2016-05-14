<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="shortcut icon" href="/Cotizacion/img/logo.png"/>
		<link rel="stylesheet" type="text/css" href="/Cotizacion/estilo.css">
		<title> Reservas | Agregar Reserva </title>
	</head>
	<body>
		<a4j:region>
			<rich:panel style="border: 0px;">
				<div class="tituloPrincipal"> Reservas </div>
				<div class="textoNormal">
					 En esta sección podrás reservar un paquete a tu medida, para ello sigue los siguientes pasos, tres en total. Primero ingresando fecha y destino, luego el hotel y vuelo, y finalmente tus datos personales. <br/> Las reservas están <b>limitadas</b> a la cantidad de asientos en los aviones y la cantidad de habitaciones en los hoteles en la fecha y destino que elijas.
				</div>
				<div class="titulo"> PASO 1: Elige la fecha y destino </div>
				<div class="cuerpo">
					<h:form>
						<center>
							<div id="1" style="display: none;">
								<div class='preVentana'><br/></div>
								<div class='contenedorVentana'>
									<div class='ventana'>
										<div class='marcoTituloVentana'>
											Información
										</div>
										<div class='marcoCuerpoVentana'>
											<h:outputText id="mensajeReservaAgregarPaso1" value="#{beanP.msj}" escape="false"/>
										</div>
										<center class="ventana">
											<a4j:commandButton value="Aceptar" action="#{beanP.cargandoMsj}" reRender="mensajeReservaAgregarPaso1" onclick="JavaScript: document.getElementById('1').style.display = 'none';"/>
										</center>
									</div>
								</div>
							</div>
							<a4j:commandButton value="Siguiente" action="#{beanP.insertReservasPaso1}" reRender="mensajeReservaAgregarPaso1, reservaAgregarPaso2" onclick="JavaScript: document.getElementById('1').style.display = 'block';">
		                    	<br/>
		                    	<h:panelGrid columns="3">
			                    	<h:graphicImage value="/img/lugarFecha.png" width="128px"/>
			                    	<h:column>
			                    		<div style="width: 20px"></div>
				                    </h:column>
			                    	<h:column>
				                    	<table border=0>
				                    		<tr>
				                    			<td class="columnas"> Ciudad origen </td>
				                    			<td class="columnas"> <rich:comboBox defaultLabel="Donde estas" suggestionValues="#{beanP.ciudadesString}" directInputSuggestions="true" enableManualInput="false" value="#{beanP.ciudad_origen}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="columnas"> Ciudad destino </td>
				                    			<td class="columnas"> <rich:comboBox defaultLabel="Donde vas" suggestionValues="#{beanP.ciudadesString}" directInputSuggestions="true" enableManualInput="false" value="#{beanP.ciudad_destino}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="columnas"> Fecha salida </td>
				                    			<td class="columnas"> <rich:calendar datePattern="dd/MM/yyyy" value="#{beanP.fecha_salida}"/> <br/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="columnas"> Fecha regreso </td>
				                    			<td class="columnas"> <rich:calendar datePattern="dd/MM/yyyy" value="#{beanP.fecha_regreso}"/> <br/> </td>
				                    		</tr>
				                    	</table>			                    		
			                    	</h:column>
		                   		</h:panelGrid>
		                    	<br/>
		                    </a4j:commandButton>
		            	</center>
					</h:form>
            	</div>
            	
            	<br/>
            	<div class="titulo"> PASO 2: Elige un Hotel y vuelo </div>
				<div class="cuerpo">
					<h:form>
						<center>
							<div id="2" style="display: none;">
								<div class='preVentana'><br/></div>
								<div class='contenedorVentana'>
									<div class='ventana'>
										<div class='marcoTituloVentana'>
											Información
										</div>
										<div class='marcoCuerpoVentana'>
											<h:outputText id="mensajeReservaAgregarPaso2" value="#{beanP.msj}" escape="false"/>
										</div>
										<center class="ventana">
											<a4j:commandButton value="Aceptar" action="#{beanP.cargandoMsj}" reRender="mensajeReservaAgregarPaso2" onclick="JavaScript: document.getElementById('2').style.display = 'none';"/>
										</center>
									</div>
								</div>
							</div>
							<a4j:commandButton value="Siguiente" action="#{beanP.insertReservasPaso2}" reRender="mensajeReservaAgregarPaso2" onclick="JavaScript: document.getElementById('2').style.display = 'block';">
		                    	<br/>
		                    	<a4j:outputPanel id="reservaAgregarPaso2">
			                    	<h:panelGrid columns="3">
				                    	<h:graphicImage value="/img/hotelAvion.png" width="64px"/>
				                    	<h:column>
				                    		<div style="width: 20px"></div>
					                    </h:column>
				                    	<h:column>
					                    	<table border=0>
					                    		<tr>
					                    			<td class="columnas"> Elige tu hotel </td>
					                    			<td class="columnas"> <rich:comboBox defaultLabel="Elige un hotel" suggestionValues="#{beanP.hoteles}" directInputSuggestions="true" enableManualInput="false" value="#{beanP.hotel_reservado}"/> </td>
					                    		</tr>
					                    		<tr>
					                    			<td class="columnas"> Elige tu vuelo de salida </td>
					                    			<td class="columnas"> <rich:comboBox defaultLabel="Elige tu vuelo de salida" suggestionValues="#{beanP.vuelosSalida}" directInputSuggestions="true" enableManualInput="false" value="#{beanP.nro_vuelo_salida}"/> </td>
					                    		</tr>
					                    		<tr>
					                    			<td class="columnas"> Elige tu vuelo de regreso </td>
					                    			<td class="columnas"> <rich:comboBox defaultLabel="Elige tu vuelo de regreso" suggestionValues="#{beanP.vuelosRegreso}" directInputSuggestions="true" enableManualInput="false" value="#{beanP.nro_vuelo_regreso}"/> </td>
					                    		</tr>
					                    	</table>			                    		
				                    	</h:column>
			                   		</h:panelGrid>
			                   	</a4j:outputPanel>
		                    	<br/>
		                    </a4j:commandButton>
		            	</center>
					</h:form>
            	</div>
	            	
            	<br/>
            	<div class="titulo"> PASO 3: Ingresa tus datos personales para finalizar</div>
				<div class="cuerpo">
					<h:form>
						<center>
							<div id="3" style="display: none;">
								<div class='preVentana'><br/></div>
								<div class='contenedorVentana'>
									<div class='ventana'>
										<div class='marcoTituloVentana'>
											Información
										</div>
										<div class='marcoCuerpoVentana'>
											<h:outputText id="mensajeReservaAgregarPaso3" value="#{beanP.msj}" escape="false"/>
										</div>
										<center class="ventana">
											<a4j:commandButton value="Aceptar" action="#{beanP.reservasAgregar}" reRender="pagina"/>
										</center>
									</div>
								</div>
							</div>
							<a4j:commandButton value="Reservar" action="#{beanP.insertReservasPaso3}" reRender="mensajeReservaAgregarPaso3" onclick="JavaScript: document.getElementById('3').style.display = 'block';">
		                    	<br/>
		                    	<h:panelGrid columns="3">
			                    	<h:graphicImage value="/img/datosPersonales.png" width="64px"/>
			                    	<h:column>
			                    		<div style="width: 20px"></div>
				                    </h:column>
			                    	<h:column>
				                    	<table border=0>
				                    		<tr>
				                    			<td class="columnas"> Número de documento </td>
				                    			<td class="columnas"> <h:inputText value="#{beanP.nro_documento_pasajero}" size="35" maxlength="10"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="columnas"> Nombre </td>
				                    			<td class="columnas"> <h:inputText value="#{beanP.pasajero}" size="35" maxlength="35"/> </td>
				                    		</tr>
				                    	</table>			                    		
			                    	</h:column>
		                   		</h:panelGrid>
		                    	<br/>
		                    </a4j:commandButton>
		            	</center>
					</h:form>
            	</div>
			</rich:panel>
		</a4j:region>		
	</body>
</html>