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
		<title> Reservas | Reservas </title>
	</head>
	<body>
		<a4j:region>
			<rich:panel style="border: 0px;">
				<div class="tituloPrincipal"> Reservas </div>
				<div class="textoNormal">
					En esta sección podrás ver todas las reservas que se realizaron en Reservas.com, tenga en cuenta que este profeso puede tomar cierto tiempo.
				</div>
				<div class="titulo"> Reservas </div>
				<div class="cuerpo">
					<h:form>
						<center>
	                    	<h:panelGrid columns="3">
		                    	<h:graphicImage value="/img/reservas.png"/>
		                    	<h:column>
		                    		<div style="width: 20px"></div>
			                    </h:column>
		                    	<h:column>
			                    	<rich:dataGrid value="#{beanP.reservas}" var="reservas" columns="1"  width="400px" >
			                    		<table border=0>
				                    		<tr>
				                    			<td class="derecha"> Número de reserva: </td>
				                    			<td> <h:outputText value="#{reservas.nro_reserva}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Fecha de salida: </td>
				                    			<td> <h:outputText value="#{reservas.fecha_salida}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Fecha de regreso: </td>
				                    			<td> <h:outputText value="#{reservas.fecha_regreso}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Ciudad origen: </td>
				                    			<td> <h:outputText value="#{reservas.ciudad_origen}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Ciudad destino: </td>
				                    			<td> <h:outputText value="#{reservas.ciudad_destino}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Número de documento del pasajero: </td>
				                    			<td> <h:outputText value="#{reservas.nro_documento_pasajero}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Nombre del pasajero: </td>
				                    			<td> <h:outputText value="#{reservas.pasajero}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Número del vuelo de salida: </td>
				                    			<td> <h:outputText value="#{reservas.nro_vuelo_salida}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Número del vuelo de regreso: </td>
				                    			<td> <h:outputText value="#{reservas.nro_vuelo_regreso}"/> </td>
				                    		</tr>
				                    		<tr>
				                    			<td class="derecha"> Hotel reservado: </td>
				                    			<td> <h:outputText value="#{reservas.hotel_reservado}"/> </td>
				                    		</tr>					                    		
				                    	</table>
							        </rich:dataGrid>		                    		
		                    	</h:column>
	                   		</h:panelGrid>
		            	</center>
					</h:form>
            	</div>
			</rich:panel>
		</a4j:region>		
	</body>
</html>