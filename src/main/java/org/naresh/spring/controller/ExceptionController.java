package org.naresh.spring.controller;

import org.json.JSONException;
import org.naresh.spring.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage InvalidRequestHandler(MethodArgumentNotValidException e){
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMsg.setStatusMsg("Internerl Server Error");
		return errorMsg;
	}
	
	@ExceptionHandler(JSONException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage InvalidRequestHandler(JSONException e){
		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMsg.setStatusMsg("Internerl Server Error");
		return errorMsg;
	}
}
