package com.jiangchangxiong.exception;

import lombok.Getter;

/**
 * @author Jiang
 * @since 2023-03-12
 */
@Getter
public class LoginFailureException extends BusinessException {

    public LoginFailureException(String message) {
        super(message);

    }

}
