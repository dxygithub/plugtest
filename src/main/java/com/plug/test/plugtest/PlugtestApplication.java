package com.plug.test.plugtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.plug.test.plugtest.mapper")
@SpringBootApplication
public class PlugtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlugtestApplication.class, args);
    }

}
