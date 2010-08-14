
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
    <body onload="mueveReloj()">﻿


<script language="javascript">

function MuestraReporte()
	{
	location.href = "reporte.html";
	}


function MuestraInicio(){
	//location.href = "menucenter.html";
        var f = document.forms[0];
	f.operacion.value="muestraReporte";
	f.submit();
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

 	  setTimeout("mueveReloj()",1000)
}



</script>

	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		      <title>Pagina de Login - Estacionamiento UPC</title>
	</head>

      
	<center>
  <td> <font size=6> <b>INGRESO - SISTEMA DE ESTACIONAMIENTO</b></font> </td>
<html:form action="/login">
    <html:hidden property="operacion" />
    
		<%--- EmpleadoServlet ---%>
			<input type="text" name="reloj" size="10">
			<input type="text" name="fecha" size="40">
    <table>
      <tr> <img src="file:///E|/Web/logo_upc.jpg" alt="descripción" /> </tr>
      <tr>
        <td>Usuario UPC</td>
        <td>
            <html:text property="user" />
          
        </td>
      </tr>
      <tr>
        <td>Contrase&ntilde;a</td>
        <td>
             <html:password property="pwd" />
        </td>
      </tr>
    </table>
    <table>
			<tr>
				<td> <a href="javascript:MuestraReporte()">
				     <img src="file:///E|/Web/IngresarSistema.gif" width="106" height="20">
				</a></td>


        <td> <a href="javascript:MuestraInicio()"> </a><a href="javascript:MuestraInicio()"><img src="file:///E|/Web/SalirSistema.gif" width="106" height="20"></a></td>
			</tr>

		</table>

		<table>
			<tr>
				<td> <%if(request.getAttribute("mensaje")!=null){out.print((String) request.getAttribute("mensaje"));
					}
					%>
				</td>

			</tr>
 		</table>

</html:form>
	</center>
	</body>
</html:html>
