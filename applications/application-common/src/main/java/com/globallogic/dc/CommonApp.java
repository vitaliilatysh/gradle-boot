package com.globallogic.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.globallogic.dc.config")
public class CommonApp {
    public static void main(String[] args) {
        SpringApplication.run(CommonApp.class, args);
    }
}
