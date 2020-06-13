package com.nicolaspr.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Clase generica que me ayuda a implemetar todos los metodo independiente de su clase
 * @author Nicolas Palacios Rios
 * @param <T> Clase a la que se referencias
 * @param <ID> Identificador que utiliza la clase
 */
@Service
public abstract class GenericServiceImpl <T,ID extends Serializable>implements GenericService<T, ID>{

	/**
	 * Metodo que me ayuda a guardar la informacion del objeto sin importar la clase
	 */
	@Override
	public T save(T entity) {
		return getRepo().save(entity);
	}

	/**
	 * Metodo que me ayuda a eliminar la informacion del objeto sin importar la clase
	 */
	@Override
	public void delete(ID id) {
		getRepo().deleteById(id);
		
	}
/**
 * Metodo que me ayuda a buscar un objeto en una clase especifica, sin importar la clase
 */
	@Override
	public T get(ID id) {
		Optional<T> obj = getRepo().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	/**
	 * Metodo que me ayuda a obtener toda la lista de una clase especifica, sin importar la clase
	 */
	@Override
	public List<T> getAll() {
		List<T> ListaRetornada = new ArrayList<>();
		getRepo().findAll().forEach(obj -> ListaRetornada.add(obj));
		return ListaRetornada;
	}

	/**
	 * Implementacion del crud
	 * @return
	 */
	public abstract CrudRepository<T, ID> getRepo();
}
