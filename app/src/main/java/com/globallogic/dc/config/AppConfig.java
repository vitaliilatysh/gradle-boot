package com.globallogic.dc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.globallogic.dc.connector",
        "com.globallogic.dc.controllers",
        "com.globallogic.dc.repository.fs.impl",
        "com.globallogic.dc.services"
}
)
public class AppConfig {
}
