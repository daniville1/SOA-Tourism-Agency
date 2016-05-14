<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="shortcut icon" href="/Reservas/img/logo.png"/>
		<link rel="stylesheet" type="text/css" href="/Reservas/estilo.css">
		<title> Reservas </title>
		<script language="javascript"> document.onkeydown = function() { if(window.event && window.event.keyCode == 116) return false; } </script>
	</head>
	<body>
		<center>
			<f:view>
				<h:form style="margin: 0px; border: 0px; padding: 0px;">
					<div class="contenedorArriba">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<rich:menuItem icon="/img/icoHome.png" action="#{beanP.home}" style="background: none; border-color: transparent; color: white; margin: 6px;"> Home </rich:menuItem>
								</td>
								<td>
									<div style="width: 460px"></div>
								</td>
								<td>
									<rich:dropDownMenu value="Ciudad">
										<rich:menuItem icon="/img/icoAgregar.png" action="#{beanP.ciudadAgregar}" reRender="pagina"> Agregar </rich:menuItem>
										<rich:menuItem icon="/img/icoModificar.png" action="#{beanP.ciudadModificar}" reRender="pagina"> Modificar </rich:menuItem>
										<rich:menuItem icon="/img/icoEliminar.png" action="#{beanP.ciudadEliminar}" reRender="pagina"> Eliminar </rich:menuItem>
										<rich:menuItem icon="/img/icoTodo.png" action="#{beanP.ciudadTodas}" reRender="pagina"> Todas </rich:menuItem>
									</rich:dropDownMenu>
								</td>
								<td width="20px">
								|
								</td>
								<td>
									<rich:dropDownMenu value="Reservas">
										<rich:menuItem icon="/img/icoAgregar.png" action="#{beanP.reservasAgregar}" reRender="pagina"> Agregar </rich:menuItem>
										<rich:menuItem icon="/img/icoEliminar.png" action="#{beanP.reservasEliminar}" reRender="pagina"> Eliminar </rich:menuItem>
										<rich:menuItem icon="/img/icoBuscar.png" action="#{beanP.reservasConsultar}" reRender="pagina"> Consultar </rich:menuItem>
										<rich:menuItem icon="/img/icoTodo.png" action="#{beanP.reservasTodas}" reRender="pagina"> Todas </rich:menuItem>
									</rich:dropDownMenu>
								</td>
								<td width="20px">
								|
								</td>
								<td>
									<rich:dropDownMenu value="Consultas externas">
										<rich:menuItem icon="/img/icoHotel.png" action="#{beanP.consultaHotel}" reRender="pagina"> Hoteles </rich:menuItem>
										<rich:menuItem icon="/img/icoVuelo.png" action="#{beanP.consultaVuelo}" reRender="pagina"> Vuelos </rich:menuItem>
									</rich:dropDownMenu>
								</td>
							</tr>
						</table>
					</div>
					<div class="contenedorMedio">
						<h:outputText value="#{beanP.inicio}"/>
						<a4j:include id="pagina" viewId="#{beanP.pagina}"/>
					</div>
					<div class="contenedorAbajo">
						Copyright © 2011 (reservas.com) | Todos Los Derechos Reservados | Creado por: Iván Daniel Villegas Rojas | Argentina, Córdoba
					</div>
				</h:form>
			</f:view>
		</center>
	</body>
</html>