package com.hector.desafioCoopeuch.modelo;

import java.io.Serializable;
import java.util.List;


public class ResponseDto implements Serializable {
    private static final long serialVersionUID = -3213707927870934540L;

    private List<ListadoTareas> tareas;
    private boolean tieneErrores;
	public List<ListadoTareas> getTareas() {
		return tareas;
	}
	public void setTareas(List<ListadoTareas> tareas) {
		this.tareas = tareas;
	}
	public boolean isTieneErrores() {
		return tieneErrores;
	}
	public void setTieneErrores(boolean tieneErrores) {
		this.tieneErrores = tieneErrores;
	}
	
    

}
