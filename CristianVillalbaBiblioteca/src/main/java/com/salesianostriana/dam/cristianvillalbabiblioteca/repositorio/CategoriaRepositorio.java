package com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
	
	Categoria findByNombre(String nombre);
}
