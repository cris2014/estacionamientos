<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

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
</script>
</head>

<body class="oneColElsCtrHdr" onload="MM_preloadImages('img/registro_vehiculos_2.png')">

<div id="container">
  <div id="header">
    <!-- end #header --></div>
  <div id="reg_vehi">
  
<table width="900" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="4"><img src="img/tit_registro.jpg" width="924" height="31" /></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td width="230">&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="52">&nbsp;</td>
    <td colspan="2" align="left" class="titulo1">DATOS DE USUARIO</td>
    <td width="195">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td width="447">&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Código</td>
    <td>U913833</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Nombres</td>
    <td>IVÁN</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Apellidos</td>
    <td>LUNA VIGO</td>
    <td>&nbsp;</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Tipo de Persona</td>
    <td>Alumno</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="2" class="titulo1">DATOS DEL VEHÍCULO</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>N° de Placa de Vehículo</td>
    <td colspan="2"><form id="form1" name="form1" method="post" action="">
      <label>
        <input name="placa" type="text" class="borde" id="placa" />
      </label>
    </form></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Marca</td>
    <td colspan="2"><form id="form5" name="form5" method="post" action="">
      <label>
        <select name="marca" class="borde" id="marca">
          <option value="1">Toyota</option>
          <option value="2">Nissan</option>
          <option value="3">Kia</option>
          <option value="4">Hyundai</option>
        </select>
      </label>
    </form></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Modelo</td>
    <td colspan="2"><form id="form2" name="form2" method="post" action="">
      <label>
        <input name="modelo" type="text" class="borde" id="modelo" />
      </label>
    </form></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Color</td>
    <td colspan="2"><form id="form3" name="form3" method="post" action="">
      <label>
        <input name="color" type="text" class="borde" id="color" />
      </label>
    </form></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Teléfono</td>
    <td colspan="2"><form id="form4" name="form4" method="post" action="">
      <label>
        <input name="telefono" type="text" class="borde" id="telefono" />
      </label>
    </form></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"><form id="form6" name="form6" method="post" action="">
      <label>
        <input type="submit" name="registrar" id="registrar" value="REGISTRAR" />
      </label>
      <label>
        <input type="submit" name="cancelar" id="cancelar" value="CANCELAR" />
      </label>
    </form></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>

   
<!-- end #registro_vehi --></div></div>
</body>
</html>
