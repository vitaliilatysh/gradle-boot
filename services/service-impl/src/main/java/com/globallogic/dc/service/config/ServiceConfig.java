package com.globallogic.dc.service.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.globallogic.dc.service.impl")
@ConditionalOnProperty(name = "impl", havingValue = "true")
public class ServiceConfig {
}
