package com.NimapTest.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.NimapTest.entity.ErrorResponseEntity;



@ControllerAdvice
public class CategoryNotFoundAdvice {
	 @ExceptionHandler(CategoryNotFoundException.class)
	    public ResponseEntity<ErrorResponseEntity> handleCategoryNotFoundException(CategoryNotFoundException ex) {
	        ErrorResponseEntity errorResponse = new ErrorResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }

}
