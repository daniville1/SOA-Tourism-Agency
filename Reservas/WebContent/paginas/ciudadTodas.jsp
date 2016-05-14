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
		<title> Reservas | Ciudades </title>
	</head>
	<body>
		<a4j:region>
			<rich:panel style="border: 0px;">
				<div class="tituloPrincipal"> Ciudad </div>
				<div class="textoNormal">
					En esta sección podrás ver las diferentes ciudades en las que trabajamos, esperamos que este la que deseas. 
				</div>
				<div class="titulo"> Ciudades </div>
				<div class="cuerpo">
					<h:form>
						<center>
	                    	<h:panelGrid columns="3">
		                    	<h:graphicImage value="/img/ciudad.png"/>
		                    	<h:column>
		                    		<div style="width: 20px"></div>
			                    </h:column>
		                    	<h:column>
			                    	<rich:dataGrid value="#{beanP.ciudades}" var="ciudades" columns="1"  width="400px" >
				            			<h:outputText value="#{ciudades.ciudad}"/>
				            			<h:outputLink value="http://www.google.com.ar/search?q=provincia+#{ciudades.ciudad}">
				            				<f:verbatim> Mas informacion </f:verbatim>
				            			</h:outputLink>
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