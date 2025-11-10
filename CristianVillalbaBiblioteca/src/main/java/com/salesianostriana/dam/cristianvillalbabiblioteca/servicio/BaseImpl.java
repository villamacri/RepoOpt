package com.salesianostriana.dam.cristianvillalbabiblioteca.servicio;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseImpl<T, ID> implements Base<T, ID> {

	protected final JpaRepository<T, ID> repository;
	
	protected BaseImpl(JpaRepository<T,ID> repository) {
		this.repository = repository;
	}
} 
