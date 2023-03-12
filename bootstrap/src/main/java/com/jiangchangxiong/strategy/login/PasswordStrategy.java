package com.jiangchangxiong.strategy.login;

import com.jiangchangxiong.common.LoginForm;
import com.jiangchangxiong.common.LoginResult;
import com.jiangchangxiong.exception.LoginFailureException;

/**
 * @author Jiang
 * @since  2023-03-12
 */
public class PasswordStrategy implements LoginStrategy {

    @Override
    public LoginResult login(LoginForm form) throws LoginFailureException {
        return null;
    }

}
