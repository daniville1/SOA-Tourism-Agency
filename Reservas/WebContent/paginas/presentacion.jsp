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
		<title> Reservas | Presentacion </title>
		<script type = "text/JavaScript">
			var imagen;
			var tiempo;
			
			function inicializacion() {
				imagen = 1;
				tiempo = 10000;
				
				setTimeout("cambiarImagen()", tiempo);
			}
			
			function cambiarImagen() {
				imagen = imagen + 1;
				document.getElementById('imagenPresentacion').src = "/Reservas/img/presentacion" + imagen + ".png";
				if(imagen == 9)
					imagen = 0;
				setTimeout("cambiarImagen()", tiempo);
			}

			function cambiarImagenSinTiempo() {
				imagen = imagen + 1;
				document.getElementById('imagenPresentacion').src = "/Reservas/img/presentacion" + imagen + ".png";
				if(imagen == 9)
					imagen = 0;
			}
	    </script>
	</head>
	<body onload="inicializacion();">
		<div class="tituloPrincipal"> Bienvenido </div>
		
		<img title="Haga click para pasar a la siguiente imagen." id="imagenPresentacion" class="presentacion" src="/Reservas/img/presentacion1.png" onclick=" cambiarImagenSinTiempo();"/>
		
		<div class="titulo"> Bienvenido! </div>
		<div class="cuerpo">
			Bienvenido a reservas.com, sus paquetes de viaje en el acto. Elige un lugar y fecha de descanso y nosotros te daremos la alternativa correcta.
			<br/><br/>
			Nuestros paquetes constan de los viajes de ida y vuelta en un lujoso avión, como así también el hotel en que se hospedara.
			<br/>
			Gracias por disfrutar de nuestros servicios.
			<br/><br/>
	        <iframe src="http://www.facebook.com/widgets/like.php?href=http://www.reservas.com" scrolling="no" frameborder="0" style="border:none; height:30px; width: 74px;"></iframe>		
		</div>
		
		<div class="titulo"> Razones por las que viajar nos hace bien </div>
		<div class="cuerpo">
			<div class="textoTitulo"> Obtienes independencia: </div>
			Un viaje nos vuelve más maduros e incrementa nuestra capacidad de cuidarnos solos, especialmente si lo hacemos en solitario. Viajar sin compañía puede parecer aburrido, pero tiene su encanto: es un gran desafío para conocernos más a nosotros mismos y descubrir nuestra habilidad para adaptarnos a un nuevo lugar sin depender de nadie.
			<br/><br/>
			
			<div class="textoTitulo"> Somos más felices en casa: </div>
			Viajar y pasar unos días viviendo en un hotel lujoso es tentador, pero no hay nada que se pueda comparar con nuestra propia casa. Quizá disfrutes de una estadía en una suite con todas las comodidades pero llegará el momento en que vas a querer volver a tu cama. Lo mismo sucede con la gente: cuando estamos lejos extrañamos a nuestros seres queridos y nos damos cuenta lo importante que son para nosotros. La distancia nos ayuda a darnos cuenta del valor de lo que tenemos.
			<br/><br/>
			
			<div class="textoTitulo"> Permite la reflexión: </div>
			Estar en un lugar diferente y completamente desconectado de nuestra rutina, nos hace ver las cosas de otra manera. Viajar es una terapia que nos ayuda a reflexionar.
			<br/><br/>
			
			<div class="textoTitulo"> Construye relaciones: </div>
			Compartir la experiencia de viajar con otra persona es una experiencia que, sin duda, hará más fuerte el vínculo que los une. Sea con una pareja, con un amigo o con toda la familia, recorrer nuevos lugares acompañado es una manera de fortalecer la relación.
		</div>
	</body>
</html>