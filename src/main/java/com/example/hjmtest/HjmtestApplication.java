package com.example.hjmtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.hjmtest.logic.dao")
public class HjmtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HjmtestApplication.class, args);
    }

}
