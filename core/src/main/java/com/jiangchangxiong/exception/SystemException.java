package com.jiangchangxiong.exception;

import lombok.Getter;

/**
 * The exception for System！
 *
 * @author Jiang
 * @since  2023-03-02
 */
@Getter
public class SystemException extends IException{

    private String message;

    public SystemException(String message) {
        this.message = message;
    }

}


