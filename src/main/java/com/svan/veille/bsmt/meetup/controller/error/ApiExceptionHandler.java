package com.svan.veille.bsmt.meetup.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiErrorResponse illegarArgumentHandler(IllegalArgumentException exception){
		ApiErrorResponse response = new ApiErrorResponse();
		response.setMessage(exception.getMessage());
		
		return response;
	}
}
