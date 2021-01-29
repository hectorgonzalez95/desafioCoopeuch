package com.hector.desafioCoopeuch.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tarea implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Debe agregar descripción de la tarea")
	private String descripcion;	
	@NotEmpty(message = "Debe agregar fecha creacion")
	private String strFecha;
	@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate fechaCreacion;
	private boolean vigente;
	private String cualquierCosa;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getStrFecha() {
		return strFecha;
	}
	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isVigente() {
		return vigente;
	}
	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

	public String getCualquierCosa() {
		return cualquierCosa;
	}

	public void setCualquierCosa(String cualquierCosa) {
		this.cualquierCosa = cualquierCosa;
	}
}
