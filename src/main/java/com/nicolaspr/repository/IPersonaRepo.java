package com.nicolaspr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicolaspr.model.Persona;


/**
 * Interfaz de persona referente al repositorio
 * @author Nicolas Palacios
 * @version 1.0
 *
 */
@Repository
public interface IPersonaRepo extends CrudRepository<Persona, Long>{

}
