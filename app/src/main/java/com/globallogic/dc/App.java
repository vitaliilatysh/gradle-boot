package com.globallogic.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan(basePackages = {
        "com.globallogic.dc.connector",
        "com.globallogic.dc.repository.fs.config",
        "com.globallogic.dc.service.config",
        "com.globallogic.dc.controllers"
})
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
