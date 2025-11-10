package com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Lector;

@Repository
public interface LectorRepositorio extends JpaRepository<Lector, Long>{

	Lector findByEmail(String email);
	
	List<Lector> findByNombreContainingIgnoreCase(String nombre);
}
