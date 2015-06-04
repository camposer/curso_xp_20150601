package com.rodolfoxp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoxp.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

}
