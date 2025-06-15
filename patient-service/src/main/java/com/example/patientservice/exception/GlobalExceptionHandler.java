package com.example.patientservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    // exception call when validate fields fail
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(error
                        -> errors.put(error.getDefaultMessage(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
    // exception call when email already exist
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleEmailAlreadyExistsException(
            EmailAlreadyExistsException ex
    ){
        log.warn("Email address already exists {}",ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email address already exists");
        return ResponseEntity.badRequest().body(errors);
    }
    // exception call when patient not found
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlePatientNotFoundException(
            PatientNotFoundException ex
    ){
        log.warn("Patient not found {}",ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Patient not found");
        return ResponseEntity.badRequest().body(errors);
    }
}
