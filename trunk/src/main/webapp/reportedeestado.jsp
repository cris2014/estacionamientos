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
<table width="780" border="0" align="center" cellpadding="2" cellspacing="0">
  <tr> 
    <td height="20">&nbsp;</td>
  </tr>
  <tr class="CeldaTitulo2"> 
    <td >REPORTE DE ESTADO</td>
  </tr>
  <tr> 
    <td height="383" valign="top" >
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td> 
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="283" height="15" >&nbsp;</td>
                <td height="15"> </td>
                <td width="5" height="15"></td>
              </tr>            
              <tr> 
                <td width="283" class="TextoFijo">Nombre Estacionamiento</td>
                <td > 
                  <select name="cboNomEst">
                    <option value="1" selected>Los Alamos</option>
                    <option value="2">Campus</option>
                  </select>                </td>
                <td width="5"></td>
              </tr>
              <tr> 
                <td width="283">&nbsp;</td>
                <td width="579">&nbsp; </td>
                <td width="5">&nbsp;</td>
              </tr>
              <tr> 
                <td width="283"></td>
              </tr>
			  </TABLE>
			  
            <div align="center">
            <TABLE width="80%">
              <tr> 
                <td width="116" class="CeldaTitulo3"><div align="center">UBICACION</div></td>
                <td width="219" class="CeldaTitulo3"><div align="center">USUARIO</div></td>
                <td width="300" class="CeldaTitulo3"><div align="center">PLACA</div></td>
                <td width="212" class="CeldaTitulo3">DISPONIBILIDAD</td>
              </tr>
              <tr> 
                <td width="116">&nbsp;</td>
                <td width="219">&nbsp; </td>
                <td width="300"></td>
                <td width="212"></td>
              </tr>
                <tr><td width="116">&nbsp;</td>
                <td width="219">&nbsp; </td>
                <td width="300"></td>
                <td width="212"></td>
              <tr> 
                <td width="116">.</td>
                <td width="219"></td>
                <td width="300"></td>
                <td width="212"></td>
              </tr>
            </table>
           </div></td>
        </tr>
      </table>
      <p>
      <center>
          <a href="menucenter.html"><img src="btRegresa_0.gif" name="btnRegresar" border="0"></a> 
        </center>
 
      <p>
    </td>
  </tr>
</table>

	

</body>
</html>
