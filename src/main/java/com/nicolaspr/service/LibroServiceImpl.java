package com.nicolaspr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nicolaspr.commons.GenericServiceImpl;
import com.nicolaspr.model.Libro;
import com.nicolaspr.repository.ILibroRepo;


/**
 * Clase de libro referente al Servicio donde implementa la interfaz referente
 * a libro y extiende de una clase de metodos generales
 * @author Nicolas Palacios
 * @version 1.0
 *
 */
@Service
public class LibroServiceImpl extends GenericServiceImpl<Libro, Long> implements ILibroService {

	@Autowired
	private ILibroRepo libroRepo;

	/**
	 * Implementacion del metodo Crud
	 */
	@Override
	public CrudRepository<Libro, Long> getRepo() {

		return libroRepo;
	}
	
	/**
	 * Implemetacion del metodo para contar los libros prestados
	 */
	@Override
	public Long contarLibros() {
		Long count=libroRepo.contarLibros();
		return count;
	}
	
	

}
