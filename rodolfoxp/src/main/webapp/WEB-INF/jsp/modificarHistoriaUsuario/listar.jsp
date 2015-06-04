<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
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

	<script type="text/javascript">
		function modificar() {
			alert('hola');
		}
	
	</script>	
</head>
<body>
	<div class="header">
		<h1>Modificar Historias de Usuario</h1>
	</div>
		
	<form id="form1" method="POST" action="/rodolfoxp/modificar-historia-usuario/aceptar.xp" >
	
		<div id="divCrearModificar">					 
			Id: <input type="text" name="id" value="${id}" readonly="readonly">			
			Titulo: <input type="text" name="titulo" value="${titulo}">
			Descripcion: <input type="text" name="descripcion" value="${descripcion}">				
		</div>
		<br/>
		 
		<button form="form1" type="submit">Aceptar</button>
	</form>
	
	<script src="/rodolfoxp/js/bootstrap.js"></script>
</body>
</html>