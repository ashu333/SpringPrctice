package com.springboot.demo.myspringapp.exceptionHandler;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.demo.myspringapp.customException.StudentException;
import com.springboot.demo.myspringapp.error.StudentError;

@ControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentError> handleException(StudentException ex){
		StudentError error = new StudentError();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentError> handleException(Exception ex){
		StudentError error = new StudentError();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentError>(error,HttpStatus.NOT_FOUND);
	}
}
