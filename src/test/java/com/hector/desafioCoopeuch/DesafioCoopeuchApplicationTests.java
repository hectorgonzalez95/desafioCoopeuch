package com.hector.desafioCoopeuch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hector.desafioCoopeuch.modelo.Tarea;
import com.hector.desafioCoopeuch.repositorio.TareaRepositorio;
import com.hector.desafioCoopeuch.services.TareaService;

@ExtendWith(SpringExtension.class)
class DesafioCoopeuchApplicationTests {
	
	@InjectMocks private TareaService tareaService;
	@Mock private TareaRepositorio tareaRepositorio;	
	
//    @Test
//    @DisplayName("Se agrega tarea exitosamente")
//	public void agregarTareaExito() {
//    	Tarea tarea = new Tarea();
//    	tarea.setDescripcion("descripcion");
//    	tarea.setStrFecha("10-10-2020");
//    	tarea.setVigente(true);
//    	doNothing().when(tareaRepositorio).agregarTarea(tarea);
//    	boolean tieneErrores = tareaService.agregarTarea(tarea);
//    	assertFalse(tieneErrores);
//	}
    
//    @Test
//    @DisplayName("No Se agrega la tarea")
//	public void agregarTareaFracaso() {
//    	Tarea tarea = new Tarea();
//    	tarea.setDescripcion("descripcion");
//    	tarea.setStrFecha("2020-10-13");
//    	tarea.setVigente(true);
//    	doNothing().when(tareaRepositorio).agregarTarea(tarea);
//    	boolean tieneErrores = tareaService.agregarTarea(tarea);
//    	assertTrue(tieneErrores);
//	}
    
    @Test
    @DisplayName("Se edita tarea exitosamente")
	public void editarTareaExito() {
    	Tarea tarea = new Tarea();
    	tarea.setDescripcion("descripcion");
    	tarea.setStrFecha("10-10-2020");
    	tarea.setVigente(true);
    	tarea.setId(1);
    	doNothing().when(tareaRepositorio).editarTarea(tarea);
    	boolean tieneErrores = tareaService.editarTarea(tarea);
    	assertFalse(tieneErrores);    	
	}
    
//    @Test
//    @DisplayName("No se edita la tarea")
//	public void editarTareaFracaso() {
//    	Tarea tarea = new Tarea();
//    	tarea.setDescripcion("descripcion");
//    	tarea.setStrFecha("2020-10-13");
//    	tarea.setVigente(true);
//    	doNothing().when(tareaRepositorio).agregarTarea(tarea);
//    	boolean tieneErrores = tareaService.agregarTarea(tarea);
//    	assertTrue(tieneErrores);
//	}
//
    

}
