package com.nicolaspr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicolaspr.model.Prestamo;


/**
 * Interfaz de prestamo referente al repositorio
 * @author Nicolas Palacios
 * @version 1.0
 *
 */
@Repository
public interface IPrestamoRepo extends CrudRepository<Prestamo, Long>{

}
