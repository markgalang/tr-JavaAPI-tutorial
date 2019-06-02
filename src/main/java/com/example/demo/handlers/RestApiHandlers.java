package com.example.demo.handlers;

import com.example.demo.exceptions.InvalidRequestBodyException;
import com.example.demo.pojo.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestApiHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity notFoundHandler(Exception ex){
        return ResponseEntity.status(404).body(ApiResponse.builder()
                .code(404).status("NOT FOUND").message(ex.getMessage()).build());
    }

    @ExceptionHandler({InvalidRequestBodyException.class})
    public ResponseEntity unprocessableEntityHandler (Exception ex){
        return ResponseEntity.status(422).body(ApiResponse.builder()
                .code(422).status("UNPROCESSABLE ENTITY").message(ex.getMessage()).build());
    }
}
