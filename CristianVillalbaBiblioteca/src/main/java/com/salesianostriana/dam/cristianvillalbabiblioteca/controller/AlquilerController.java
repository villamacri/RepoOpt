package com.salesianostriana.dam.cristianvillalbabiblioteca.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Alquiler;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.AlquilerServicio;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.LectorServicio;
import com.salesianostriana.dam.cristianvillalbabiblioteca.servicio.LibroServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/alquileres")
@RequiredArgsConstructor
public class AlquilerController {

	private final AlquilerServicio alquilerServicio;
	private final LibroServicio libroServicio;
	private final LectorServicio lectorServicio;
	
	@GetMapping("/")
	public String listarAlquileres(Model model) {
		model.addAttribute("alquileres", alquilerServicio.findAlquileresActivos());
		return "alquiler/listar";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("alquiler", new Alquiler());
		model.addAttribute("libros", libroServicio.findAll());
		model.addAttribute("lectores", lectorServicio.findAll());
		return "alquiler/nuevo";
	}
	
	@PostMapping("/nuevo")
	public String crearAlquiler(
			@RequestParam Long libroId,
			@RequestParam Long lectorId,
			@RequestParam String fechaInicio,
			@RequestParam String fechaFin,
			Model model) {
		try {
			if (fechaInicio == null || fechaInicio.isEmpty() || fechaFin == null || fechaFin.isEmpty()) {
	            throw new RuntimeException("Las fechas de inicio y fin son obligatorias.");
	        }
			LocalDate inicio = LocalDate.parse(fechaInicio);
			LocalDate fin = LocalDate.parse(fechaFin);
			
			Alquiler alquiler = alquilerServicio.crearAlquiler(libroId, lectorId, inicio, fin);
			model.addAttribute("alquiler", alquiler);
			
			return "alquiler/detalle";
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("libros", libroServicio.findAll());
			model.addAttribute("lectores", lectorServicio.findAll());
			model.addAttribute("alquiler", new Alquiler());
			return "alquiler/nuevo";
		}
	}
	
	@GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        return alquilerServicio.findById(id)
                .map(a -> {
                    model.addAttribute("alquiler", a);
                    return "alquiler/detalle";
                })
                .orElse("redirect:/alquileres/");
    }
	
	@PostMapping("/devolver/{id}")
	public String devolverLibro(@PathVariable Long id) {
		alquilerServicio.devolverLibro(id);
		return "redirect:/alquileres/"+id;
	}
	
	@PostMapping("/cancelar/{id}")
	public String cancelarAlquiler(@PathVariable Long id) {
		try {
			alquilerServicio.cancelarAlquiler(id);
			return "redirect:/alquileres/";
		}catch (RuntimeException e) {
			return "redirect:/alquileres/?error=" + e.getMessage();
		}
	}
	
}
