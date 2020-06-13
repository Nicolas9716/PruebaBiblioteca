package com.nicolaspr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nicolaspr.model.Libro;
import com.nicolaspr.service.ILibroService;


/**
 * Controlador de la clase Libro
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */

@Controller
public class LibroController {

	@Autowired
	private ILibroService libroService;

	
	/**
	 * Metodo que me ayuda a listar los libros registrados
	 * @param model modelo a utilizar
	 * @return direccion pagina principal libro
	 */
	@RequestMapping("/indexLibro")
	public String indexPersona(Model model) {
		model.addAttribute("listLi", libroService.getAll());
		model.addAttribute("countLibros", libroService.contarLibros());
		return "indexLibro";
	}

	
	/**
	 * Metodo que me ayuda a actualizar la informacion de los libros
	 * @param id identificador del libro
	 * @param model modelo a utilizar
	 * @return direccion de la pagina para guardar
	 */
	@GetMapping("/saveLi/{id}")
	public String showSaveLi(@PathVariable("id") Long id, Model model) {
		if (id != 0 && id !=null) {
			model.addAttribute("libro", libroService.get(id));
		} else {
			model.addAttribute("libro", new Libro());
		}
		return "saveLi";
	}

	
	/**
	 * Metodo que me ayuda a guardar la informacion del libro
	 * @param libro libro a guardar
	 * @param model modelo a utilizar
	 * @return reedireccion a la pagina principal de libro
	 */
	@PostMapping("/saveLi")
	public String saveLi(Libro libro, Model model) {
		libro.setOcupado(false);
		libroService.save(libro);
		return "redirect:/indexLibro";
	}

	
	/**
	 * Metodo que me ayuda a eliminar la informacion de un libro
	 * @param id identificador del libro a eliminar
	 * @param model modelo a utilizar
	 * @return redireccion a la pagina principal de libro
	 */
	@GetMapping("/deleteLi/{id}")
	public String deleteLi(@PathVariable Long id, Model model) {
		libroService.delete(id);
		return "redirect:/indexLibro";

	}
	

}
