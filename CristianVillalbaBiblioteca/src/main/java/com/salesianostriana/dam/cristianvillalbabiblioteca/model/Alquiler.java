package com.salesianostriana.dam.cristianvillalbabiblioteca.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ForeignKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private LocalDate fechaInicio, fechaDevolucionPrevista;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_alquiler_libro"))
	private Libro libro;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_alquiler_lector"))
	private Lector lector;
}
