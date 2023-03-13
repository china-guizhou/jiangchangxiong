package com.jiangchangxiong.strategy.login;

import com.jiangchangxiong.domain.LoginForm;
import com.jiangchangxiong.domain.LoginResult;
import com.jiangchangxiong.exception.LoginFailureException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Jiang
 * @since  2023-03-12
 */
@Component
@Scope("prototype")
public class PasswordStrategy implements LoginStrategy {

    @Override
    public LoginResult login(LoginForm form) throws LoginFailureException {
        return null;
    }

}
