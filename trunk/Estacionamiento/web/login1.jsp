<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

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
       <!--	Mensajes de error -->
	<logic:messagesPresent>
		<table width="500" border="0" align="center">
			<tr>
  				<td  height="15" style="font-weight:bold;" >
					<bean:message key="errors.validation.header" />
					<html:messages id="error">
						<c:out value="${error}" />
					</html:messages>
					<bean:message key="errors.validation.footer" />
				</td>
			</tr>
		</table>
	</logic:messagesPresent>
<!--	Mensajes de error -->
  <div id="login">
  <div id="campo_login">
  <!-- end #campo_login -->
  <html:form action="/ingresoSalidaAction" >

  <table width="500" border="0">
    <tr>
      <td width="43">&nbsp;</td>
      <td width="30">&nbsp;</td>
      <td width="248">&nbsp;</td>
      <td width="114">&nbsp;</td>
      <td width="43">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="3" align="left">
            &nbsp;&nbsp;
      <label>
          <select name="estacionamiento" class="borde" id="estacionamiento" onchange="javascript:cambiarEstac();">
          <option value="1">Estacionamiento1</option>
          <option value="2">Estacionamiento2</option>
        </select>
      </label>
        </td>
        <td >&nbsp;</td>
      </tr>

      <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td align="left"><img src="img/login_a.png" width="69" height="17" /></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      </tr>
    <tr>
      <td height="47">&nbsp;</td>
      <td>&nbsp;</td>
      <td align="left" valign="top">


        <label for="login1"></label>
        <input name="user" type="text" class="borde" id="user" size="30" />
        <input name="operacion" type="hidden" value="ingresoSalida" id="operacion" />
 		</td>
      <td align="left" valign="top">
        <input type="submit" name="enviar" id="enviar" value="ENVIAR" />
      </td>
      <td>&nbsp;</td>
      </tr>
    <tr>
      <td height="20">&nbsp;</td>
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
      <td>&nbsp;</td>
    </tr>
    </table>
 	  </html:form>
  </div>
  
  
  
  
   
  <!-- end #login --></div>

<!-- end #container --></div>
</body>
</html>
