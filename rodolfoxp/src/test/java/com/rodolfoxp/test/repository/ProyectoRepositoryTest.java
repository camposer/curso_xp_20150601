package com.rodolfoxp.test.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rodolfoxp.config.JpaConfig;
import com.rodolfoxp.model.Proyecto;
import com.rodolfoxp.repository.ProyectosRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
@Transactional
public class ProyectoRepositoryTest {

  @Autowired
  private ProyectosRepository proyectoRepository;

  @Test
  public void test() {
    Proyecto proy1 = new Proyecto("Proy #1", "Descripción #1");
    Proyecto proy2 = new Proyecto("Proy #2", "Descripción #2");

    proyectoRepository.save(proy1);
    proyectoRepository.save(proy2);

    Assert.assertTrue(proyectoRepository.findAll().size() > 1);
  }
}
