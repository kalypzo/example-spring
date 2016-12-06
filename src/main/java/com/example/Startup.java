package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup {

    private static final Logger LOG = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Startup.class, args);
    }
}
