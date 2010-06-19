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
<table width="780" border="0" cellspacing="2" cellpadding="2">

  <tr>
    <td >&nbsp;</td>
  </tr>
 <tr>


    <td colspan="2" valign="top">
    <form id="form1" name="form1" method="post" action="">
          <div align="center">
	<table border="0" cellspacing="2" cellpadding="2" width="90%">

		<tr>
		  <td colspan="3">
		    <div align="left" class="CeldaTitulo2">SALIDA ESTACIONAMIENTO</div>
		  </div>		    
		  </td>
	      </tr>
		<tr>
		  <td width="25%" class="TextoFijo">&nbsp;</td>
	      <td width="45%" class="TextoFijo">&nbsp;</td>
	      <td width="30%" class="TextoFijo">
       </td>
		</tr>
		<tr>
		  <td valign="top" class="TextoFijo"><div align="left">Ubicación :</div></td>
		  <td height="60"> <h1 align="left">A2 - 15 </h1></td>
		  <td class="TextoFijo">&nbsp;</td>
		  </tr>
		<tr>
		  <td class="TextoFijo"><div align="left">Fecha y Hora :</div></td>
	      <td height="20" colspan="2" class="TextoFijo"><div align="left">13/06/2010 15:15:15 </div></td>
	      </tr>
		<tr>
		  <td class="TextoFijo"><div align="left">Usuario :</div></td>
		  <td height="20" colspan="2" class="TextoFijo"><div align="left">U913833 - IVAN LUNA VIGO</div></td>
		  </tr>
		<tr>
		  <td class="TextoFijo"><div align="left">Estacionamiento :</div></td>
		  <td height="20" colspan="2" class="TextoFijo"><div align="left">ESTACIONAMIENTO 1</div></td>
		  </tr>
		<tr>
		  <td class="TextoFijo">&nbsp;</td>
		  <td height="20" class="TextoFijo">&nbsp;</td>
		  <td height="20" class="TextoFijo">&nbsp;</td>
		</tr>
		<tr>
		  <td class="TextoFijo">&nbsp;</td>
		  <td height="20" class="TextoFijo"><div align="center"><a href="login1.jsp"><img src="btAceptar_0.gif" width="100" height="30" /></a></div></td>
		  <td height="20" class="TextoFijo">&nbsp;</td>
		  </tr>
      </table>
</div>
    </form>	      
	 
</td>
  </tr>
  <tr>
    <td width="50">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>

</body>
</html>
