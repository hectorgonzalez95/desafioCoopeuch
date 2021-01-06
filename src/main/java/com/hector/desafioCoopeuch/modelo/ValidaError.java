package com.hector.desafioCoopeuch.modelo;


import java.io.Serializable;
import java.util.List;


public class ValidaError implements Serializable {

    private static final long serialVersionUID = 6680133671720181013L;
    
    private String campo;
    private List<String> mensaje;
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public List<String> getMensaje() {
		return mensaje;
	}
	public void setMensaje(List<String> mensaje) {
		this.mensaje = mensaje;
	}

}
