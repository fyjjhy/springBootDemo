package com.example.demo.entity;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2019/4/22
 * @see com.example.demo.entity <br>
 * @since V1.0<br>
 */
public class ResultInfo<T> {

	private int code;

	private String message;

	private T body;

	public ResultInfo(int code, String message, T body) {
		this.code = code;
		this.message = message;
		this.body = body;
	}

	public ResultInfo(int code, String message) {
		this(code, message, null);
	}

	public ResultInfo(String message) {
		this(200, message, null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}
