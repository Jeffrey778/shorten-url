package com.demo.shortenurl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.shortenurl.mapper")
public class ShortenUrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortenUrlApplication.class, args);
    }
}
