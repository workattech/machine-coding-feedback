package com.example.snakeLadder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SnakeLadderMain {

    public static void main(String[] args) {
        SpringApplication.run(SnakeLadderMain.class, args);
    }

}
