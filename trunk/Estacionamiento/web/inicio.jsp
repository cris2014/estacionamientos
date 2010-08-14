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
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function onContinuar(codigo) {
    document.forms[0].action = "interface.do?operacion="+codigo;
	document.forms[0].submit();
}

//-->
</script>
</head>

<body class="oneColElsCtrHdr" onload="MM_preloadImages('img/ingreso_salida_2.png','../../img/mantenimiento_consulta_2.png','../../img/disponibilidad_2.png')">

<div id="container">
  <div id="header">
    <!-- end #header --></div>
  <div id="default">
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

  <div id="bot_default3">
  <!-- end #bot_default3 -->

<html:form action="/interface" >

  <table>
    <tr>
      <td><a href="javascript:onContinuar('3')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Imagen4','','img/disponibilidad_2.png',1)"><img src="img/disponibilidad_1.png" name="Imagen4" width="146" height="139" border="0" id="Imagen4" /></a></td>
    </tr>
  </table>
  </div>
  
  <div id="bot_default2">
  <table>
  <tr>
    <td><a href="javascript:onContinuar('2')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Imagen3','','img/mantenimiento_consulta_2.png',1)"><img src="img/mantenimiento_consulta_1.png" name="Imagen3" width="146" height="139" border="0" id="Imagen3" /></a></td>
  </tr>
</table>

  <!-- end #bot_default2 --></div>
  
  <div id="bot_default1"><table>
  <tr>
    <td><a href="javascript:onContinuar('1')" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Imagen2','','img/ingreso_salida_2.png',1)"><img src="img/ingreso_salida_1.png" name="Imagen2" width="146" height="139" border="0" id="Imagen2" /></a></td>
  </tr>
</table>

</html:form>

  <!-- end #bot_default1 --></div>
   
    <!-- end #default --></div>

<!-- end #container --></div>
</body>
</html>
