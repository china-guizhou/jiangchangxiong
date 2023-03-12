package com.jiangchangxiong.common;

import com.jiangchangxiong.constants.ApiCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class R<T> {

	private int code;

	private String message;

	private Long timestamp;

	private T data;

	public R() {
		this.code = ApiCode.SUCCESS.code();
		this.message = ApiCode.SUCCESS.message();
		this.timestamp = System.currentTimeMillis();
	}

	public R(ApiCode apiCode) {
		this.code = apiCode.code();
		this.message = apiCode.message();
		this.timestamp = System.currentTimeMillis();
	}

	public R(T data) {
		this();
		this.data = data;
	}

	public static <T> R<T> success(T data) {
		return new R<>(data);
	}

	public static R<?> guess(ApiCode apiCode) {
		return new R<>(apiCode);
	}

}
