package com.salesianostriana.dam.cristianvillalbabiblioteca.servicio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Alquiler;
import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Lector;
import com.salesianostriana.dam.cristianvillalbabiblioteca.model.Libro;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.AlquilerRepositorio;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.LectorRepositorio;
import com.salesianostriana.dam.cristianvillalbabiblioteca.repositorio.LibroRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlquilerServicio extends BaseImpl<Alquiler, Long, AlquilerRepositorio>{
	
	private final AlquilerRepositorio alquilerRepositorio;
	private final LibroRepositorio libroRepositorio;
	private final LectorRepositorio lectorRepositorio;
	
	
	public boolean libroDisponible(Long libroId, LocalDate inicio, LocalDate fin) {
		List<Alquiler> alquileres=alquilerRepositorio.findByDevueltoFalse();
		return alquileres.stream()
				.filter(a -> a.getLibro().getId().equals(libroId))
				.noneMatch(a ->
						!(fin.isBefore(a.getFechaInicio()) || inicio.isAfter(a.getFechaDevolucionPrevista()))
						);
		
	}
	public Alquiler crearAlquiler(Long libroId, Long lectorId, LocalDate fechaInicio, LocalDate fechaFin) {
		Libro libro = libroRepositorio.findById(libroId)
				.orElseThrow(() -> new RuntimeException("Libro no encontrado"));
		Lector lector = lectorRepositorio.findById(lectorId)
				.orElseThrow(() -> new RuntimeException("Lector no encontrado"));
		
		if(!libroDisponible(libroId, fechaInicio, fechaFin)) {
			throw new RuntimeException("El libro no está disponible en esas fechas");
		}
		
		if(lector.getFechaFinSancion() != null && lector.getFechaFinSancion().isAfter(LocalDate.now())) {
			throw new RuntimeException("El lector está sancionado hasta el " + lector.getFechaFinSancion());
		}
		
		if(alquilerRepositorio.countByLectorIdAndDevueltoFalse(lectorId)>=3) {
			throw new RuntimeException("El lector ya tiene 3 libros sin devolver. Límite alcanzado");
		}
		
		long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		if(dias <= 0) {
			throw new RuntimeException("La fecha de devolución debe ser posterior a la fecha de inicio");
		}
		
		Alquiler alquiler = new Alquiler();
		
		alquiler.setLibro(libro);
		alquiler.setLector(lector);
		alquiler.setFechaInicio(fechaInicio);
		alquiler.setFechaDevolucionPrevista(fechaFin);
		alquiler.setPrecioTotal((libro.getCategoria().getPrecioBase())*dias);
		alquiler.setDevuelto(false);
		
		libro.setEstado("ALQUILADO");
		libroRepositorio.save(libro);
		
		return alquilerRepositorio.save(alquiler);
	}
	
	public Optional<Alquiler>devolverLibro(Long alquilerId){
		Optional<Alquiler>alquilerOpt = alquilerRepositorio.findById(alquilerId);
		if(alquilerOpt.isEmpty()) return Optional.empty();
		
		Alquiler alquiler = alquilerOpt.get();
		alquiler.setDevuelto(true);
		alquiler.setFechaDevolucionReal(LocalDate.now());
		
		long retraso = ChronoUnit.DAYS.between(alquiler.getFechaDevolucionPrevista(), LocalDate.now());
		long diasSancion = retraso*2;
		if(retraso > 0) {
			double recargo = retraso * (alquiler.getLibro().getCategoria().getPrecioBase()*0.2);
			alquiler.setPrecioTotal(alquiler.getPrecioTotal()+recargo);
			
			Lector lector=alquiler.getLector();
			
			lector.setFechaFinSancion(LocalDate.now().plusDays(diasSancion));
			lectorRepositorio.save(lector);
		}
		
		Libro libro = alquiler.getLibro();
		libro.setEstado("DISPONIBLE");
		libroRepositorio.save(libro);
		
		return Optional.of(alquilerRepositorio.save(alquiler));
	}
	
	public Optional<Alquiler>cancelarAlquiler(Long alquilerId){
		Optional<Alquiler>alquilerOpt=alquilerRepositorio.findById(alquilerId);
		if(alquilerOpt.isEmpty())
			return Optional.empty();
		
		Alquiler alquiler=alquilerOpt.get();
		
		if(alquiler.getFechaInicio().isAfter(LocalDate.now())) {
			Libro libro = alquiler.getLibro();
			
			libro.setEstado("DISPONIBLE");
			libroRepositorio.save(libro);
			
			alquilerRepositorio.deleteById(alquilerId);
			return Optional.of(alquiler);
		}else {
			throw new RuntimeException("No se puede cancelar un alquiler ya iniciado");
		}
	}
	
	public List<Alquiler> findByLectorId(Long lectorId){
		return alquilerRepositorio.findByLectorId(lectorId);
	}
	
	public List<Alquiler>findAlquileresActivos(){
		return alquilerRepositorio.findByDevueltoFalse();
	}
	
}
