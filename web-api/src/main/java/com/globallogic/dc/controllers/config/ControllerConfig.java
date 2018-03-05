package com.globallogic.dc.controllers.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.globallogic.dc.connector",
        "com.globallogic.dc.repository.fs",
        "com.globallogic.dc.service.impl",
        "com.globallogic.dc.controllers"
})
public class ControllerConfig {
}
