package com.jerry.forwardbyhand.registry;

import com.jerry.forwardbyhand.factory.BeanFactory;
import com.jerry.forwardbyhand.factory.BeanFactoryProcessor;

public class BeanFactoryPostProcessorRegistry {
    private BeanFactory beanFactory;

    public BeanFactoryPostProcessorRegistry(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void registry(BeanFactoryProcessor beanFactoryProcessor){
        this.beanFactory.addBeanFactoryProcessor(beanFactoryProcessor);
    }
}
