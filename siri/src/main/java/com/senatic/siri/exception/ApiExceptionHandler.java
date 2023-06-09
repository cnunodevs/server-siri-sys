package com.senatic.siri.exception;

import java.time.DateTimeException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler({DateTimeException.class, IllegalArgumentException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public void genericExceptionHandler(DateTimeException dateTimeException, IllegalArgumentException illegalArgEx){
        logger.error(dateTimeException.getMessage());
        logger.error(illegalArgEx.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public void genericExceptionHandler(Exception exception){
        logger.error(exception.getMessage());
    }

    
}
