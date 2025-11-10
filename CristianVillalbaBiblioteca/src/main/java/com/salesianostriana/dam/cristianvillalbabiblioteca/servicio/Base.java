package com.salesianostriana.dam.cristianvillalbabiblioteca.servicio;

import java.util.List;
import java.util.Optional;

public interface Base<T, ID> {
	List<T> findAll();
	Optional<T> findById(ID id);
	T save(T entity);
	void deleteById(ID id);
	
}
