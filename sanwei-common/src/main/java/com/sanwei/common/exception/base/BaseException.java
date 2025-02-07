package com.sanwei.common.exception.base;

import com.sanwei.common.utils.MessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

/**
 * @Author：SatanCY
 * @Date：2025/1/22 16:09
 */
public class BaseException extends RuntimeException {
    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args) {
        this.module = module;
        this.code = code;
        this.args = args;
    }

    public BaseException(String module, String defaultMessage) {
        this.module = module;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String code, Object[] args) {
        this.code = code;
        this.args = args;
    }

    public BaseException(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code)) {
            message = MessageUtils.message(code, args);
        }
        if (message==null) {
            message = defaultMessage;
        }
        return message;
    }

    public String getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
