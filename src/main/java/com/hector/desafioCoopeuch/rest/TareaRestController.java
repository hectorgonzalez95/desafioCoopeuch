package com.hector.desafioCoopeuch.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hector.desafioCoopeuch.modelo.ListadoTareas;
import com.hector.desafioCoopeuch.modelo.ResponseDto;
import com.hector.desafioCoopeuch.modelo.Responses;
import com.hector.desafioCoopeuch.modelo.Tarea;
import com.hector.desafioCoopeuch.services.TareaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "tarea-controller", produces = MediaType.APPLICATION_JSON_VALUE)
public class TareaRestController {
	
	private static Logger logger = LogManager.getLogger(TareaRestController.class);
	
	@Autowired
	TareaService tareaService;
	
	@ApiOperation(value = "Obtiene un listado de tareas", notes = "Obtiene un establecimiento de educacion por RBD")
	@GetMapping(value = "/obtener-tareas", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 204, message = "No se encuentran tareas"),
			@ApiResponse(code = 200, message = "Tareas encontradas", response = Tarea.class) })
	public ResponseEntity<List<ListadoTareas>> obtieneTareas() {
				
		ResponseDto dto = tareaService.obtieneTareas();
		if (!dto.isTieneErrores()) {
			logger.info("obtiene tareas exitoso");
			return Responses.ok(dto.getTareas());
		} else {			
			return Responses.noContent(null);
		}
	}
	
	
	@ApiOperation(value = "Agrega una tarea", notes = "Recibe una solicitud de firma de un documento")
	@ApiResponses({ 
		@ApiResponse(code = 201, message = "Tarea Ingresada Exitosamente", response = Tarea.class),
		@ApiResponse(code = 409, message = "No se pudo Ingresar la tarea", response = HttpStatus.class),
		})
	@PostMapping(value = "/agregar-tarea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tarea> agregarTarea(
			@ApiParam(defaultValue="", name = "descripcion", value = "descripcion de la tarea", required = true) @RequestParam(defaultValue="", required = false) String descripcion,
			@ApiParam(defaultValue="", name = "fecha", value = "fecha de creación dd-MM-yyyy", required = true) @RequestParam(defaultValue="", required = false) String fecha,
			@ApiParam(defaultValue="", name = "vigente", value = "Vigencia de la tarea", required = true) @RequestParam(defaultValue="", required = false) Boolean vigente){		
		
		Tarea tarea = new Tarea();
		tarea.setDescripcion(descripcion);
		tarea.setStrFecha(fecha);
		tarea.setVigente(vigente);
		tareaService.agregarTarea(tarea);		
		return Responses.created(tarea);
	}
	
	
	@ApiOperation(value = "Editar tarea.", notes="Edita tarea por id.")
	@ApiResponses({ 
		@ApiResponse(code = 204, message = "Solicitud a editar no encontrada", response = HttpStatus.class),
		@ApiResponse(code = 200, message = "Solicitud a editar Exitosa", response = Tarea.class),
		@ApiResponse(code = 409, message = "No se logro editar la tarea.", response = HttpStatus.class)
		})	
	@PutMapping(value = "/editar-tarea", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Tarea> editarTarea(
			@ApiParam(defaultValue="", name = "id", value = "ID de la tarea", required = true) @RequestParam(defaultValue="", required = false) Integer id,
			@ApiParam(defaultValue="", name = "descripcion", value = "descripcion de la tarea", required = true) @RequestParam(defaultValue="", required = false) String descripcion,
			@ApiParam(defaultValue="", name = "fecha", value = "fecha de creación dd-MM-yyyy", required = true) @RequestParam(defaultValue="", required = false) String fecha,
			@ApiParam(defaultValue="", name = "vigente", value = "Vigencia de la tarea", required = true) @RequestParam(defaultValue="", required = false) Boolean vigente){		
		
		Tarea tarea = new Tarea();
		tarea.setId(id);
		tarea.setDescripcion(descripcion);
		tarea.setStrFecha(fecha);
		tarea.setVigente(vigente);	
		boolean tieneError = tareaService.editarTarea(tarea);
		if(!tieneError) {
			return Responses.ok(tarea);			
		}else {
			return Responses.noContent(null);
		}
				
		
	}

}
