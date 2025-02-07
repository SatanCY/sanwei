package com.sanwei.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author：SatanCY
 * @Date：2025/1/22 16:35
 */
@Component
public class SpringUtils implements BeanFactoryPostProcessor, ApplicationContextAware {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 运行时动态注册Bean
     */
    private static ConfigurableListableBeanFactory beanFactory;

    private static ApplicationContext applicationContext;


    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    public static <T> T getBean(Class<T> name) {
        return (T) beanFactory.getBean(name);
    }
}
