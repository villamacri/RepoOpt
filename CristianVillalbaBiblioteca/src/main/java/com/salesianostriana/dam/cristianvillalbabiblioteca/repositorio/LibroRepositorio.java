package com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long>{
	
	List<Libro> findByEstado(String estado);
	
	List<Libro> findByCategoriaId(Long categoriaId);
	
	List<Libro> findByTituloContainingIgnoreCase(String titulo);
	
	List<Libro> findByAutorContainingIgnoreCase(String autor);

}
