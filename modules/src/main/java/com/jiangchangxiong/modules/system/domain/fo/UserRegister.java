package com.jiangchangxiong.modules.system.domain.fo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户注册需要提供的表单数据
 *
 * @since Mar 8, 2023
 * @author jiangchangxiong
 */
@Getter
@Setter
public class UserRegister implements Serializable {

	private static final long serialVersionUID = -2481836682503180971L;

	private String phone;

	private String email;

}
