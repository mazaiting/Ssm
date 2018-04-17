package com.mazaiting.exception;

/**
 * 自定义异常
 * @author mazaiting
 */
public class CustomerException extends Exception{
	private String msg;

	public CustomerException() {}
	public CustomerException(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
