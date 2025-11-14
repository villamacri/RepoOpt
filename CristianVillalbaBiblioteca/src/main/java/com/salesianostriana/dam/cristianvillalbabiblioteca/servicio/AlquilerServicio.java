package com.salesianostriana.dam.cristianvillalbabiblioteca.servicio;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Alquiler;
import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Lector;
import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Libro;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.AlquilerRepositorio;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.LectorRepositorio;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.LibroRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlquilerServicio extends BaseImpl<Alquiler, Long, AlquilerRepositorio>{
	
	private final AlquilerRepositorio alquilerRepositorio;
	private final LibroRepositorio libroRepositorio;
	private final LectorRepositorio lectorRepositorio;
	
	public Alquiler crearAlquiler(Long libroId, Long lectorId, LocalDate fechaInicio, LocalDate fechaFin) {
		Libro libro = libroRepositorio.findById(lectorId)
				.orElseThrow(() -> new RuntimeException("Libro no encontrado"));
		Lector lector = lectorRepositorio.findById(lectorId)
				.orElseThrow(() -> new RuntimeException("Lector no encontrado"));
		
		if(!libroDisponible(libroId, fechaInicio, fechaFin)) {
			throw new  RuntimeException("El libro no está disponible en esas fechas");
		}
	}
	
}
