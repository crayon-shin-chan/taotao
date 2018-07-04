package czy.taotao.shop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import czy.taotao.shop.exception.HttpException;

@ControllerAdvice
public class ShopControllerAdvice {

	@ExceptionHandler(HttpException.class)
	public ResponseEntity<String> handleHttpException(HttpException ex) {
		System.out.println("接收到异常通知");
		return new ResponseEntity<String>(ex.getMsg(), ex.getStatus());
		
	}

}
