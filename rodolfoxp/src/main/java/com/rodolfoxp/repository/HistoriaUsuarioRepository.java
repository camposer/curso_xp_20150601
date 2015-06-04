package com.rodolfoxp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoxp.model.HistoriaUsuario;

public interface HistoriaUsuarioRepository 
	extends JpaRepository<HistoriaUsuario, Long> {

}
