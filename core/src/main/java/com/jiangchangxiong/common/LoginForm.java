package com.jiangchangxiong.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录
 *
 * @since Mar 12, 2023
 * @author jiangchangxiong
 */
@Getter
@Setter
public class LoginForm {

	private String type;

	private String application;

	private String account;

	private String password;

	private String key;

	private String code;

}
