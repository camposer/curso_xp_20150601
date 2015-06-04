package com.rodolfoxp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoxp.model.Proyecto;

public interface ProyectosRepository extends JpaRepository<Proyecto, Long>,ProyectosRepositoryCustom {

}
