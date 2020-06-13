package com.nicolaspr.service;

import com.nicolaspr.commons.GenericService;
import com.nicolaspr.model.Libro;


/**
 * Interfaz de libro referente al servicio
 * @author Nicolas Palacios
 * @version 1.0
 *
 */
public interface ILibroService extends GenericService<Libro, Long> {

	Long contarLibros();
	
}
