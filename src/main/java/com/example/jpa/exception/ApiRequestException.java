package com.example.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApiRequestException extends RuntimeException {
    
	public ApiRequestException() {
        super();
    }
	 
	    public ApiRequestException(String message) {
	        super(message);
	    }
	

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}