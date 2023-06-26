package com.jbk.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> methodArgumentNotValidException( MethodArgumentNotValidException ex) {
	HashMap<String , String> map=new HashMap<>();
	
	BindingResult bindingResult = ex.getBindingResult();
	
	List<FieldError> fieldErrors = bindingResult.getFieldErrors();
	
	for (FieldError fieldError : fieldErrors) {
		map.put(fieldError.getField(), fieldError.getDefaultMessage());
	}
	
	return map;
	
	}
	
	@ExceptionHandler(ProductAlreadyExistsException.class)
	//@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String productAlreadyExistsException(ProductAlreadyExistsException ex){
		
		return ex.getMessage();
	}
	
	@ExceptionHandler(ProductNotExistsException.class)
	//@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String productNotExistsException(ProductNotExistsException ex){
		
		return ex.getMessage();
	}


}
