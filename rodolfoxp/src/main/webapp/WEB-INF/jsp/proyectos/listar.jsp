<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Proyectos Scrum</title>

    <link rel="stylesheet" href="/rodolfoxp/css/bootstrap.css" />

	<style>
		.proyecto {
			width: 80%;
			margin-left: auto;
			margin-right: auto;
		}
		
		.proyecto .nombre {
			background-color: gray;
			text-align: center;
		}

		.proyecto .descripcion {
			text-align: center;
		}
	</style>
</head>
<body>
	<div class="header">
		<h1>Proyectos</h1>
	</div>
	
	<div class="container">
		<ul class="list-group">
		<c:forEach items="${proyectos}" var="pr">
			<li class="list-group-item">
				<h3>${pr.nombre}</h3>
				<div>${pr.descripcion}</div>
				<div>${pr.duracion}</div>
			</li>
		</c:forEach>
		</ul>
	</div>
	<form action="crear.xp">
		<button type="submit" class="btn btn-default" id="crearProyecto">Crear Proyecto</button>
	</form>
	
	<script src="/rodolfoxp/js/bootstrap.js"></script>
</body>
</html>