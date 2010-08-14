<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.estacionamiento.bean.ColorBean" %>
<%@ page import="com.estacionamiento.bean.MarcaBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema Estacionamiento</title>
<link href="styles/global.css" rel="stylesheet" type="text/css" />
<%
String codColor=(request.getAttribute("codColor")!=null)?(String)request.getAttribute("codColor"):"1";
String codMarca=(request.getAttribute("codMarca")!=null)?(String)request.getAttribute("codMarca"):"1";

%>

<script type="text/javascript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
function grabar(){    
    var f= document.forms[0];
    f.operacion.value="registrarVehiculo";
    f.submit();        
}
function retornar(){
    var f= document.forms[0];
    f.operacion.value="retornarMenu";
    f.submit();
}
function cargaCod(){
    var f= document.forms[0];
    f.marca.value='<%=codMarca%>';
    f.color.value='<%=codColor%>';

}
</script>
</head>
<!--
<body class="oneColElsCtrHdr" onload="MM_preloadImages('img/registro_vehiculos_2.png')">
-->
<body class="oneColElsCtrHdr" onload="cargaCod()">

<div id="container">
  <div id="header">
    <!-- end #header --></div>
  <div id="reg_vehi">

<html:form action="/registroReporteAction" >  

<html:hidden property="operacion" />
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
    <td><bean:write name="usuario" property="codigo" /></td>
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
    <td><bean:write name="usuario" property="nombre" /></td>
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
    <td><bean:write name="usuario" property="apellido" /></td>
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
    <td><bean:write name="usuario" property="tipousuario" /></td>
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
    <td colspan="2">
      <label>
          <html:text property="placa" styleClass="borde" maxlength="12"/>
         <!--<input name="placa" type="text" class="borde" id="placa" />-->



      </label>
    </td>
  </tr>  
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Marca</td>
    <td colspan="2">
      <label>

        <select  name="marca" class="borde" id="marca">

          <%
          ArrayList lstMarca=(ArrayList)request.getSession().getAttribute("lstMarca");
          MarcaBean marca;
          String cod="";
          String nombre="";
          for(int j=0;j<lstMarca.size();j++){
                 marca=(MarcaBean)lstMarca.get(j);
                 cod=marca.getCodigo();
                 nombre=marca.getNombre();
          %>
               <option value="<%=cod%>"><%=nombre%></option>
          <%
          }
          %>
          <!--
          <option value="1">Toyota</option>
          <option value="2">Nissan</option>
          <option value="3">Kia</option>
          <option value="4">Hyundai</option>
          -->
        </select>
      </label>
    </td>
  </tr>
    <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Modelo</td>
    <td colspan="2">
      <label>
          <html:text property="modelo" styleClass="borde" />
       
      </label>
   </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>Color</td>
    <td colspan="2">
      <label>
        <select name="color" class="borde" id="color">
          <%
          ArrayList lstColor=(ArrayList)request.getSession().getAttribute("lstColor");
          ColorBean color;
          String cod1="";
          String nombre1="";
          for(int j=0;j<lstColor.size();j++){
                 color=(ColorBean)lstColor.get(j);
                 cod1=color.getCodigo();
                 nombre1=color.getNombre();
          %>
               <option value="<%=cod1%>"><%=nombre1%></option>
          <%
          }
          %>

         <!--
          <option value="1">Azul</option>
          <option value="2">Blanco</option>
          <option value="3">Plateado</option>
          -->
        </select>
      </label>
      <!--
       <label>
          <html:text property="color" styleClass="borde" />
      </label>
      -->
   </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <!--
  <tr>
    <td>&nbsp;</td>
    <td>Teléfono</td>
    <td colspan="2">
      <label>
          <html:text property="telefono" styleClass="borde" />
      </label>
    </td>
  </tr>
  -->

  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>

      <td colspan="4" align="center">
        <a href="javascript:retornar()">
	      <img src="img/retornaroff.gif"  border="0" align="center" >
	</a>
        <a href="javascript:grabar()">
	      <img src="img/grabaroff.gif"  border="0" align="center" >
	</a>
       <!--
      <label>
        <input type="submit" name="registrar" id="registrar" value="REGISTRAR" />
      </label>
      <label>
        <input type="submit" name="cancelar" id="cancelar" value="CANCELAR" />
      </label>
      -->
    </td>
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
</html:form>


   
<!-- end #registro_vehi --></div></div>
</body>
</html>
