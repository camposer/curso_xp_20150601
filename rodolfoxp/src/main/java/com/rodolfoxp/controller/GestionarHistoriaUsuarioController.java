package com.rodolfoxp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfoxp.model.GestionarHistoriaUsuario;
import com.rodolfoxp.service.GestionarHistoriaUsuarioService;

@Controller
@RequestMapping("/gestionar-historia-usuario/*")
public class GestionarHistoriaUsuarioController {

	@Autowired
	private GestionarHistoriaUsuarioService gestionarHistoriaUsuarioService;
	
	@RequestMapping("listar")
	public String listar(Model model, HttpSession sesion) {
		
		List<GestionarHistoriaUsuario> gestionarHistoriaUsuario 
			= gestionarHistoriaUsuarioService.getGestionarHistoriaUsuario();
		
		String mensaje = (String) sesion.getAttribute("mensaje");
		if (mensaje != null) {
			model.addAttribute("mensaje", mensaje);
			sesion.removeAttribute("mensaje");
		}
		
		model.addAttribute("gestionarHistoriaUsuario", gestionarHistoriaUsuario);
		
		return "/WEB-INF/jsp/backlog/listar.jsp";
	}
	
	@RequestMapping(value = "eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam Long cbHistoria[], HttpSession sesion){
		
		for (int i = 0; i < cbHistoria.length; i++) {
			gestionarHistoriaUsuarioService.eliminar(cbHistoria[i]);
		}
		sesion.setAttribute("mensaje", "Registro eliminado correctamente");
		return "redirect:listar.xp";
	}
}
