package com.jiangchangxiong.strategy.login;

import com.jiangchangxiong.domain.LoginForm;
import com.jiangchangxiong.domain.LoginResult;
import com.jiangchangxiong.exception.LoginFailureException;

/**
 * @author Jiang
 * @since  2023-03-12
 */
public class WechatStrategy implements LoginStrategy {
    @Override
    public LoginResult login(LoginForm form) throws LoginFailureException {
        return null;
    }
}
