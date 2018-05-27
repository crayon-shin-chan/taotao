package czy.taotao.shop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import czy.taotao.shop.exception.HttpException;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ControllerExceptionHandler {
	
		private static HttpHeaders headers = new HttpHeaders();
		
		static {
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set(HttpHeaders.CONTENT_ENCODING,"utf8");
		}

		@ExceptionHandler(HttpException.class)
		public  ResponseEntity<HttpException.Result> handlerHttpException(HttpException ex){
			return new ResponseEntity<HttpException.Result>(ex.getResult(),headers,HttpStatus.BAD_REQUEST);
		}
	
}
