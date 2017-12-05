package com.sks.learn.learnspringbootudemy.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sks.learn.learnspringbootudemy.util.LMSConstants;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHanlder extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity handleAllException(Exception ex, WebRequest request) {
		ExceptionResponse exResp = new ExceptionResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				ex.getMessage());
		return new ResponseEntity(exResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleAllException(NotFoundException ex, WebRequest request) {
		ExceptionResponse exResp = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage());
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AlreadyExistsException.class)
	public final ResponseEntity<Object> handleExistsException(AlreadyExistsException ex, WebRequest request) {
		ExceptionResponse exResp = new ExceptionResponse(new Date(), HttpStatus.BAD_REQUEST.toString(),
				ex.getMessage());
		return new ResponseEntity(exResp, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println(
				LMSConstants.CUSTOM_LOG_IDENTIFIER + "Request Validation Failed:: Method Argumanet is not valid");
		ExceptionResponse exResp = new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());
		return new ResponseEntity(exResp, HttpStatus.NOT_FOUND);
	}
}
