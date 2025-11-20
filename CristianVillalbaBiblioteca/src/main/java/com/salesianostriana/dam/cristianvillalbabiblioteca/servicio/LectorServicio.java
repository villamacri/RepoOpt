package com.salesianostriana.dam.cristianvillalbabiblioteca.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Lector;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.LectorRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectorServicio extends BaseImpl<Lector, Long, LectorRepositorio>{

	private final LectorRepositorio repo;
	
}
