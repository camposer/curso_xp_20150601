package com.rodolfoxp.controller;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
@Ignore
public class ProyectosControllerTest {
	
	  private MockMvc mockMvc;

	  @Autowired
	  private WebApplicationContext ctx;
	  @Autowired
	  private ProyectosController proyectosController;
	  
	  
	  @Configuration
	  @EnableWebMvc
	  public static class Config {
	    @Bean
	    public ProyectosController proyectosController() {
	      return new ProyectosController();
	    }
	  }
	
}
