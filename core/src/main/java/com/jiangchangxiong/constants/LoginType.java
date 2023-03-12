package com.jiangchangxiong.constants;

/**
 * 登录类型
 *
 * @author Jiang
 * @since  2023-03-12
 */
public interface LoginType {

    String PASSWORD = "PASSWORD";

    String WECHAT = "WECHAT";

    String QRCODE = "QRCODE";

    /** 手机验证码 */
    String PHONE = "PHONE";

    /** 邮箱验证码 */
    String EMAIL = "EMAIL";

    /** 单点登录 */
    String SSO = "SSO";

}
