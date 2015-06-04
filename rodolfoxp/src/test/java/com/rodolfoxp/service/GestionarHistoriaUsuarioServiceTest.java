package com.rodolfoxp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rodolfoxp.config.JpaConfig;
import com.rodolfoxp.model.HistoriaUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
@Transactional
public class GestionarHistoriaUsuarioServiceTest {

  @Autowired
  private GestionarHistoriaUsuarioService gestionarHistoriaUsuarioService;

  @Test
  public void testSaveHistoriaUsuario() {
    HistoriaUsuario historiaUsuario = createHistoriaUsuarioDummy();

    historiaUsuario = gestionarHistoriaUsuarioService
            .saveHistoriaUsuario(historiaUsuario);

    Assert.assertNotNull(historiaUsuario.getId());
  }

  private HistoriaUsuario createHistoriaUsuarioDummy() {
    HistoriaUsuario historiaUsuario = new HistoriaUsuario();
    historiaUsuario.setDescripcion("descripcion");
    historiaUsuario.setPara("para");
    historiaUsuario.setRol("rol");
    historiaUsuario.setTitulo("titulo");
    return historiaUsuario;
  }

}
