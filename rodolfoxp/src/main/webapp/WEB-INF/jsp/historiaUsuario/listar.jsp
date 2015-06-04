<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Historias de Usuario</title>

    <link rel="stylesheet" href="/rodolfoxp/css/bootstrap.css" />

	<style>
		.historia-usuario {
			width: 80%;
			margin-left: auto;
			margin-right: auto;
		}
		
		.historia-usuario .titulo {
			background-color: gray;
			text-align: center;
		}

		.historia-usuario .descripcion {
			text-align: center;
		}
	</style>
</head>
<script type="text/javascript">

	function modificar(id, titulo, descripcion){


		document.formModificar.elements["id"].value = id;
		document.formModificar.elements["titulo"].value = titulo;
		document.formModificar.elements["descripcion"].value = descripcion;

		document.formModificar.submit();
				
	}
</script>
<body>
	<div class="header">
		<h1>Historias de Usuario</h1>
	</div>
	<form name="formModificar" method="POST" action="/rodolfoxp/modificar-historia-usuario/modificar.xp" >
		<input type="hidden" name="titulo" value="${hu.titulo}"/>
		<input type="hidden" name="descripcion" value="${hu.descripcion}"/>
		<input type="hidden" name="id" value="${hu.id}"/>
	
		<div class="container">
			<ul class="list-group">
			<c:forEach items="${historiasUsuario}" var="hu"  varStatus="loop">
				<li class="list-group-item">
					<h3>${hu.titulo}</h3>
					<div>${hu.descripcion}</div>				
					
					<input type="button" value="Modificar" name="boton${loop.index}" onclick="modificar(${hu.id},'${hu.titulo}','${hu.descripcion}')">
					
				</li>
			</c:forEach>
			</ul>
		</div>
				
	</form>
	<form method="post" action="/rodolfoxp/gestionar-historia-usuario/listar.xp">
		<input type="submit" value="Gestionar Historias"/>
	</form>
	
	
	<script src="/rodolfoxp/js/bootstrap.js"></script>
</body>
</html>