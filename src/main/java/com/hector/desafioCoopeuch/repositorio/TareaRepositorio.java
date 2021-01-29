package com.hector.desafioCoopeuch.repositorio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.hector.desafioCoopeuch.mappers.TareaMapper;
import com.hector.desafioCoopeuch.modelo.ListadoTareas;
import com.hector.desafioCoopeuch.modelo.Tarea;

@Repository("tareaRepositorio")
public class TareaRepositorio {

    private static final Logger logger = LogManager.getLogger(TareaRepositorio.class);

    @Autowired
    private TareaMapper tareaMapper;

    public void agregarTarea(Tarea tarea) {
    	tareaMapper.agregarTarea(tarea);
    }

	public void editarTarea(Tarea tarea) {
		try {
    		tareaMapper.editarTarea(tarea);
        } catch (DataAccessException ex) {
            logger.error("Error al editar tarea", ex);            
        }
		
	}

	public List<Tarea> obtieneTareas() {
    	return tareaMapper.obtieneTareas();
    }

    
}
