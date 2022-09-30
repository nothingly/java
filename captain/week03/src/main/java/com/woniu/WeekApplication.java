package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.woniu.mapper")
@SpringBootApplication
public class WeekApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeekApplication.class, args);
    }
}
