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
			System.out.println(ex.getMessage());
			System.out.println("异常处理器接收到异常：");
			System.out.println(ex.toString());
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	
}
