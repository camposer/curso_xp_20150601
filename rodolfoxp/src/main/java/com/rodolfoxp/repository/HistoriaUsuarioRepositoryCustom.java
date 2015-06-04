package com.rodolfoxp.repository;

import java.util.List;

import com.rodolfoxp.model.HistoriaUsuario;

public interface HistoriaUsuarioRepositoryCustom {
	List<HistoriaUsuario> findByUsuarioDesarrollador(String usuario);
}
