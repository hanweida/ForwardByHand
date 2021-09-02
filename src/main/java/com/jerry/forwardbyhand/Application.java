package com.jerry.forwardbyhand;

public class Application {
    public static void main(String[] args) {
        //1. 获得一个BeanFactory 的实例（这个实例不需要 管理）
        //2. 添加 BeanFactoryPostProcessor (BeanFactory 的后置处理器，对bean标签处理)【通过 registry 注册 BeanFactoryPostProcessor】
        //3. 加载bean标签？
        //4. 加载完也得 BeanFactoryPostProcessor 处理 beanDefiniton 【通过 registry 注册 BeanPostProcessor】
        //5. 初始化bean（对bean 生命周期的处理）
        //6. 对bean 的 BeanPostProcessor 处理
    }
}
