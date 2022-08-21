package com.example.snakeLadder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SnakeLadderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnakeLadderApplication.class, args);
    }

}
