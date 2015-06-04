package com.rodolfoxp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoxp.model.GestionarHistoriaUsuario;
import com.rodolfoxp.model.HistoriaUsuario;
import com.rodolfoxp.repository.GestionarHistoriaUsuarioRepository;
import com.rodolfoxp.repository.HistoriaUsuarioRepository;

@Service
public class GestionarHistoriaUsuarioServiceImpl implements
        GestionarHistoriaUsuarioService {

  @Autowired
  private GestionarHistoriaUsuarioRepository gestionarHistoriaUsuarioRepository;

  @Autowired
  private HistoriaUsuarioRepository historiaUsuarioRepository;

  @Override
  public List<GestionarHistoriaUsuario> getGestionarHistoriaUsuario() {
    return gestionarHistoriaUsuarioRepository.findAll();
  }

  @Override
  public HistoriaUsuario saveHistoriaUsuario(HistoriaUsuario historiaUsuario) {
    return historiaUsuarioRepository.save(historiaUsuario);
  }
	
	@Override
	public void eliminar(Long huId) {
		gestionarHistoriaUsuarioRepository.delete(huId);
	}
}
