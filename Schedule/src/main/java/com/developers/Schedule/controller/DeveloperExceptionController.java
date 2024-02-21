package com.developers.Schedule.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class DeveloperExceptionController {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String nullPointerException(NullPointerException exception) {
        log.error(exception.getMessage());
        return "The object you are looking for does not exist.";
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String noSuchElementException(NoSuchElementException exception) {
        log.error(exception.getMessage());
        return "Please verify that the element you are looking for exist.";
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String mismatchException(MethodArgumentTypeMismatchException exception) {
        log.error(exception.getMessage());
        return "Please verify if the endpoint is correct.";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noResourceFoundException(NoResourceFoundException exception) {
        log.error(exception.getMessage());
        return "Please verify if the endpoint is correct.";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(Exception exception) {
        log.error(exception.getMessage());
        return exception.getMessage();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String methodNotAllowed(HttpRequestMethodNotSupportedException exception) {
        log.error(exception.getMessage());
        return "Method not supported.";
    }
}
