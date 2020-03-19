package com.infrrd.exception;

import org.apache.logging.log4j.message.Message;

public class NoSuchRecordException extends Exception {
	
	public NoSuchRecordException() {
		super();
	}
	
	public NoSuchRecordException(String msg){
		super(msg);
	}
	

}
