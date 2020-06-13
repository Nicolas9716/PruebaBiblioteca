package com.nicolaspr.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nicolaspr.model.Libro;
import com.nicolaspr.model.Persona;
import com.nicolaspr.model.Prestamo;
import com.nicolaspr.service.ILibroService;
import com.nicolaspr.service.IPersonaService;
import com.nicolaspr.service.IPrestamoService;


/**
 * Controlador de la clase prestamo
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
@Controller
public class PrestamoController {
	
	@Autowired
	private IPrestamoService prestamoService;
	@Autowired
	private ILibroService libroService;
	@Autowired
	private IPersonaService personaService;
	
	private Libro libro;
	
	private Persona persona;
	
	/**
	 * Metodo que me ayuda a generar la lista de prestamos hechos
	 * @param model modelo con el que se va a trabajar
	 * @return direccion pagina principal de prestamo
	 */
	@RequestMapping("/indexPrestamo")
	public String indexPre(Model model) {
		model.addAttribute("listPre", prestamoService.getAll());
		return "indexPrestamo";
	
	}

	/**
	 * Metodo que me ayuda a modificar la informacion un prestamo hecho
	 * @param id identificador del prestamo a modificar
	 * @param model modelo con el cual se va a trabajar
	 * @return direccion donde se guardan los prestamos
	 */
	@GetMapping("/savePre/{id}")
	public String showSavePre(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listPer", personaService.getAll());
		model.addAttribute("listLi", libroService.getAll());
		model.addAttribute("listPre", prestamoService.getAll());
		
		if (id != 0 ) {
			model.addAttribute("prestado", prestamoService.get(id));
		} else {
			model.addAttribute("prestado", new Prestamo());
		}

		return "savePre";
	}

	/**
	 * Metodo que me ayuda a guardar la informacion del prestamo hecho
	 * @param prestamo prestamo a hacer
	 * @param model modelo con el cual se va a trabajar 
	 * @return Redireccionarr a pagina principal, redireccionar a pagina con advertencia o error
	 */
	@PostMapping("/savePre")
	public String savePre(Prestamo prestamo,Model model) {
		System.out.println("Entro al metodo guardar");
		libro= new Libro();
		libro=libroService.get(prestamo.getIdLibro().getIdLibro());
		
		persona=new Persona();
		persona=personaService.get(prestamo.getIdPersona().getIdPersona());
		
		if(libro.getCatEdad()>persona.getEdad()) {
			System.out.println("error edad");
			return "redirect:/savePre/0?logout=true";
		}else if(libro.isOcupado()) {
			System.out.println("error ocupado");
			return "redirect:/savePre/0?error=true";
		}
		prestamo.setFecha(new Date());
		libro.setOcupado(true);
		libroService.save(libro);
		prestamoService.save(prestamo);
		return "redirect:/indexPrestamo";
	}
	
	/**
	 * Metodo que me ayuda a eliminar la informacion del prestamo hecho
	 * @param id identificador del prestamo a eliminar
	 * @param model modelo con el cual se va a trabajar
	 * @return redireccion a la pagina principal de prestamo
	 */
	@GetMapping("/deletePre/{id}")
	public String deletePre(@PathVariable Long id,Model model) {
		libro=new Libro();
		libro=libroService.get(prestamoService.get(id).getIdLibro().getIdLibro());
		libro.setOcupado(false);
		libroService.save(libro);
		prestamoService.delete(id);
		return "redirect:/indexPrestamo";
	}


}
