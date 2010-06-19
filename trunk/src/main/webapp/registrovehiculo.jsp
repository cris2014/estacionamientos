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
<table width="780" border="0" align="center" cellpadding="0" cellspacing="2">
  <tr > 
    <td >&nbsp;</td>
  </tr>
  <tr class="CeldaTitulo2"> 
    <td >REGISTRO DE VEHICULO</td>
  </tr>
  <tr> 
    <td valign="top" >
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <th align="left" scope="col">&nbsp;</th>
        </tr>
        <tr> 
          <td> 
          <form id="form1" name="form1" method="post" action="">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr class="CeldaTitulo3" > 
                <td width="26%">DATOS DEL USUARIO</td>
                <td width="71%"></td>
                <td width="3%"></td>
              </tr>
              <tr> 
                <td height="10"></td>
                <td height="10"></td>
                <td></td>
              </tr>
              <tr> 
                <td class="TextoFijo"><div align="left">Código</div></td>
                <td height="20" class="TextoFijo"><div align="left">U913833</div></td>
                <td height="30"></td>
              </tr>
              <tr> 
                <td class="TextoFijo"><div align="left">Nombres</div></td>
                <td height="20" class="TextoFijo"><div align="left">IVAN</div></td>
                <td height="30"></td>
              </tr>
              <tr> 
                <td class="TextoFijo"><div align="left">Apellidos</div></td>
                <td height="20" class="TextoFijo"><div align="left">LUNA VIGO</div></td>
                <td height="30"></td>
              </tr>
              <tr> 
                <td class="TextoFijo"><div align="left">Tipo de Persona:</div></td>
                <td height="20" class="TextoFijo"><div align="left">ALUMNO</div></td>
                <td height="30">&nbsp;</td>
              </tr>

              <tr class="CeldaTitulo3"> 
                <td>DATOS DEL VEHICULO</td>
                <td></td>
                <td></td>
              </tr>
              <tr> 
                <td height="10"></td>
                <td height="10"></td>
                <td></td>
              </tr>
              <tr> 
                <td class="TextoFijo"><div align="left">N&uacute;mero de Placa del Vehículo</div></td>
                <td height="30"> 
                  <input name="txtPlaca" type="text" id="txtPlaca" size="20" maxlength="20" />                </td>
                <td></td>
              </tr>
              <td class="TextoFijo"><div align="left">Marca</div></td>
              <td height="30">
                <label>
                  <select name="cmbMarca" id="cmbMarca">
                  </select>
                  </label>              </td>
              <td></td>
              <tr> 
                <td height="20" class="TextoFijo"><div align="left">Modelo</div></td>
                <td height="30"><input name="txtModelo" type="text" id="txtModelo" size="20" maxlength="20" /></td>
                <td></td>
              </tr>
              <tr>
                <td height="20" class="TextoFijo"><div align="left">Color</div></td>
                <td height="30"><input name="txtColor" type="text" id="txtColor" size="20" maxlength="20" /></td>
                <td></td>
              </tr>
              <tr>
                <td height="20" class="TextoFijo">Telefono</td>
                <td height="30"><input name="txtTelefono" type="text" id="txtTelefono" size="20" maxlength="20" /></td>
                <td></td>
              </tr>
              <tr>
                <td height="20" class="TextoFijo">&nbsp;</td>
                <td height="30">&nbsp;</td>
                <td></td>
              </tr>
              <tr>
                <td height="30" colspan="3" class="TextoFijo"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                    <td><div align="center"><img src="btRegistrar_0.gif" width="100" height="30" /></div></td>
                    <td><div align="center"><img src="btCancelar_0.gif" width="100" height="30" /></div></td>
                    <td>&nbsp;</td>
                  </tr>
                </table></td>
                </tr>
            </table>
           </form>
          </td>
        </tr>
      </table>
      <p>
      <center>
      </center>
 
      
      </td>
  </tr>
</table>

	

</body>
</html>
