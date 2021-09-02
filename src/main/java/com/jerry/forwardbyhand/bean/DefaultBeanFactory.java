package com.jerry.forwardbyhand.bean;

import com.jerry.forwardbyhand.factory.BeanFactory;
import com.jerry.forwardbyhand.factory.BeanFactoryProcessor;

import java.util.ArrayList;
import java.util.List;

public class DefaultBeanFactory implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    private List<BeanFactoryProcessor> beanFactoryProcessors = new ArrayList<>();

    //处理beanDefinition
    void processBeanDefinition(){
        for(BeanFactoryProcessor beanFactoryProcessor : beanFactoryProcessors){
            beanFactoryProcessor.postProcessor();
        }
    }

    @Override
    public void addBeanFactoryProcessor(BeanFactoryProcessor beanFactoryProcessor){
        beanFactoryProcessors.add(beanFactoryProcessor);
    };
}
