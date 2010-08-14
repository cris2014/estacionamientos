<%-- 
    Document   : REPORTE
    Created on : 23/05/2010, 02:08:01 PM
	Author     : JVillar
--%>

<script language="javascript">
function RetornaInicio()
	{
	location.href = "menucenter.html";
	}	


function mueveReloj() {
	var fecha=new Date();
	var diames=fecha.getDate();
	var diasemana=fecha.getDay();
	var mes=fecha.getMonth() +1 ;
	var ano=fecha.getFullYear();
	var hora = fecha.getHours() 
	var minuto = fecha.getMinutes() 
	var segundo = fecha.getSeconds() 
	var textosemana = new Array (7); 
	  textosemana[0]="Domingo";
	  textosemana[1]="Lunes";
	  textosemana[2]="Martes";
	  textosemana[3]="Miércoles";
	  textosemana[4]="Jueves";
	  textosemana[5]="Viernes";
	  textosemana[6]="Sábado";
	var textomes = new Array (12);
	  textomes[1]="Enero";
	  textomes[2]="Febrero";
	  textomes[3]="Marzo";
	  textomes[4]="Abril";
	  textomes[5]="Mayo";
	  textomes[6]="Junio";
	  textomes[7]="Julio";
	  textomes[7]="Agosto";
	  textomes[9]="Septiembre";
	  textomes[10]="Octubre";
	  textomes[11]="Noviembre";
	  textomes[12]="Diciembre";

	  horaImprimible = hora + " : " + minuto + " : " + segundo 
	  fechaImprimible = "Fecha: " + textosemana[diasemana] + ", " + diames + " de " + textomes[mes] + " de " + ano  

	  document.form_reloj.reloj.value = horaImprimible 
	  document.form_reloj.fecha.value = fechaImprimible

}


</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Estacionamiento</title>

   	</head>
	<body onload="mueveReloj()">

		<center>
			<form name="form_reloj">

	                <img src="file:///E|/Web/logo_2.jpg" >
                
				<h1> Gracias por su Visita  </h1>
				<h1> Hora de Salida  </h1>
				 <tr> <input type="text" name="reloj" size="10" > </tr>
				 <tr> <input type="text" name="fecha" size="40" > </tr>
				<table>
					<tr>
						<td>
							<h1>Alumno</h1>
						</td>
					</tr>
					<tr>
						<td>
							<h1>Villar Urdanivia, James</h1>
							<h1>U720822</h1>
						</td>
					</tr>
				</table>
                
			    <a href="javascript:RetornaInicio()"><img src="file:///E|/Web/Aceptar.gif" width="95" height="26"></a>
		      <tr></tr>
 		      </form>
		</center>
	</body>
</html>