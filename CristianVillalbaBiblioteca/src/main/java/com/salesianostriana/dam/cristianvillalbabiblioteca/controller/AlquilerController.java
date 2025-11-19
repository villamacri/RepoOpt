package com.salesianostriana.dam.cristianvillalbabiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Alquiler;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.AlquilerServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/alquileres")
@RequiredArgsConstructor
public class AlquilerController {

	private final AlquilerServicio servicio;
	
	@GetMapping("/")
	public String listarAlquileres(Model model) {
		model.addAttribute("Alquileres", servicio.findAlquileresActivos());
		return "alquiler/listar";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("alquiler", new Alquiler());
		return "alquiler/nuevo";
	}
	

	
}
