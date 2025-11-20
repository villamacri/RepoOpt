package com.salesianostriana.dam.cristianvillalbabiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Lector;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.LectorServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/lectores")
@RequiredArgsConstructor
public class LectorController {

	private final LectorServicio lectorServicio;
	
	@GetMapping("/")
	public String listar(Model model) {
		model.addAttribute("lectores", lectorServicio.findAll());
		return "lector/listar";
	}
	
	@GetMapping("/nuevo")
	public String formularioNuevo(Model model) {
		model.addAttribute("lector", new Lector());
		return "lector/formulario";
	}
	
	@GetMapping("/editar/{id}")
	public String formularioEditar(@PathVariable Long id, Model model) {
		return lectorServicio.findById(id)
				.map(l -> {
					model.addAttribute("lector", l);
					return "lector/formulario";
				})
				.orElse("redirect:/lectores/");
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Lector lector) {
		lectorServicio.save(lector);
		return "redirect:/lectores/";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		try {
			lectorServicio.deleteById(id);
		}catch (Exception e) {
			return "redirect:/lectores/?error=No se puede borrar un lector con alquileres pendientes";
		}
		return "redirect:/lectores/";
	}
}
