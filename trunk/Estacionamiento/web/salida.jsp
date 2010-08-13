<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ page import="java.util.Date, com.estacionamiento.util.Fecha" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema Estacionamiento</title>
<link href="styles/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
function aceptar(){
    var f= document.forms[0];
    f.operacion.value="aceptar";
    f.submit();
}
</script>
</head>

<body class="oneColElsCtrHdr" onload="MM_preloadImages('img/registro_vehiculos_2.png')">

<div id="container">
  <div id="header">
    <!-- end #header --></div>
  <div id="ing_sal">

<html:form action="/ingresoSalidaAction" >
<html:hidden property="operacion" />

<table width="924" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="3"><img src="img/tit_salida.jpg" width="924" height="31" /></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="73">&nbsp;</td>
    <td width="285">&nbsp;</td>
    <td width="583">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td class="bigtext2">UBICACIÓN</td>
    <td class="bigtext1"><bean:write name="ubicacionBean" property="ubicacion" /></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td class="bigtext2">FECHA - HORA</td>
    <td class="bigtext2"><%= Fecha.getFormattedDate(new Date(), "dd/MM/yyyy HH:mm:ss")%></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td class="bigtext2">&nbsp;</td>
    <td class="bigtext2">&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td class="bigtext2">USUARIO</td>
    <td class="bigtext2"><bean:write name="ubicacionBean" property="usuario" /></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td class="bigtext2">&nbsp;</td>
    <td class="bigtext2">&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td class="bigtext2">ESTACIONAMIENTO</td>
    <td class="bigtext2"><bean:write name="ubicacionBean" property="nombreEstacionamiento" /></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>
      <label>
        <a href="javascript:aceptar()">
	      <img src="img/aceptar.JPG"  border="0" align="center">
	</a>
      </label>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

  
  </html:form>
  <!-- end #ing_sal --></div>

<!-- end #container --></div>
<p>&nbsp;</p>
</body>
</html>
