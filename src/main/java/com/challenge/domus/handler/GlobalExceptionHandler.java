package com.challenge.domus.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.challenge.domus.exception.BadRequestException;
import com.challenge.domus.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Void> badRequestHandler(BadRequestException bre) {
		LOGGER.error("badRequestHandler - message {}", bre.getMessage());
		return ResponseEntity.badRequest().build();
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> notFoundExceptionHandler(NotFoundException nfe) {
		LOGGER.error("notFoundExceptionHandler - message: {}", nfe.getMessage());
		return ResponseEntity.notFound().build();
	}

}