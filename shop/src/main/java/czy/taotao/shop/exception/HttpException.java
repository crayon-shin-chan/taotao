package czy.taotao.shop.exception;

import java.lang.Exception;

public class HttpException extends Exception {

	private Result result;

	public HttpException(int code, String msg) {
		super();
		this.result = new Result(code,msg);
	}

	public Result getResult(){
		return this.result;
	}
	
	public class Result{
		private int code;
		private String message;

		Result(int code,String message){
			this.code = code;
			this.message = message;
		}

		public synchronized int getCode() {
			return code;
		}

		public synchronized void setCode(int code) {
			this.code = code;
		}

		public synchronized String getMessage() {
			return message;
		}

		public synchronized void setMessage(String message) {
			this.message = message;
		}
	}

}
