package com.sanwei.common.exception.user;

/**
 * @Author：SatanCY
 * @Date：2025/1/22 17:06
 */
public class UserPasswordNotMatchException extends UserException {
    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
