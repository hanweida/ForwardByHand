package com.jerry.c3p0datasource;

import com.jerry.c3p0datasource.example.TestServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Autowired
    TestServiceImple testServiceImple;

    @Override
    public void run(ApplicationArguments var1) throws Exception{
        System.out.println("MyApplicationRunner class will be execute when the project was started!");
        testServiceImple.invoke();
    }
}
