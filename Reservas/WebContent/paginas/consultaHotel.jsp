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
		<title> Reservas | Consulta Hotel </title>
	</head>
	<body>
		<a4j:region>
			<rich:panel style="border: 0px;">
				<div class="tituloPrincipal"> Consultas externas </div>
				<div class="textoNormal">
					En esta sección podrás consultar la cantidad de habitaciones disponibles en un hotel, fecha y ciudad específica.
				</div>
				<div class="titulo"> Ingresa el hotel, fecha y ciudad </div>
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
											<h:outputText id="mensajeConsultaHotel" value="#{beanP.msj}" escape="false"/>
										</div>
										<center class="ventana">
											<a4j:commandButton value="Aceptar" action="#{beanP.cargandoMsj}" reRender="mensajeConsultaHotel" onclick="JavaScript: document.getElementById('1').style.display = 'none';"/>
										</center>
									</div>
								</div>
							</div>
							<a4j:commandButton value="Consultar" action="#{beanP.selectConsultaHotel}" reRender="mensajeConsultaHotel" onclick="JavaScript: document.getElementById('1').style.display = 'block';">
		                    	<br/>
		                    	<h:panelGrid columns="3">
			                    	<h:graphicImage value="/img/hotel.png" width="128px"/>
			                    	<h:column>
			                    		<div style="width: 20px"></div>
				                    </h:column>
			                    	<h:column>
				                    	<table border=0>
				                    		<tr>
				                    			<td class="columnas"> Hotel </td>
				                    			<td class="columnas"> <h:inputText value="#{beanP.hotel_reservado}" size="20" maxlength="35"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="columnas"> Fecha </td>
				                    			<td class="columnas"> <rich:calendar datePattern="dd/MM/yyyy" value="#{beanP.fecha_salida}"/> <br/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="columnas"> Ciudad </td>
				                    			<td class="columnas"> <rich:comboBox defaultLabel="Ubicación del Hotel" suggestionValues="#{beanP.ciudadesString}" directInputSuggestions="true" enableManualInput="false" value="#{beanP.ciudad_origen}"/> </td>
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