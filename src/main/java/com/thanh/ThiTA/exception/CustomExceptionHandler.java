package com.thanh.ThiTA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorRespone handlerNotFoundException(NotFoundException ex, WebRequest req){
        return new ErrorRespone(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(NotUniqueException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorRespone handlerNotUniqueException(NotUniqueException ex, WebRequest req){
        return new ErrorRespone(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
    }
}
