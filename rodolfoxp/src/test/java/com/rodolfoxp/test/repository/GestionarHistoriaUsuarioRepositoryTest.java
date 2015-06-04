package com.rodolfoxp.test.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rodolfoxp.config.JpaConfig;
import com.rodolfoxp.model.GestionarHistoriaUsuario;
import com.rodolfoxp.repository.GestionarHistoriaUsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
@Transactional
public class GestionarHistoriaUsuarioRepositoryTest {
	@Autowired
	private GestionarHistoriaUsuarioRepository gestionarHistoriaUsuario;
	
	@Test
	public void test() {
		
		GestionarHistoriaUsuario ghu1 = new GestionarHistoriaUsuario("Login", "JAVA", "Crear pantalla de login", 100);
		GestionarHistoriaUsuario ghu2 = new GestionarHistoriaUsuario("Crud de usuario/roles", "JAVA", "Crear una pantalla de gestión de usuarios y roles", 50);
		GestionarHistoriaUsuario ghu3 = new GestionarHistoriaUsuario("Probar login", "Pruebas", "Pruebas de integración", 10);
		
		gestionarHistoriaUsuario.save(ghu1);
		gestionarHistoriaUsuario.save(ghu2);
		gestionarHistoriaUsuario.save(ghu3);
		
		Assert.assertTrue(gestionarHistoriaUsuario.findAll().size() >= 3);
	}
}
