package co.za.myprofileservice.exceptions.advice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import co.za.myprofileservice.data.ErrorResponse;


@RestControllerAdvice
public class CustomExcetionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	public ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException invalidMethodArgumentException, 
			                                                             HttpHeaders headers, HttpStatus httpStatus, WebRequest request){
		
		List<String> details = new ArrayList<>();
		for(ObjectError errors : invalidMethodArgumentException.getBindingResult().getAllErrors()) {
			details.add(errors.getDefaultMessage());

		}
		httpStatus = HttpStatus.BAD_REQUEST;
		ErrorResponse errorResponse = new ErrorResponse("Invalid arguments", details, LocalDateTime.now());
		return new ResponseEntity<Object>(errorResponse, httpStatus);
	}
	

}
