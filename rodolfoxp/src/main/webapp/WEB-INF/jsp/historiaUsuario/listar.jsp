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
<body>
	<div class="header">
		<h1>Historias de Usuario</h1>
	</div>
	
	<div class="container">
		<ul class="list-group">
		<c:forEach items="${historiasUsuario}" var="hu">
			<li class="list-group-item">
				<h3>${hu.titulo}</h3>
				<div>${hu.descripcion}</div>
			</li>
		</c:forEach>
		</ul>
	</div>
	
	<script src="/rodolfoxp/js/bootstrap.js"></script>
</body>
</html>