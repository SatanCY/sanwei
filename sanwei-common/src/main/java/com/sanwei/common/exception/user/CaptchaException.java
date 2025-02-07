package com.sanwei.common.exception.user;

/**
 * @Author：SatanCY
 * @Date：2025/1/22 16:53
 */
public class CaptchaException extends UserException {

    public CaptchaException() {
        super("user.jcaptcha.error",null);
    }
}
