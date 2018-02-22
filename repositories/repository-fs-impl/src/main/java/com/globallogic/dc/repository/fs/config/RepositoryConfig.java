package com.globallogic.dc.repository.fs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.globallogic.dc.connector", "com.globallogic.dc.repository.fs.impl"})
@Configuration
public class RepositoryConfig {
}
