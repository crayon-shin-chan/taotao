package czy.taotao.shop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import czy.taotao.shop.exception.HttpException;


@ControllerAdvice
public class ControllerExceptionHandler {

		@ExceptionHandler(HttpException.class)
		public  ResponseEntity<String> handlerHttpException(HttpException ex){
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	
}
