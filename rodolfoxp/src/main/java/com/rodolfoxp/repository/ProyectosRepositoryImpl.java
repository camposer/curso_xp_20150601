package com.rodolfoxp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProyectosRepositoryImpl implements ProyectosRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	
}
