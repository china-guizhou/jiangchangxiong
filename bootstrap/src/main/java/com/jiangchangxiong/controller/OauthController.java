package com.jiangchangxiong.controller;

import cn.hutool.core.lang.UUID;
import com.jiangchangxiong.domain.CodeForm;
import com.jiangchangxiong.domain.CodeResult;
import com.jiangchangxiong.domain.LoginResult;
import com.jiangchangxiong.domain.LoginForm;
import org.springframework.web.bind.annotation.GetMapping;
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
	public R<LoginResult> login(@RequestBody LoginForm form) {
		StpUtil.login(form.getAccount());
		LoginResult result = new LoginResult();
		result.setToken(StpUtil.getTokenValue());
		return R.success(result);
	}

	/**
	 * 获取验证码
	 *
	 * @param form
	 * @return
	 */
	@PostMapping("/code")
	public R<CodeResult> code(@RequestBody CodeForm form) {
		CodeResult result = new CodeResult();
		result.setKey(UUID.randomUUID().toString());
		return R.success(result);
	}

	/**
	 * 获取验证码
	 *
	 * @return
	 */
	@GetMapping("/logout")
	public R<Boolean> logout() {
		// TODO: 清除登录数据
		return R.success(true);
	}

}
