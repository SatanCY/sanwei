package com.sanwei.common.utils;

import com.sanwei.common.utils.spring.SpringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;


/**
 * @Author：SatanCY
 * @Date：2025/1/22 16:22
 */
public class MessageUtils {

    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        // 从当前线程的上下文中获取当前的 Locale    Locale 是用来表示语言和地区的对象
        return messageSource.getMessage(code,args, LocaleContextHolder.getLocale());
    }
}
