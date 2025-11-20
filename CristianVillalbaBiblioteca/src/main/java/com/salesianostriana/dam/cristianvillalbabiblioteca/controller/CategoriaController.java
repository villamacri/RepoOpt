package com.salesianostriana.dam.cristianvillalbabiblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Categoria;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.CategoriaServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

	private final CategoriaServicio categoriaServicio;
	
	@GetMapping("/")
	public String listar (Model model) {
		model.addAttribute("categorias", categoriaServicio.findAll());
		return "categoria/listar";
	}
	
	@GetMapping("/nueva")
    public String formularioNueva(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        return categoriaServicio.findById(id)
                .map(c -> {
                    model.addAttribute("categoria", c);
                    return "categoria/formulario";
                })
                .orElse("redirect:/categorias/");
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Categoria categoria) {
        categoriaServicio.save(categoria);
        return "redirect:/categorias/";
    }

    @PostMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        try {
            categoriaServicio.deleteById(id);
        } catch (Exception e) {
            return "redirect:/categorias/?error=No se puede borrar una categoría que tiene libros asignados";
        }
        return "redirect:/categorias/";
    }
}
