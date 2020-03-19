package com.infrrd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infrrd.entity.ErrorMessage;

@RestControllerAdvice
public class ProductExceptionHandlerClass {
	
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
