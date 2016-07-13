package com.example.administrator.day7.data;

public class MyResponse {

	public String code;

	public String msg;

	public void destroy() {
		code = null;
		msg = null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
