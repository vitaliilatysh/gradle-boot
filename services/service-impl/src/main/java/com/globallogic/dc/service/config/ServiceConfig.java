package com.globallogic.dc.service.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.globallogic.dc.connector",
        "com.globallogic.dc.repository.fs",
        "com.globallogic.dc.service.impl"
})
public class ServiceConfig {
}
