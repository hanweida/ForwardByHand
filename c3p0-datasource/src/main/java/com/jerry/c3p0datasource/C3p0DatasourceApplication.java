package com.jerry.c3p0datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.jerry.c3p0datasource.mapper")
@EnableAsync
public class C3p0DatasourceApplication {

    public static void main(String[] args) {

        SpringApplication.run(C3p0DatasourceApplication.class, args);
    }

}
