package com.jerry.c3p0datasource.service;

import com.jerry.c3p0datasource.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testMapper;


    @Override
    public Integer testSelect() {
        return testMapper.testSelect();
    }
}
