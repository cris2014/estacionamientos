<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema Estacionamiento</title>
<link href="styles/global.css" rel="stylesheet" type="text/css" />
<% String estVal=""+request.getAttribute("codEsta");%>
<script type="text/javascript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
function cambiarEstac(){
    var f= document.forms[0];
    f.operacion.value="cambiarEstacionamiento";
    f.submit();

}
function setEstacionamiento(){
    var f= document.forms[0];
    f.estacionamiento.value='<%=estVal%>';
  
}
function retornar(){
    var f= document.forms[0];
    f.operacion.value="retornarMenu";
    f.submit();
}
</script>
</head>
<!--
<body class="oneColElsCtrHdr" onload="MM_preloadImages('img/registro_vehiculos_2.png')">
-->
<body class="oneColElsCtrHdr" onload="setEstacionamiento()">

<div id="container">
  <div id="header">
    <!-- end #header --></div>
  <div id="ing_sal">
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

<html:form action="/registroReporteAction" >

<html:hidden property="operacion" />

    <table width="924" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="6"><img src="img/tit_reporte.jpg" width="924" height="31" /></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        <td width="404" colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>

      <label>
          <select name="estacionamiento" class="borde" id="estacionamiento" onchange="javascript:cambiarEstac();">
          <option value="1">Estacionamiento1</option>
          <option value="2">Estacionamiento2</option>
        </select>
      </label>
        </td>
        <td colspan="4">&nbsp;</td>
      </tr>
      <tr>
        <td width="84">&nbsp;</td>
        <td colspan="5">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="436">&nbsp;</td>
        <td colspan="4">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="6">
            <table width="640" align="center">
          <tr class="titulo1">
            <td width="200" align="center">UBICACIÓN</td>
            <td width="200" align="center">USUARIO</td>
            <td width="200" align="center">PLACA</td>
            <td width="100" align="center">DISPONIBILIDAD</td>
          </tr>
<logic:notEmpty name="lstEstacionamiento">
<nested:iterate property="lstEstacionamiento">
    <tr>
        <td bgcolor="#666666"><nested:write property="ubicacion"/></td>
        <td bgcolor="#666666"><nested:write property="usuario"/></td>
        <td bgcolor="#666666"><nested:write property="placa"/></td>
        <td bgcolor="#666666"><nested:write property="estado"/></td>
    </tr>
</nested:iterate>
</logic:notEmpty>

<!--
          <tr>
            <td bgcolor="#666666">esquina</td>
            <td bgcolor="#666666">Carlos Urrutia</td>
            <td bgcolor="#666666">krl2536</td>
            <td bgcolor="#666666">ocupado</td>
          </tr>
          <tr>
            <td bgcolor="#666666">&nbsp;</td>
            <td bgcolor="#666666">&nbsp;</td>
            <td bgcolor="#666666">&nbsp;</td>
            <td bgcolor="#666666">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#666666">&nbsp;</td>
            <td bgcolor="#666666">&nbsp;</td>
            <td bgcolor="#666666">&nbsp;</td>
            <td bgcolor="#666666">&nbsp;</td>
          </tr>
  -->
        </table></td>
      </tr>
      <tr>
        <td colspan="4">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="4"><table align="center">
          <tr>
            <td></td>
          </tr>
        </table></td>
      </tr>

  <tr>
      <td colspan="4" align="center">
        <a href="javascript:retornar()">
	      <img src="img/retornaroff.gif"  border="0" align="center" >
	</a>
      </td>
  </tr>

    </table>
    <!-- end #ing_sal -->
  </div>
</html:form>
    
<!-- end #container --></div>
<p>&nbsp;</p>
</body>
</html>
