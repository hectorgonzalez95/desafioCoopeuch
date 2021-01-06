package com.hector.desafioCoopeuch.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hector.desafioCoopeuch.modelo.Tarea;
import com.hector.desafioCoopeuch.services.TareaService;

@Controller
@RequestMapping("/tarea")
public class TareaController {

	@Autowired
	private TareaService tareaService;

	@PostMapping("/agregar-tarea")
	public ResponseEntity<?> agregarTarea(@Valid Tarea tarea, BindingResult result) {		
		if (!result.hasErrors()) {			
			boolean tieneErrores = tareaService.agregarTarea(tarea);		
			if(!tieneErrores) {
	    		return ResponseEntity.status(HttpStatus.OK).body("tarea agregada");	
			}else{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
		} else {	
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(tareaService.jsonErrores(result));
		}
	}
	
	@PostMapping("/editar-tarea")
	public ResponseEntity<?> editarTarea(@Valid Tarea tarea, BindingResult result) {		
		if (!result.hasErrors()) {			
			boolean tieneError = tareaService.editarTarea(tarea);	
			if(!tieneError) {
	        	return ResponseEntity.status(HttpStatus.OK).body("tarea editada");	
			}else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
		} else {	
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(tareaService.jsonErrores(result));
		}
	}

}
