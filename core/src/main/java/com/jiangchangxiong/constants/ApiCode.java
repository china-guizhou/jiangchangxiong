package com.jiangchangxiong.constants;

/**
 * API返回码 可以将描述接入国际化
 *
 * @since Mar 12, 2023
 * @author jiangchangxiong
 */
public enum ApiCode {

	SUCCESS(20000, "成功"),

	;

	private int code;

	private String message;

	ApiCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int code() {
		return code;
	}

	public String message() {
		return message;
	}
}
