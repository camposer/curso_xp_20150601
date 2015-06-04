package com.rodolfoxp.service;

import java.util.List;

import com.rodolfoxp.model.Proyecto;

public interface ProyectosService {
	
	public void crear(Proyecto proyecto);
	
	public List<Proyecto> listar();

}
