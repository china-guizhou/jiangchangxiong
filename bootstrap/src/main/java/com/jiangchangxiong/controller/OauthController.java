package com.jiangchangxiong.controller;

import com.jiangchangxiong.common.LoginResult;
import com.jiangchangxiong.common.LoginForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiangchangxiong.common.R;

import cn.dev33.satoken.stp.StpUtil;

/**
 * 认证授权controller
 * 
 * @since Mar 12, 2023
 * @author jiangchangxiong
 */
@RestController
@RequestMapping("/oauth")
public class OauthController {

	@PostMapping("/login")
	public R<LoginResult> login(@RequestBody LoginForm user) {
		StpUtil.login(user.getAccount());
		LoginResult result = new LoginResult();
		result.setToken(StpUtil.getTokenValue());
		return R.success(result);
	}

}
