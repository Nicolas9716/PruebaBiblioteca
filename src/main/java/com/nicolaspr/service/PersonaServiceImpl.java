package com.nicolaspr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nicolaspr.commons.GenericServiceImpl;
import com.nicolaspr.model.Persona;
import com.nicolaspr.repository.IPersonaRepo;


/**
 * Clase de persona referente al Servicio donde implementa la interfaz referente
 * a persona y extiende de una clase de metodos generales
 * @author Nicolas Palacios
 * @version 1.0
 *
 */
@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements IPersonaService {

	@Autowired
	private IPersonaRepo personaRepo;

	/**
	 * Implementacion del metodo Crud
	 */
	@Override
	public CrudRepository<Persona, Long> getRepo() {

		return personaRepo;
	}

}
