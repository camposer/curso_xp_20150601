package com.rodolfoxp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolaMundoController {
	// http://localhost:8080/rodolfoxp/holaMundo.xp
	@RequestMapping("/holaMundo")
	public @ResponseBody String holaMundo() {
		return "Hola mundo";
	}
}
