package com.example.demo.exceptions;

public class InvalidRequestBodyException extends RuntimeException {

    public InvalidRequestBodyException(String message){
        super(message);
    }
}
