package com.jerry.c3p0datasource.example;

import com.jerry.c3p0datasource.mapper.TestMapper;
import com.jerry.c3p0datasource.service.TestService;
import com.jerry.c3p0datasource.service.TestServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class TestRunner {

    @Resource
    private TestRunner testRunner;

    @Resource
    private TestService testService;

    @Resource
    private TestMapper testMapper;

    @PostConstruct
    public void init() {
        testRunner.initTemplate();
    }

    public void initTemplate(){
        System.out.println("initTemplate");
        System.out.println("before testSelect");
        System.out.println(testService.testSelect());
        System.out.println("after testSelect");
    }
}
