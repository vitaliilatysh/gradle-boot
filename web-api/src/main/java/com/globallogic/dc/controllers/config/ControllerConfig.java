package com.globallogic.dc.controllers.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.globallogic.dc.controllers", "com.globallogic.dc.services"})
@Configuration
public class ControllerConfig {
}
