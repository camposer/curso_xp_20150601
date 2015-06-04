<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestionar Historia de Usuario</title>

    <link rel="stylesheet" href="/rodolfoxp/css/bootstrap.css" />
    <script type="text/javascript" src="/rodolfoxp/js/jquery.min.js"></script>
    <script type="text/javascript" src="/rodolfoxp/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    	function eliminar() {
    		document.getElementById("formListar").action = "eliminar.xp";
    		document.getElementById("formListar").submit();
    	}
    
    </script>
    
</head>
<body>
	<div class="container">
		<div class="row">
			<form method="post" id="formListar" name="formListar">
				<div class="col-md-6 col-md-offset-3">
					<h1>Gestionar Historia de Usuario</h1>
				</div>
				
				<div class="col-md-12">
					
					<c:if test="${not empty mensaje}">
						<div class="alert alert-info alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							${mensaje}
						</div>
					</c:if>
					
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>T&Iacute;TULO</th>
								<th>CATEGOR&Iacute;A</th>
								<th>DESCRIPCI&Oacute;N</th>
								<th>PRIORIDAD</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${gestionarHistoriaUsuario}" var="listado">
								<c:if test="${listado.prioridad < 33}">
									<c:set var="colorFuente" value="success" />
								</c:if>
								<c:if test="${listado.prioridad >= 33 && listado.prioridad < 66}">
									<c:set var="colorFuente" value="warning" />
								</c:if>
								<c:if test="${listado.prioridad >= 66}">
									<c:set var="colorFuente" value="danger" />
								</c:if>
									
								<tr class="<c:out value="${colorFuente}"/>">
									<td><input type="checkbox" name="cbHistoria" value="${listado.id}" /></td>
									<td>${listado.titulo}</td>
									<td>${listado.categoria}</td>
									<td>${listado.descripcion}</td>
									<td>${listado.prioridad}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div class="col-md-4">
					<button type="button" class="btn btn-primary">Configuraci&oacute;n Inicial</button>
				</div>
	  			<div class="col-md-4 col-md-offset-4">
	  				<button type="button" class="btn btn-primary">Gestionar Sprint</button>
	  			</div>
	  			
	  			<div class="col-md-12">&nbsp;</div>
	  			
	  			<div class="col-xs-2 col-md-4">
	  				<button type="button" class="btn btn-success">A&ntilde;adir</button>
	  				<button type="button" class="btn btn-warning">Editar</button>
	  				<button type="button" class="btn btn-danger" onclick="eliminar()">Eliminar</button>
	  			</div>
  			</form>
		</div>
	</div>
	
	<script src="/rodolfoxp/js/bootstrap.js"></script>
</body>
</html>