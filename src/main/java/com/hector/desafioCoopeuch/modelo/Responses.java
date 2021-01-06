package com.hector.desafioCoopeuch.modelo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Responses {
	public static <T> ResponseEntity<T> ok(T model) {
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	public static <T> ResponseEntity<T> noContent(T model) {
		return new ResponseEntity<>(model, HttpStatus.NO_CONTENT);
	}
	
	public static <T> ResponseEntity<T> created(T model) {
		return new ResponseEntity<>(model, HttpStatus.CREATED);
	}
	
	public static <T> ResponseEntity<T> conflict(T model) {
		return new ResponseEntity<>(model, HttpStatus.CONFLICT);
	}
}