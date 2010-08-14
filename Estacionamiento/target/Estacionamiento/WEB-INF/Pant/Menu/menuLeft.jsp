<html xmlns="http://www.w3.org/1999/xhtml"><body bgcolor="#F4FFE4">﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="file:///E|/Web/mm_health_nutr.css" type="text/css" />
<script language="JavaScript" type="text/javascript">
//--------------- LOCALIZEABLE GLOBALS ---------------
var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//Ensure correct for language. English is "January 1, 2004"
var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
//---------------   END LOCALIZEABLE   ---------------
</script>







<script language="javascript">

function MuestraAcceso()
	{
	parent.Derecha.location.href = "ingreso.html";
	}	


function MuestraSalida()
	{
	parent.Derecha.location.href = "salida.html";
	}	


function MuestraMantenimiento()
	{
	parent.Derecha.location.href = "UsuarioNuevo.html";
	}	

function MuestraAcceso02()
	{
	//parent.Derecha.location.href = "paginas/HomologacionGeneral.asp?i="+id+"&c="+Clave;
		url = "paginas/HomologacionGeneral.asp?i=<%=id%>&c=<%=Clave%>";
		window.open(url, "", "directories=no,location=no,menubar=no,resizable,status=no,toolbar=no,history=yes,scrollbars");
	}	


</script>








</head>

<table width="44%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="3" bgcolor="#99CC66" background="file:///E|/Web/mm_dashed_line.gif"><img src="file:///E|/Web/mm_dashed_line.gif" alt="line decor" width="4" height="3" border="0" /></td>
  </tr>

  <tr>
    <td colspan="3" bgcolor="#5C743D"><img src="file:///E|/Web/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
  </tr>

 <tr>
    <td width="482" valign="top" bgcolor="#5C743D">
	<table border="0" cellspacing="0" cellpadding="0" width="165" id="navigation">
        <tr>
          <td width="165">&nbsp;<br />
		 &nbsp;<br /></td>
        </tr>
        <tr>
          <td width="165"><a href="javascript:MuestraAcceso()">Ingreso</a> </td>
        </tr>
        <tr>
          <td width="165"><a href="javascript:MuestraSalida()">Salida</a></td>
        </tr>
        <tr>
          <td width="165"><a href="javascript:;" class="navText">Disponibilidad</a></td>
        </tr>
        <tr>
          <td width="165"><a href="javascript:MuestraMantenimiento()">Mantenimiento</a></td>
        </tr>
        <tr>
          <td width="165"><a href="javascript:;" class="navText">yyyyyyyyyyyy</a></td>
        </tr>
      </table>
 	 <br />
  	&nbsp;<br />
  	&nbsp;<br />
  	&nbsp;<br /> 	</td>
    <td width="50"><img src="file:///E|/Web/mm_spacer.gif" alt="" width="50" height="1" border="0" /></td>
    <td width="702"><img src="file:///E|/Web/mm_spacer.gif" alt="" width="50" height="1" border="0" /></td>
  </tr>
  <tr>
    <td width="482">&nbsp;</td>
    <td width="50">&nbsp;</td>
    <td width="702">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>

</body>
</html>
