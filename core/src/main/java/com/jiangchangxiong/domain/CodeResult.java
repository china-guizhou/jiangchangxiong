package com.jiangchangxiong.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jiang
 * @since 2023-03-13
 */
@Getter
@Setter
public class CodeResult {

    private String key;

    /** 图片验证码 */
    private String img;

}
