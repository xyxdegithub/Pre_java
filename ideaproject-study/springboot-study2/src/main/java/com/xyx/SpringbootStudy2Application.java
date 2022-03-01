package com.xyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xyx.mapper")
public class SpringbootStudy2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudy2Application.class, args);
    }

}
