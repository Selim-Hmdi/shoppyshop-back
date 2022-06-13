package com.groupe8.ShoppyShop.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> HandleAllExceptions(HttpServletRequest req, Exception ex) {
	        ErrorResponse errorResponse = new ErrorResponse();
	        errorResponse.setErrorCode("Technical Error");
	        errorResponse.setErrorMessage(ex.getMessage());
	        errorResponse.setRequestURL(req.getRequestURL().toString());
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorResponse> ResourceNotFoundError(HttpServletRequest req, ResourceNotFoundException ex) {
	        ErrorResponse errorResponse = new ErrorResponse();
	        errorResponse.setErrorMessage(ex.getMessage());
	        errorResponse.setRequestURL(req.getRequestURL().toString());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }


	    @ExceptionHandler(BadArgumentException.class)
	    public ResponseEntity<ErrorResponse> BadArgumentError(HttpServletRequest req, BadArgumentException ex) {
	        ErrorResponse errorResponse = new ErrorResponse();
	        errorResponse.setErrorMessage(ex.getMessage());
	        errorResponse.setRequestURL(req.getRequestURL().toString());
	        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	    }
}
