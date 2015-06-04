package com.rodolfoxp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoxp.model.Usuario;
import com.rodolfoxp.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	public void crear(Usuario usuario) {
		this.usuariosRepository.saveAndFlush(usuario);
	}

	@Override
	public List<Usuario> listar() {
		return this.usuariosRepository.findAll();
	}
}
