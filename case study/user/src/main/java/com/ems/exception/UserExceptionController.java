package com.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(value = InvalidRegistrationException.class)
    public ResponseEntity<Object> registrationException(InvalidRegistrationException exception) {
        return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundException(UserNotFoundException exception){
        return new ResponseEntity<>("User doesn't exist with this userName", HttpStatus.NOT_FOUND);
    }
}

