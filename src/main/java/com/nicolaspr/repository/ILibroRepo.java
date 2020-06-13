package com.nicolaspr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicolaspr.model.Libro;


/**
 * Interfaz de Libro referente al repositorio
 * @author Nicolas Palacios
 * @version 1.0
 *
 */
@Repository
public interface ILibroRepo extends CrudRepository<Libro, Long>{

	/**
	 * Consulta que cuenta los libros prestados
	 * @return numero de libros prestados
	 */
	@Query(value="Select count(li) From Libro li WHERE li.ocupado=true")
	Long contarLibros();
}
