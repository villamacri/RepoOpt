package com.salesianostriana.dam.cristianvillalbabiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/layout/base")
	public String fragmentoBase(Model model) {
		model.addAttribute("contenido", "Pruebaaaa");
		
		return "base";
	}
	
	@GetMapping("/index")
	public String inicio(Model model) {
		model.addAttribute("titulo", "Inicio-Biblioteca");
		model.addAttribute("mensaje", "Bienvenido al sistema de gestión de biblioteca");
		
		return "index";
	}
	
	

}
