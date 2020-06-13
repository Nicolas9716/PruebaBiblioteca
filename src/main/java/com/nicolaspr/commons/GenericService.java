package com.nicolaspr.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz generica, que me ayuda a empaquetar los servicios sin importar clase
 * @author Nicolas Palacios Rios
 * @param <T> Atributo que me identifica el tipo de la clase
 * @param <ID> identificador utilizado en la clase
 */
public interface GenericService <T, ID extends Serializable>{
	
	
	T save(T entity);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();
	

}
