package com.food.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.UnexpectedTypeException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class AllExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
	
	
   @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(UnexpectedTypeException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage","Please Enter all value proper");
        return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(FoodNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage","Food is not present ");
        return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(MethodArgumentTypeMismatchException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage","please enter your values in numbers only ");
        return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(NumberFormatException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage","please enter number or String value");
        return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
    }	
    
    
    
    
}
