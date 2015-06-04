package com.rodolfoxp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodolfoxp.model.HistoriaUsuario;
import com.rodolfoxp.service.HistoriaUsuarioService;

@Controller
@RequestMapping("/historia-usuario/*")
public class HistoriaUsuarioController {
  @Autowired
  private HistoriaUsuarioService historiaUsuarioService;

  @RequestMapping("listar")
  public String listar(Model model) {
    List<HistoriaUsuario> historiasUsuario = historiaUsuarioService
            .getHistoriasUsuario();

    model.addAttribute("historiasUsuario", historiasUsuario);

    return "/WEB-INF/jsp/historiaUsuario/listar.jsp";
  }

  @RequestMapping("crear")
  public String crear(HistoriaUsuario hu) {

    return "/WEB-INF/jsp/historiaUsuario/addHistoriaUsario.jsp";
  }
}
