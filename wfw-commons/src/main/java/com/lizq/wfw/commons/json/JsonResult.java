package com.lizq.wfw.commons.json;

import java.io.Serializable;

/**
 * 请求响应的数据
 * @author Ghappier
 *
 */
public class JsonResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 响应状态，成功或失败
	 */
	private boolean success;
	
	/**
	 * 失败或成功的提示信息
	 */
	//@JSONField(serialize=false)
	private String msg;
	
	/**
	 * 请求成功返回的数据
	 */
	private T data;

	public JsonResult() {
		super();
		this.success = true;
		this.msg = "请求成功";
	}
	
	public JsonResult<T> success() {
		this.success = true;
		return this;
	}
	public JsonResult<T> fail() {
		this.success = false;
		return this;
	}
	public JsonResult<T> msg(String msg) {
		this.msg = msg;
		return this;
	}
	public JsonResult<T> data(T data) {
		this.data = data;
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}
}
