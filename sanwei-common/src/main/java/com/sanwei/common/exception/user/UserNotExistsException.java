package com.sanwei.common.exception.user;

/**
 * @Author：SatanCY
 * @Date：2025/1/22 17:04
 */
public class UserNotExistsException extends UserException{
    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
