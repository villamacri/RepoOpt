package com.salesianostriana.dam.cristianvillalbabiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Libro;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.CategoriaServicio;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.LibroServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/libros")
@RequiredArgsConstructor
public class LibroController {

	private final LibroServicio libroServicio;
	private final CategoriaServicio categoriaServicio;
	
	@GetMapping("/")
	public String listar(Model model) {
		model.addAttribute("libros", libroServicio.findAll());
		return "libro/listar";
	}
	
	@GetMapping("/nuevo")
	public String formularioNuevo(Model model) {
		model.addAttribute("libro", new Libro());
		model.addAttribute("categorias", categoriaServicio.findAll());
		
		return "libro/formulario";
	}
	
	@GetMapping("/editar/{id}")
	public String formularioEditar(@PathVariable Long id, Model model) {
		return libroServicio.findById(id)
				.map(l -> {
					model.addAttribute("libro", l);
					model.addAttribute("categorias", categoriaServicio.findAll());
					return "libro/formulario";
				})
				.orElse("redirect:/libros/");
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Libro libro) {
		if(libro.getId() == null) {
			libro.setEstado("DISPONIBLE");
		}
		libroServicio.save(libro);
		return "redirect:/libros/";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		try {
			libroServicio.deleteById(id);
		}catch(Exception e) {
			return "redirect:/libros/?error=No se puede borrar el libro";
		}
		return "redirect:/libros/";
	}
}
