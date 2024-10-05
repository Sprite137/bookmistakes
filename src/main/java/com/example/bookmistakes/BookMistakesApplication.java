package com.example.bookmistakes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bookmistakes.mapper")
public class BookMistakesApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookMistakesApplication.class, args);
    }

}
