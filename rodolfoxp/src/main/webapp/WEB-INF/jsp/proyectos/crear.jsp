<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Proyectos Scrum</title>

    <link rel="stylesheet" href="/rodolfoxp/css/bootstrap.css" />


	<script type="text/javascript" src="/rodolfoxp/js/jquery.min.js"></script>

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
		<h1>Crear Proyecto Scrum</h1>
	</div>
	
	<div class="container">
		
		<form id="formProyecto" action="insertarProyecto.xp" method="POST">
  			  <div class="form-group">  
			    <label for="nombreProyecto">Nombre Proyecto</label>
			    <input type="text" class="form-control" id="nombreProyecto" placeholder="Nombre proyecto..." name="nombreProyecto">
			  </div>
			  
			  <div class="form-group">  
			    <label for="descripcion">Descripción</label>
			    <input type="text" class="form-control" id="descripcion" placeholder="Descripción..." name="descripcion">
			  </div>
			  
			  <div>
			  <label for="duracion">Duración</label>
			  <br />
				<select class="chosen-select form-control" id="duracion" name="duracion">
					<option value="1">1 Semana</option> 
					<option value="2">2 Semana</option>
					<option value="3">3 Semana</option>
				</select>
			  </div>			  
			  <div class="form-group">
			    <label for="stakeHolders">StakeHolders</label>
			    <input type="text" class="form-control" id="stakeHolder" placeholder="StakeHolders..." name="stakeHolder">
			    <!--  <p class="help-block">Example block-level help text here.</p> -->
			  </div>
			  <!-- <div class="checkbox">
			    <label>
			      <input type="checkbox"> Check me out
			    </label>
			  </div> -->
			  <input type="hidden" id="usuariosAsignados" name="usuariosAsignados">
		</form>
		
		<table class="table">
			<th>Nombre</th><th>Estado</th><th>Fecha finalización</th>
					<%-- 
				<c:forEach items="${usuarios}" var="us">						
					<tr><td>${us.nombre}</td>
					<td>${us.estado}</td>
					<td>${us.duracion}</td></tr>					
			</c:forEach>--%>
	  	</table>
			  <button class="btn" data-toggle="modal" data-target="#myModal" >Asignar</button>
			  <button class="btn">Eliminar</button>
		<br/><br/><br/>
		
		<br/>		
		<br/>
		<button type="submit" class="btn btn-default" id="crearProyecto">Crear</button>
		<button class="btn btn-default">Cancelar</button>
	</div>
	
	<!-- Modal Asignar -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Asignar usuario</h4>
	      </div>
	      <div class="modal-body">
	        <form>
	        <div class="form-group">
		       	<label for="nombreUsuario">Nombre</label>
		        <input type="text" name="nombreUsuario" id="nombreUsuario"/><br/>
		    </div>
		    <div class="form-group">
		        <label for="rolUsuario">Rol</label>
		        <input type="text" name="rolUsuario" id="rolUsuario"/><br/>
		    </div>
		    <div class="form-group">
		        <label for="fechaFin">Fecha fin</label>
		        <input type="text" name="fechaFin" id="fechaFin"/>
		    </div>
		    </form>	        
	      </div>	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary"  id="asignarUsuarioModal" data-dismiss="modal">Asignar</button>
	      </div>	      
	    </div>
	  </div>
</div>
	<script src="/rodolfoxp/js/bootstrap.js"></script>	
	<script>
		$("#asignarUsuarioModal").click(function() {
			$(".table").append(
				"<tr><td>" + $("#nombreUsuario").val() + "</td>" +
				"<td>" + $("#rolUsuario").val() + "</td>" + 
				"<td>" + $("#fechaFin").val() + "</td>"	
			);
		});
		
		$("#crearProyecto").click(function() {
			var arrayUsuarios = new Array();
			$.each($(".table tr"), function( index,value) {				  
			   if(index > 0) {
				   var usuarioAsignado = new Object();
				   var columnas = $(value).find("td");				   
				   usuarioAsignado['nombreUsuario'] = columnas[0].innerHTML;
				   usuarioAsignado['rolUsuario'] = columnas[1].innerHTML;
				   usuarioAsignado['fechaFin'] = columnas[2].innerHTML;
				   arrayUsuarios.push(usuarioAsignado);
			   }
			});			
			
			$("#usuariosAsignados").val(JSON.stringify(arrayUsuarios));
			
			$("#formProyecto").submit();
		});
	</script>
</body>
</html>