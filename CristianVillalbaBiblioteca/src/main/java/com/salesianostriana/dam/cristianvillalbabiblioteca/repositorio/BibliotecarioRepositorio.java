package com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Bibliotecario;

@Repository
public interface BibliotecarioRepositorio extends JpaRepository<Bibliotecario, Long>{

	Bibliotecario findByUsuario(String usuario);
}
