package com.rodolfoxp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoxp.model.HistoriaUsuario;
import com.rodolfoxp.repository.HistoriaUsuarioRepository;

@Service
public class HistoriaUsuarioServiceImpl implements HistoriaUsuarioService {
	@Autowired
	private HistoriaUsuarioRepository historiaUsuarioRepository;

	@Override
	public List<HistoriaUsuario> getHistoriasUsuario() {
		return historiaUsuarioRepository.findAll();
	}

}
