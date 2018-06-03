package czy.taotao.shop.exception;

import java.lang.Exception;
import org.springframework.http.HttpStatus;

public class HttpException extends Exception{
	
	private String msg;
	private HttpStatus status;
	
	public HttpException(String msg,HttpStatus status){
		super();
		this.msg = msg;
		this.status = status;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	

}
