package com.areshok.Autoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = ServiceException.class )
    public ResponseEntity<Object> handleServiceException(final ServiceException ex, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.valueOf(ex.getCode())).body(new ServiceExceptionDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ex.getDetails()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class )
    public ResponseEntity<Object> handleServiceException(final MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServiceExceptionDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null));
    }
}
