package com.rodolfoxp.service;

import java.util.List;

import com.rodolfoxp.model.Usuario;

public interface UsuariosService {
	
	public void crear(Usuario usuario);
	
	public List<Usuario> listar();

}
