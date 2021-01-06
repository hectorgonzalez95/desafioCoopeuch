package com.hector.desafioCoopeuch.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListadoTareas implements Serializable{

	private static final long serialVersionUID = -5351595541513744935L;	
	private Integer id;
	private String descripcion;		
	@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate fechaCreacion;
	private boolean vigente;
	
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

	
}
