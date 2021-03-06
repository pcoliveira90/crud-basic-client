package com.oliveira.crudbasicclient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.oliveira.crudbasicclient.services.exceptions.DataBaseException;
import com.oliveira.crudbasicclient.services.exceptions.ResourceNotFoundException;
//issue #2
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound( ResourceNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setError("Resource not found");
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setPath(request.getRequestURI());
		err.setMessage(e.getMessage());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase( DataBaseException e, HttpServletRequest request){
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setError("Resource not found");
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setPath(request.getRequestURI());
		err.setMessage(e.getMessage());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
}
