package com.myblog5.myblog5.exception;

import com.myblog5.myblog5.payload.ErrorDetailes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailes> handleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest) {
        ErrorDetailes errorDetailes = new ErrorDetailes(
                e.getMessage(), new Date(), webRequest.getDescription(true)
        );
        return new ResponseEntity<>(errorDetailes, HttpStatus.OK);
    }
}
