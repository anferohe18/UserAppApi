package com.applaudo.andres.userManagementApp.controller.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse,errorResponse.getStatus());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object>handleEntityNotFoundException(HttpServletRequest req, EntityNotFoundException ex){
        String error = "We could not find a user with the given email " + ex.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST,error));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object>handleUserWithTheSameEmail(HttpServletRequest req,DataIntegrityViolationException  ex){
        String error = "try with another email " + ex.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT,error));
    }

}
