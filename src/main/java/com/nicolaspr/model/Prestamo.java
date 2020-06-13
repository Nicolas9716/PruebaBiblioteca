package com.nicolaspr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase modelo de prestamo
 * @author Nicolas Palacios
 * @version 1.0
 */
@Entity
@Table
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long idPrestamo;
	@Column
	private Date fecha;
	@Column
	private Long diasPrestado;

	//Relacion con la clase persona
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	private Persona idPersona;

	//Relacion con la clase libro
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLibro")
	private Libro idLibro;

	//Gets y Set de la clase
	
	
	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	public Libro getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Libro idLibro) {
		this.idLibro = idLibro;
	}

	//get modificado para verificar la cantidad de dias que lleva el prestamo
	public Long getDiasPrestado() {
		Date fechaAux = new Date();
		Long resultado = fechaAux.getTime() - fecha.getTime();
		return resultado / 86400000;
	}

	public void setDiasPrestado(Long diasPrestado) {
		this.diasPrestado = diasPrestado;
	}

}
