package com.globallogic.dc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.globallogic.dc.connector"
}
)
public class AppConfig {
}
