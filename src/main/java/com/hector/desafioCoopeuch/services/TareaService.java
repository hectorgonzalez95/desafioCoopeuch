package com.hector.desafioCoopeuch.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hector.desafioCoopeuch.modelo.ListadoTareas;
import com.hector.desafioCoopeuch.modelo.ResponseDto;
import com.hector.desafioCoopeuch.modelo.Tarea;
import com.hector.desafioCoopeuch.modelo.ValidaError;
import com.hector.desafioCoopeuch.repositorio.TareaRepositorio;

@Service
public class TareaService {

    private static final Logger logger = LogManager.getLogger(TareaService.class);

    @Autowired
    @Qualifier("tareaRepositorio")
    private TareaRepositorio tareaRepositorio;
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private ObjectMapper om;
    
    
    @Transactional
	public void agregarTarea(Tarea tarea) {
    		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    		tarea.setFechaCreacion(LocalDate.parse(tarea.getStrFecha(), formatoFecha));
    		logger.info("Tarea agregada");
    		tareaRepositorio.agregarTarea(tarea);
	}
    
    @Transactional
	public boolean editarTarea(Tarea tarea) {
    	try {
    		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    		tarea.setFechaCreacion(LocalDate.parse(tarea.getStrFecha(), formatoFecha));
    		logger.info("Tarea editada");
        	tareaRepositorio.editarTarea(tarea);	
        	return false;

		} catch (Exception e) {
			return true;
		}
    	
	}

	@Transactional
    public List<Tarea> obtieneTareas() {
        return tareaRepositorio.obtieneTareas();
	}
    
    public String jsonErrores(BindingResult result) {
        String json = "";
        List<ValidaError> listadoError = new ArrayList<>();
        result.getFieldErrors().forEach(e -> {
            List<String> listadoMensaje = new ArrayList<>();
            ValidaError er = new ValidaError();
            boolean a = listadoError.stream().anyMatch(l -> l.getCampo().equals(e.getField()));
            if (a) {
                listadoError.forEach(l -> {
                    if (l.getCampo().equals(e.getField())) {
                        l.getMensaje()
                                .add(messageSource.getMessage(
                                        e.getCode() + "." + e.getObjectName() + "." + e.getField(),
                                        new Object[]{e.getRejectedValue()}, null));
                    }
                });
            } else {
                listadoMensaje.add(messageSource.getMessage(e.getCode() + "." + e.getObjectName() + "." + e.getField(),
                        new Object[]{e.getRejectedValue()}, null));
                er.setCampo(e.getField());
                er.setMensaje(listadoMensaje);
                listadoError.add(er);
            }
        });
        Map<String, List<ValidaError>> map = new HashMap<>();
        map.put("errores", listadoError);
        try {
            json = om.writeValueAsString(map);
        } catch (IOException e) {
            logger.error("Error al convertir errores a json ", e);
        }
        return json;
    }

	


}




