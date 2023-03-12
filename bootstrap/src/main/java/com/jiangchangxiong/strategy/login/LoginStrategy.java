package com.jiangchangxiong.strategy.login;

import com.jiangchangxiong.common.LoginForm;
import com.jiangchangxiong.common.LoginResult;
import com.jiangchangxiong.exception.LoginFailureException;

/**
 * 登录策略接口
 *
 * @author Jiang
 * @since  2023-03-12
 */
public interface LoginStrategy {

    /**
     * 登录接口
     *
     * @param form 登录数据表单
     * @return
     */
    LoginResult login(LoginForm form) throws LoginFailureException;

}
