<%-- 
    Document   : REPORTE
    Created on : 23/05/2010, 02:08:01 PM
	Author     : JVillar
--%>

<script language="javascript">
function RetornaInicio()
	{
	location.href = "menucenter.html";
	}	

</script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Estacionamiento</title>
   	</head>
	<body  >
		<center>
			<form action="<%=request.getContextPath()%>/index.jsp" method="POST">
	                <img src="file:///E|/Web/logo_2.jpg" >
                
				<h1>Por favor dirigirse al  </h1>
				<table>
					<tr>
						<td>
							<h1>1er Piso</h1>
						</td>
					</tr>
					<tr>
						<td>
							<h1>Ubicacion 17</h1>
						</td>
					</tr>
				</table>
                
			    <a href="javascript:RetornaInicio()"><img src="file:///E|/Web/Aceptar.gif" width="95" height="26"></a>
		      <tr></tr>
 			</form>
		</center>
	</body>
</html>