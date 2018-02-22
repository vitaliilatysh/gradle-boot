package com.globallogic.dc.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.globallogic.dc.services", "com.globallogic.dc.repository"})
@Configuration
public class ServiceConfig {
}
