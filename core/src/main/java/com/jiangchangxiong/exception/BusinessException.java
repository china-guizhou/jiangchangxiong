package com.jiangchangxiong.exception;

import lombok.Getter;

/**
 * The exception for Business！
 *
 * @author Jiang
 * @since  2023-03-02
 */
@Getter
public class BusinessException extends IException{

    private String message;

    public BusinessException(String message) {
        this.message = message;
    }

}
