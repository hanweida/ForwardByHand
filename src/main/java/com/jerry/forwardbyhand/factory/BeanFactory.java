package com.jerry.forwardbyhand.factory;

public interface BeanFactory {
    Object getBean(String beanName);

    void addBeanFactoryProcessor(BeanFactoryProcessor beanFactoryProcessor);
}
