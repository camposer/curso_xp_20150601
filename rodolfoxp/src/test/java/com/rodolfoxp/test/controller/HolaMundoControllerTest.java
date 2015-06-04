package com.rodolfoxp.test.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.rodolfoxp.controller.HolaMundoController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class HolaMundoControllerTest {
	private MockMvc mockMvc;
	
    @Autowired
    private WebApplicationContext ctx;
	@Autowired
	private HolaMundoController holaMundoController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void test() throws Exception {
		MvcResult result = mockMvc.perform(
				get("/holaMundo.xp"))
				.andExpect(status().isOk())
				.andReturn();

		String responseBody = result.getResponse().getContentAsString();
		
		assertTrue(responseBody.contains("Hola mundo"));
	}

	@Configuration
    @EnableWebMvc	
	public static class Config {
		@Bean
		public HolaMundoController holaMundoController() {
			return new HolaMundoController();
		}
	}
}