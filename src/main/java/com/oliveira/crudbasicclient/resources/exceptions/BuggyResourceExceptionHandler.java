package com.oliveira.crudbasicclient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.oliveira.crudbasicclient.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class BuggyResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> duplicatedResourceNotFoundHandler(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setError("Duplicated resource not found handler");
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setPath(request.getRequestURI());
        err.setMessage(e.getMessage());

        return ResponseEntity.status(err.getStatus()).body(err);
    }
}
