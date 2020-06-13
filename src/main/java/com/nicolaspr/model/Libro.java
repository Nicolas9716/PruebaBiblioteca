package com.nicolaspr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase modelo de Libro
 * @author Nicolas Palacios
 * @version 1.0
 */
@Entity
@Table
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long idLibro;
	@Column
	private String nombre;
	@Column
	private String portada;
	@Column
	private int catEdad;
	@Column
	private boolean ocupado;
	
	
	//Relacion con la clase prestamo
	
	@OneToMany(mappedBy = "idLibro")
	private List<Prestamo>prestamo;

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public int getCatEdad() {
		return catEdad;
	}

	public void setCatEdad(int catEdad) {
		this.catEdad = catEdad;
	}

	public List<Prestamo> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(List<Prestamo> prestamo) {
		this.prestamo = prestamo;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	
}
