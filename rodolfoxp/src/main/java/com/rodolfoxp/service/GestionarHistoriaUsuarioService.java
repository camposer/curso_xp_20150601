package com.rodolfoxp.service;

import java.util.List;

import com.rodolfoxp.model.GestionarHistoriaUsuario;
import com.rodolfoxp.model.HistoriaUsuario;

public interface GestionarHistoriaUsuarioService {

  List<GestionarHistoriaUsuario> getGestionarHistoriaUsuario();

  HistoriaUsuario saveHistoriaUsuario(HistoriaUsuario historiaUsuario);
	
	void eliminar(Long huId);
}
