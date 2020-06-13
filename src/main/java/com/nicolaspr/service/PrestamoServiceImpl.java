package com.nicolaspr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nicolaspr.commons.GenericServiceImpl;
import com.nicolaspr.model.Prestamo;
import com.nicolaspr.repository.IPrestamoRepo;


/**
 * Clase de prestamo referente al Servicio donde implementa la interfaz referente
 * a servicio y extiende de una clase de metodos generales
 * @author Nicolas Palacios
 * @version 1.0
 *
 */
@Service
public class PrestamoServiceImpl extends GenericServiceImpl<Prestamo, Long> implements IPrestamoService{

	@Autowired
	private IPrestamoRepo prestamoRepo;
	
	/**
	 * Implemetacion del metodo Crud
	 */
	@Override
	public CrudRepository<Prestamo, Long> getRepo() {
	
		return prestamoRepo;
	}

}
