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
		<title> Reservas | Consultar Reserva </title>
	</head>
	<body>
		<a4j:region>
			<rich:panel style="border: 0px;">
				<div class="tituloPrincipal"> Reservas </div>
				<div class="textoNormal">
					 En esta sección podrás consultar diferentes reservas, para ello deberás ingresar el número de reserva en el cuadro. Si el número de reserva no existe no será posible la consulta.
				</div>
				<div class="titulo"> Consultar Reserva </div>
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
											<h:outputText id="mensajeReservaConsultar" value="#{beanP.msj}" escape="false"/>
										</div>
										<center class="ventana">
											<a4j:commandButton value="Aceptar" action="#{beanP.cargandoMsj}" reRender="mensajeReservaConsultar" onclick="JavaScript: document.getElementById('1').style.display = 'none';"/>
										</center>
									</div>
								</div>
							</div>
							<a4j:commandButton value="Buscar" action="#{beanP.selectReservas}" reRender="mensajeReservaConsultar, datosReserva" onclick="JavaScript: document.getElementById('1').style.display = 'block';">
		                    	<br/>
		                    	<h:panelGrid columns="3">
			                    	<h:graphicImage value="/img/reservasBuscar.png" width="64px"/>
			                    	<h:column>
			                    		<div style="width: 20px"></div>
				                    </h:column>
			                    	<h:column>
				                    	<table border=0>
				                    		<tr>
				                    			<td class="columnas"> Número de reserva </td>
				                    			<td class="columnas"> <h:inputText value="#{beanP.nro_reserva}" size="25" maxlength="10"/> </td>
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
            	<div class="titulo"> Datos de la reserva </div>
				<div class="cuerpo">
					<h:form>
						<center>
	                    	<br/>
	                    	<a4j:outputPanel id="datosReserva">
		                    	<h:panelGrid columns="3">
			                    	<h:graphicImage value="/img/reservas.png" width="64px"/>
			                    	<h:column>
			                    		<div style="width: 20px"></div>
				                    </h:column>
			                    	<h:column>
				                    	<table border=0>
				                    		<tr>
				                    			<td class="derecha"> Número de reserva: </td>
				                    			<td> <h:outputText value="#{beanP.nro_reserva}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Fecha de salida: </td>
				                    			<td> <h:outputText value="#{beanP.fecha_salida}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Fecha de regreso: </td>
				                    			<td> <h:outputText value="#{beanP.fecha_regreso}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Ciudad origen: </td>
				                    			<td> <h:outputText value="#{beanP.ciudad_origen}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Ciudad destino: </td>
				                    			<td> <h:outputText value="#{beanP.ciudad_destino}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Número de documento del pasajero: </td>
				                    			<td> <h:outputText value="#{beanP.nro_documento_pasajero}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Nombre del pasajero: </td>
				                    			<td> <h:outputText value="#{beanP.pasajero}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Número del vuelo de salida: </td>
				                    			<td> <h:outputText value="#{beanP.nro_vuelo_salida}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Número del vuelo de regreso: </td>
				                    			<td> <h:outputText value="#{beanP.nro_vuelo_regreso}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Hotel reservado: </td>
				                    			<td> <h:outputText value="#{beanP.hotel_reservado}"/> </td>
				                    		</tr>					                    		
				                    	</table>			                    		
			                    	</h:column>
		                   		</h:panelGrid>
		                   	</a4j:outputPanel>
	                    	<br/>
		            	</center>
					</h:form>
            	</div>
			</rich:panel>
		</a4j:region>
	</body>
</html>