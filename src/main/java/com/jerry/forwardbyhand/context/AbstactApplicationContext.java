package com.jerry.forwardbyhand.context;

import com.jerry.forwardbyhand.factory.BeanFactory;

import java.util.HashMap;
import java.util.Map;

public class AbstactApplicationContext {
    Map<String, Object> singletonObjects = new HashMap<>();
    Map<String, Object> beanDefinitionMap = new HashMap<>();

    BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }
}
