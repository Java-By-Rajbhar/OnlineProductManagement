package com.product.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Sushil
 *
 */
@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseError> invalidExceptionHandler(Exception ex)
	{
		ResponseError error =  new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
	}
	

	

}