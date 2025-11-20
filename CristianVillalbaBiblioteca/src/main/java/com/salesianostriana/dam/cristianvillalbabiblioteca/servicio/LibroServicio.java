package com.salesianostriana.dam.cristianvillalbabiblioteca.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Libro;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.LibroRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroServicio extends BaseImpl<Libro, Long, LibroRepositorio>{
	
	private final LibroRepositorio repo;

}
