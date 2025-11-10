package com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Alquiler;

@Repository
public interface AlquilerRepositorio extends JpaRepository<Alquiler, Long>{
	
	List<Alquiler> findByLectorId(Long lectorId);
	
	List<Alquiler> findByDevueltoFalse();
	
	List<Alquiler> findByDevueltoTrue();
	
	List<Alquiler> findByFechaInicioBetween(LocalDate inicio, LocalDate fin);
}
