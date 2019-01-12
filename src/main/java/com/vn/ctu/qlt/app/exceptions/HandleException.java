package com.vn.ctu.qlt.app.exceptions;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author NTDSIVAL
 * @Date Dec 27, 2018
 */

@ControllerAdvice
@RestController
public class HandleException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { UserExitException.class })
	protected ResponseEntity<ErrorDetails> handleConflict(Exception ex) {
		return ResponseEntity.badRequest().body(new ErrorDetails(new Date(), "User exists", ex.getMessage()));
	}
}
