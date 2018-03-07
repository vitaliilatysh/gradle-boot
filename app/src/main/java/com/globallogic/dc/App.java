package com.globallogic.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.globallogic.dc.config")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
