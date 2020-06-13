package com.nicolaspr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nicolaspr.model.Persona;
import com.nicolaspr.service.IPersonaService;

/**
 * Controlador de la clase persona
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
@Controller
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	/**
	 * Metodo que me ayuda a listar todas la personas registradas
	 * @param model modelo a utilizar
	 * @return direccion a pagina principal de persona
	 */
	@RequestMapping("/indexPersona")
	public String indexPersona(Model model) {
		model.addAttribute("listPer", personaService.getAll());
		return "indexPersona";
	}

	/**
	 * Metodo que me ayuda modificar la informacion de las personas registrada
	 * @param id identificador de la persona a la cual se le va a modificar la informacion
	 * @param model modelo a utilizar
	 * @return direccion de la pagina para guardar
	 */
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if(id != 0) {
			model.addAttribute("persona", personaService.get(id));
		}else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}
	
	
	/**
	 * Metodo que me ayuda a guardar la informacion dee una persona
	 * @param persona Persona a guardar
	 * @param model modelo a utilizar
	 * @return redireccion a la pagina principal de persona
	 */
	@PostMapping("/save")
	public String save(Persona persona,Model model) {
		personaService.save(persona);
		return "redirect:/indexPersona";
	}
	
	/**
	 * Metodo que elimina la informacion de la persona
	 * @param id identificador de la persona a eliminar
	 * @param model modelo a utilizar
	 * @return redireccion a la pagina principal
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id,Model model) {
		personaService.delete(id);
		return "redirect:/indexPersona";
	}
}
