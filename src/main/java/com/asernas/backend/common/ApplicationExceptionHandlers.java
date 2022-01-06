package com.asernas.backend.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.asernas.backend.api.ApiResponseBody;

@ControllerAdvice
public class ApplicationExceptionHandlers {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValid(HttpServletRequest httpRequest, Exception ex) {
        ApiResponseBody responseBody = new ApiResponseBody();
        return new ResponseEntity<>(responseBody.setMessage("Parámetros de entrada incorrectos"), HttpStatus.BAD_REQUEST);
    }


}
