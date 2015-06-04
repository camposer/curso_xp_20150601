package com.rodolfoxp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rodolfoxp.model.HistoriaUsuario;

public class HistoriaUsuarioRepositoryImpl implements
		HistoriaUsuarioRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<HistoriaUsuario> findByUsuarioDesarrollador(String usuario) {
		return entityManager.createQuery("from HistoriaUsuario hu").getResultList();
	}

}
