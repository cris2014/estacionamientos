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
    <td>DISPONIBILIDAD DE UBICACIONES EN LOS ESTACIONAMIENTOS</td>
  </tr>
  <tr> 
    <td height="308"><br>
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" height="178">

        <tr> 
          <td height="170"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            
            <tr>
              <td >
              	<table width="50%" border="0" cellspacing="2" cellpadding="2">
                  <tr>
                    <td height="20" colspan="2" class="CeldaTitulo3">Estacionamiento 1</td>
                    </tr>
                  <tr>
                    <td width="31%" height="5"></td>
                    <td width="23%" height="5"></td>
                  </tr>
                  <tr>
                    <td class="TextoFijo">%Porcentaje Disponilidad</td>
                    <td class="TextoVariable" height="20"><div align="right">5%</div></td>
                  </tr>
                  <tr>
                    <td class="TextoFijo">Ubicaciones Disponibles</td>
                    <td class="TextoVariable"><div align="right">100</div></td>
                  </tr>
              </table>
             </td>
            </tr>

            <tr>
              <td >&nbsp;
             </td>
            </tr>

            <tr>
              <td >
              	<table width="50%" border="0" cellspacing="2" cellpadding="2">
                  <tr>
                    <td height="20" colspan="2" class="CeldaTitulo3">Estacionamiento 2</td>
                    </tr>
                  <tr>
                    <td width="31%" height="5"></td>
                    <td width="23%" height="5"></td>
                  </tr>
                  <tr>
                    <td class="TextoFijo">%Porcentaje Disponilidad</td>
                    <td class="TextoVariable" height="20"><div align="right">5%</div></td>
                  </tr>
                  <tr>
                    <td class="TextoFijo">Ubicaciones Disponibles</td>
                    <td class="TextoVariable"><div align="right">100</div></td>
                  </tr>
              </table>
             </td>
            </tr>


            
            <tr>
              <td height="32" width="371">&nbsp;</td>
            </tr>
          </table></td>
        </tr>
      </table>
      <p>
      <center>
          <a href="javascript:RetornaInicio()"><img src="btRegresa_0.gif" name="btnRegresar" border="0"></a> 
        </center>
 
      <p> 
    </td>
  </tr>
</table>

	

</body>
</html>
