package com.infrrd.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infrrd.entity.ErrorMessage;

@RestControllerAdvice
public class ProductExceptionHandlerClass {
	//this is for validation error 
	@ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorMessage> handleGlobalExceptions(MethodArgumentNotValidException ex) {
		String response=ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMessage(response);
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
	public String allException(){
		return HttpStatus.BAD_REQUEST.toString() ;
		
	}
	
	
	@ExceptionHandler(NoSuchRecordException.class)
	public ResponseEntity<ErrorMessage> deleteProdudct(NoSuchRecordException ex){
		
		ErrorMessage msg=new ErrorMessage();
		msg.setErrorCode(404);
		msg.setErrorMessage("record is not present");
		return new ResponseEntity<ErrorMessage>(msg, HttpStatus.BAD_REQUEST);
		
	}

}
