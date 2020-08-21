package com.dn.leanredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class LeanredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeanredisApplication.class, args);
    }

}
