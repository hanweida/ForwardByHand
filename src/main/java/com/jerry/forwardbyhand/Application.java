package com.jerry.forwardbyhand;

import com.jerry.forwardbyhand.bean.DefaultBeanFactory;
import com.jerry.forwardbyhand.context.AbstactApplicationContext;
import com.jerry.forwardbyhand.factory.BeanFactory;
import com.jerry.forwardbyhand.factory.BeanFactoryProcessor;
import com.jerry.forwardbyhand.factory.ScannerProcessor;
import com.jerry.forwardbyhand.registry.BeanFactoryPostProcessorRegistry;

public class Application {
    public static void main(String[] args) {
        //1. 获得一个BeanFactory 的实例（这个实例不需要 管理）
        AbstactApplicationContext abstactApplicationContext = new AbstactApplicationContext();
        //可以在内部生成
        BeanFactory defaultBeanFactory = new DefaultBeanFactory();
        abstactApplicationContext.setBeanFactory(defaultBeanFactory);

        //2. 添加 BeanFactoryPostProcessorRegistry (BeanFactory 的后置处理器，对bean标签处理)【通过 registry 注册 BeanFactoryPostProcessorRegistry】
        BeanFactoryProcessor beanFactoryProcessor = new ScannerProcessor();
        BeanFactoryPostProcessorRegistry beanFactoryPostProcessorRegistry = new BeanFactoryPostProcessorRegistry(defaultBeanFactory);
        beanFactoryPostProcessorRegistry.registry(beanFactoryProcessor);

        //3. 加载bean标签？
        //4. 加载完也得 BeanFactoryPostProcessorRegistry 处理 beanDefiniton 【通过 registry 注册 BeanPostProcessor】
        //5. 初始化bean（对bean 生命周期的处理）
        //6. 对bean 的 BeanPostProcessor 处理
    }
}
