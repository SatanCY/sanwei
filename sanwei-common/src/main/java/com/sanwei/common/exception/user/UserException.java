package com.sanwei.common.exception.user;

import com.sanwei.common.exception.base.BaseException;

/**
 * @Author：SatanCY
 * @Date：2025/1/22 16:54
 */
public class UserException extends BaseException {

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
