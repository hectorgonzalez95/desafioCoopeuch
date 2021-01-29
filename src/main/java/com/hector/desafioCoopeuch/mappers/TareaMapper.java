package com.hector.desafioCoopeuch.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hector.desafioCoopeuch.modelo.ListadoTareas;
import com.hector.desafioCoopeuch.modelo.Tarea;

@Mapper
public interface TareaMapper {

	void agregarTarea(Tarea tarea);

	void editarTarea(Tarea tarea);

	List<Tarea> obtieneTareas();

}
