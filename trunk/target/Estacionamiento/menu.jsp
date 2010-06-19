<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" type="text/javascript">
//--------------- LOCALIZEABLE GLOBALS ---------------
var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//Ensure correct for language. English is "January 1, 2004"
var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
//---------------   END LOCALIZEABLE   ---------------
</script>
<link href="css/estacionamiento.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#F4FFE4">
<jsp:include page="cabecera.jsp"></jsp:include>
<table width="100%" border="0" cellspacing="0" cellpadding="0">


 <tr>
    <td width="50"><img src="mm_spacer.gif" alt="" width="50" height="1" border="0" /></td>
    <td colspan="2" valign="top"><img src="mm_spacer.gif" alt="" width="305" height="1" border="0" /><br />
	&nbsp;<br />
	&nbsp;<br />
	<table border="0" cellspacing="0" cellpadding="0" width="470">

		<tr>
		  <td class="bodyText">&nbsp;</td>
	    </tr>
		<tr>
		  <td class="TextoFijo"><div align="center"><a href="disponibilidad.jsp">Disponibilidad de Ubicaciones</a></div></td>
	    </tr>
		<tr>
		  <td class="TextoFijo"><div align="center"></div></td>
	    </tr>
		<tr>
		  <td class="bodyText">&nbsp;</td>
	    </tr>
        
		<tr>
          <td class="TextoFijo"><p align="center"><a href="registrovehiculo.jsp">Registo de Vehiculos</a></p>		</td>
        </tr>
		<tr>
		  <td class="TextoFijo"><div align="center"></div></td>
	    </tr>
		<tr>
		  <td class="bodyText">&nbsp;</td>
	    </tr>
        
		<tr>
          <td class="TextoFijo"><p align="center"><a href="reporteestado.jsp">Estado de Estacionamientos</a></p>		</td>
        </tr>        
      </table>
	 <br />
	&nbsp;<br />	</td>
    <td width="54"><img src="mm_spacer.gif" alt="" width="50" height="1" border="0" /></td>
        <td width="273">&nbsp;</td>
  </tr>
  <tr>
    <td width="50">&nbsp;</td>
    <td width="20">&nbsp;</td>
    <td width="457">&nbsp;</td>
    <td width="54">&nbsp;</td>
    <td width="273">&nbsp;</td>
  </tr>
</table>


</body>
</html>
