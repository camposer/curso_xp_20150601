package com.rodolfoxp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rodolfoxp.model.HistoriaUsuario;
import com.rodolfoxp.service.HistoriaUsuarioService;

@Controller
@RequestMapping("/modificar-historia-usuario/*")
public class ModificarHistoriaUsuarioController {
  @Autowired
  private HistoriaUsuarioService historiaUsuarioService;
   
  @RequestMapping("modificar")
  public String modificar(Model model, @RequestParam("id") Long id, @RequestParam("titulo") String titulo, @RequestParam("descripcion") String descripcion)
  {
	  /*
	  HistoriaUsuario historiaUsuario = new HistoriaUsuario();
	  historiaUsuario.setId(id);
	  historiaUsuario.setTitulo(titulo);
	  historiaUsuario.setDescripcion(descripcion);
	  
	  historiaUsuarioService.updateHistoria(historiaUsuario);
	  */
	  
	  model.addAttribute("id", id);
	  model.addAttribute("titulo", titulo);
	  model.addAttribute("descripcion", descripcion);
	  
	  return "/WEB-INF/jsp/modificarHistoriaUsuario/listar.jsp";
  } 
  
  @RequestMapping("aceptar")  
  public String aceptar(Model model, @RequestParam("id") Long id, @RequestParam("titulo") String titulo, @RequestParam("descripcion") String descripcion)
  {
	  
	  HistoriaUsuario historiaUsuario = new HistoriaUsuario();
	  historiaUsuario.setId(id);
	  historiaUsuario.setTitulo(titulo);
	  historiaUsuario.setDescripcion(descripcion);
	  
	  historiaUsuarioService.updateHistoria(historiaUsuario);
	  
	  
	  List<HistoriaUsuario> historiasUsuario = historiaUsuarioService
	            .getHistoriasUsuario();

	    model.addAttribute("historiasUsuario", historiasUsuario);
	  	  	  	  
	  return "/WEB-INF/jsp/historiaUsuario/listar.jsp";
  }
}
