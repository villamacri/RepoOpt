package com.salesianostriana.dam.cristianvillalbabiblioteca.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Categoria;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.CategoriaRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServicio extends BaseImpl<Categoria, Long, CategoriaRepositorio>{

}
