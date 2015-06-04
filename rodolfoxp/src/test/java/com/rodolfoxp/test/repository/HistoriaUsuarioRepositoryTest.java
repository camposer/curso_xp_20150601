package com.rodolfoxp.test.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rodolfoxp.config.JpaConfig;
import com.rodolfoxp.model.HistoriaUsuario;
import com.rodolfoxp.repository.HistoriaUsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
@Transactional
public class HistoriaUsuarioRepositoryTest {
  @Autowired
  private HistoriaUsuarioRepository historiaUsuarioRepository;

  @Test
  public void test() {
    HistoriaUsuario hu1 = new HistoriaUsuario("Título #1", "Descripción #1",
            "rol#1", "para#1");
    HistoriaUsuario hu2 = new HistoriaUsuario("Título #2", "Descripción #2",
            "rol#1", "para#1");

    historiaUsuarioRepository.save(hu1);
    historiaUsuarioRepository.save(hu2);

    Assert.assertTrue(historiaUsuarioRepository.findAll().size() >= 2);
  }
}
