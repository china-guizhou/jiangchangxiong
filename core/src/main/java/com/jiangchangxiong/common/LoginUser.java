package com.jiangchangxiong.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录的用户使用这个类进行信息封装
 *
 * @since Mar 6, 2023
 * @author jiangchangxiong
 */
@Getter
@Setter
public class LoginUser {

	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	private String account;

	private String name;

	private String alias;

}
