package com.rodolfoxp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoxp.model.Proyecto;
import com.rodolfoxp.repository.ProyectosRepository;

@Service
public class ProyectosServiceImpl implements ProyectosService {
	
	@Autowired
	private ProyectosRepository proyectosRepository;
	
	@Override
	public void crear(Proyecto proyecto) {
		this.proyectosRepository.save(proyecto);
	}

	@Override
	public List<Proyecto> listar() {
		return this.proyectosRepository.findAll();
	}
}
