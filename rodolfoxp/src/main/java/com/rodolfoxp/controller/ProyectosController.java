package com.rodolfoxp.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfoxp.model.Proyecto;
import com.rodolfoxp.model.Usuario;
import com.rodolfoxp.service.ProyectosService;
import com.rodolfoxp.service.UsuariosService;

@Controller
@RequestMapping("/proyectos/*")
public class ProyectosController {
	
	@Autowired
	private ProyectosService proyectoService;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@RequestMapping("listar")
	public String listar(Model model) {
		List<Proyecto> proyectos = 
				proyectoService.listar();
		
		model.addAttribute("proyectos", proyectos);
		
		return "/WEB-INF/jsp/proyectos/listar.jsp";
	}
	
	@RequestMapping("crear")
	public String crear() {
		
		return "/WEB-INF/jsp/proyectos/crear.jsp";
	}
	
	@RequestMapping(value = "insertarProyecto", method = RequestMethod.POST)	
	public String insertarProyecto(@RequestParam("nombreProyecto") String nombreProyecto,@RequestParam("duracion") Integer duracion,@RequestParam("descripcion") String descripcion, @RequestParam("stakeHolder") String stakeHolder, @RequestParam("usuariosAsignados") String usuariosAsignados,HttpServletRequest request, Model model) {
		
		Proyecto proy = new Proyecto();
		
		proy.setDuracion(duracion);		
		proy.setDescripcion(descripcion);
		proy.setNombre(nombreProyecto);
		
		Set<Usuario> usuarios = new HashSet<Usuario>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			ArrayNode arrayNode = (ArrayNode) mapper.readTree(usuariosAsignados);
			for(JsonNode node : arrayNode){
				Usuario us = new Usuario();
				us.setNombre(node.get("nombreUsuario").getTextValue());
				us.setApellido("Doe");
				us.setTipoUsuario(node.get("rolUsuario").getTextValue());
				us.setEstado("Asignado");		
				//node.get("fechaFin") //Falta añadir la fecha //incorporar al modelo
				this.usuariosService.crear(us);
				usuarios.add(us);
			}
			
		} catch (JsonProcessingException e) {
			System.out.println("Excepcion");
		} catch (IOException e) {
			System.out.println("Excepcion");
		}		
		
		proy.setUsuarios(usuarios);
		
		this.proyectoService.crear(proy);
					
		
		return this.listar(model);
	}
}
